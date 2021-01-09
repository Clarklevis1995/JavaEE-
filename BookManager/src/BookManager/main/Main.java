package BookManager.main;

import BookManager.bean.Book;
import BookManager.bean.Manager;
import BookManager.dao.DataOperation;
import BookManager.viewing.View;

import java.io.*;

/**
 * 主程序
 */
public class Main {
    DataOperation dao;
    View view;

    private void init(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("BookManager/src/BookManager/data.txt"));
            Object o = ois.readObject();
            if (o instanceof DataOperation){
                dao = (DataOperation) o;
            }else{
                dao = new DataOperation();
            }
        }catch (EOFException e){
            System.out.println("数据库为空");
            dao = new DataOperation();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        view = new View();
    }

    public void start(){
        init();
        view.welcome();
        authenticate();
    }

    public static void main(String[] args) {
        Main main1 = new Main();
        main1.start();
    }

    private void authenticate(){
        int choice = view.authentication();
        switch (choice){
            case 1: loginProcess(); break;
            case 2: signUpProcess();break;
        }
    }

    /**
     * 登录过程
     */
    private void loginProcess(){
        Manager m = view.login();
        if (dao.getStuffDatabase().get(m.getStuffNo())==null){
            view.managerNotExists();
            authenticate();
        }else {
            if (dao.getStuffDatabase().get(m.getStuffNo()).equals(m)){
                view.loginSuccess();
                mainLogic();
            }else {
                view.loginFailed();
                loginProcess();
            }
        }
    }

    private void mainLogic() {
        int choice = view.mainMenu();
        switch(choice){
            case 1: addLogic();break;
            case 2: updateLogic(); break;
            case 3: deleteLogic(); break;
            case 4: searchLogic(); break;
            case 5: browseLogic(); break;
            case 0: exitLogic(); break;
        }
    }

    /**
     * 添加图书的逻辑
     */
    private void addLogic(){
        Book book = view.addNewBook();
        dao.addBook(book);
        view.addBookSuccess(book);
        mainLogic();
    }

    /**
     * 更改图书逻辑
     */
    private void updateLogic(){
        String bookName = view.update();
        Book oldBook = dao.search(bookName);
        if (oldBook == null){
            view.bookNotExists();
            updateLogic();
        }else {
            Book newBook = view.addNewBook();
            dao.update(oldBook, newBook);
            view.updateSuccess();
            mainLogic();
        }
    }

    private void deleteLogic(){
        String bookName = view.delete();
        Book beDelete = dao.search(bookName);
        if (beDelete == null){
            view.bookNotExists();
            deleteLogic();
        }else {
            int i = view.ensureDelete(beDelete);
            switch (i){
                case 1: dao.remove(beDelete); view.deleteSuccess(); mainLogic(); break;
                case 2: deleteLogic();break;
                case 3: mainLogic();break;
            }
        }
    }

    /**
     * 搜索逻辑
     */
    private void searchLogic(){
        String name = view.search();
        Book book = dao.search(name);
        if (book==null){
            view.bookNotExists();
        }else {
            view.bookFound(book);
        }
        mainLogic();
    }

    private void exitLogic(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("BookManager/src/BookManager/data.txt"))){
            oos.writeObject(dao);
        }catch (IOException e){
            e.printStackTrace();
        }
        view.exit();
    }

    /**
     * 全部遍历逻辑
     */
    private void browseLogic(){
        if (dao.getSize() == 0){
            view.empty();
            mainLogic();
        }
        int sortChoice = view.browseChoice();
        String sort = "";
        switch(sortChoice){
            case 1: dao.sortByPriceDown(); sort = "SortByPriceDown"; break;
            case 2: dao.sortByPriceUp(); sort = "SortByPriceUp"; break;
            case 3: dao.sortByDate(); sort = "SortByDate"; break;
        }
        view.browse(sort);
        dao.browse();
        mainLogic();
    }



    /**
     * 注册过程
     */
    private void signUpProcess(){
        Manager m = view.signUp();
        dao.getStuffDatabase().put(m.getStuffNo(),m);
        view.addManagerSuccess();
        authenticate();
    }
}
