package main;



import bean.Express;
import dao.DataOperation;
import viewing.View;

import javax.xml.crypto.Data;
import java.io.*;

/**
 * 主要逻辑
 */
public class Main {
    private View v;
    DataOperation dao;

    public static void main(String[] args) {
        //clearData();
        Main main1 = new Main();
        main1.init();
        main1.start();
    }

    private void start(){
        mainLogic();
    }

    /**
     * 初始化整个系统
     */
    private void init(){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("BestExpress/src/data.txt"));
            Object o = ois.readObject();
            if (o instanceof DataOperation){
                dao = (DataOperation) o;
            }else {
                dao = new DataOperation();
            }
        }catch (EOFException f){
            System.out.println("数据库目前为空");
            dao = new DataOperation();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        v = new View();
        v.welcome();
    }

    private static void clearData(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("BestExpress/src/data.txt"));
            oos.writeObject(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mainLogic(){
        int mainChoice = v.mainMenu();
        switch (mainChoice){
            case 1: managerLogic(); break;
            case 2: clientLogic(); break;
            case 0: byeLogic();break;//v.byeView();
        }
    }

    /**
     * 退出逻辑
     */
    private void byeLogic() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("BestExpress/src/data.txt"))){
            oos.writeObject(dao);
        } catch (IOException e) {
            e.printStackTrace();
        }
        v.byeView();
    }

    /**
     * 管理员逻辑
     */
    private void managerLogic(){
        int managerChoice = v.managerView();
        switch (managerChoice){
            case 1: insertLogic(); break;
            case 2: deleteLogic(); break;
            case 3: updateLogic(); break;
            case 4: browseLogic(); break;
            case 0: mainLogic();break;
        }
    }

    private void browseLogic() {
        if (dao.getSize() == 0){
            v.empty();
            managerLogic();
        }else {
            dao.browse(v);
            managerLogic();
        }
    }

    private void updateLogic() {
        String num = v.findByNumber();
        Express oldE = dao.findByNumber(num);
        if (oldE == null){
            v.isNull();
            updateLogic();
        }else {
            Express newE = v.update(oldE);
            dao.update(oldE, newE);
            v.updateSuccess(newE);
            managerLogic();
        }
    }

    private void deleteLogic() {
        String num = v.findByNumber();
        Express e = dao.findByNumber(num);
        if (e == null){
            v.isNull();
            deleteLogic();
        }else {
            int i = v.delete(e);
            switch (i){
                case 1: {
                    dao.remove(e);
                    v.deleteSuccess();
                    managerLogic();
                    deleteLogic();
                    break;
                }
                case 2: deleteLogic(); break;
                case 0: managerLogic(); break;
            }
        }
    }

    /**
     * 管理员投放逻辑
     */
    private void insertLogic() {
        Express e = v.insert();
        if (dao.findByNumber(e.getNumber()) != null){
            v.duplicatedNumber();
            insertLogic();
        }
        if(dao.add(e)){
            v.addSuccess(Integer.parseInt(e.getCode()));
            managerLogic();
        }else {
            v.addFailed();
            insertLogic();
        }
    }

    /**
     * 用户取快递的逻辑
     */
    private void clientLogic(){
        int code = v.inputCode();
        Express e = dao.findByCode(code);
        if (e == null){
            v.isNull();
        }else {
            dao.remove(e);
            v.getSuccess(e);
            mainLogic();
        }
    }


}
