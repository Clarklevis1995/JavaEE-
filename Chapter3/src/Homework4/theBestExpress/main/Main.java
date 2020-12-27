package Homework4.theBestExpress.main;

import Homework4.theBestExpress.bean.Express;
import Homework4.theBestExpress.dao.DataOperation;
import Homework4.theBestExpress.viewing.View;

import javax.print.attribute.standard.Finishings;

/**
 * 主要逻辑
 */
public class Main {
    private View v;
    DataOperation dao;

    public static void main(String[] args) {
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
        v = new View();
        dao = new DataOperation();
        v.welcome();
    }

    private void mainLogic(){
        int mainChoice = v.mainMenu();
        switch (mainChoice){
            case 1: managerLogic(); break;
            case 2: clientLogic(); break;
            case 0: v.byeView();
        }
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
            case 0: mainLogic();
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
