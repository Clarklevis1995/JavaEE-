package BookManager.viewing;

import BookManager.bean.Book;
import BookManager.bean.Manager;

import java.util.Scanner;

/*
用户UI
 */
public class View {

    Scanner in = new Scanner(System.in);

    public void welcome(){
        System.out.println("欢迎来到 The Best 图书管理系统");
    }

    /**
     * 选择登录或者注册
     * @return 选项
     */
    public int authentication(){
        System.out.println("1-登录，2-注册");
        int choice = -1;
        try {
            choice = Integer.parseInt(in.nextLine());
        }catch (NumberFormatException e){
            System.out.println("您输入的格式有误，请重新输入：");
            mainMenu();
        }

        if (choice<1 || choice>2){
            System.out.println("输入数据有误，请重新输入：");
            mainMenu();
        }

        return choice;

    }

    public Manager login(){
        System.out.println("------------登录------------");
        System.out.println("请输入您的管理员编号：");
        String input = in.nextLine();
        int stuffNo = -1;
        try {
            stuffNo = Integer.parseInt(input);
        }catch (NumberFormatException e){
            System.out.println("您输入格式有误，请重新输入：");
            login();
        }
        System.out.println("请输入密码：");
        String password = in.nextLine();

        return new Manager(stuffNo, password);
    }

    /**
     * 注册新的管理员
     * @return
     */
    public Manager signUp(){
        System.out.println("------------注册------------");
        System.out.println("请输入您的管理员编号：");
        String input = in.nextLine();
        int stuffNo = -1;
        try {
            stuffNo = Integer.parseInt(input);
        }catch (NumberFormatException e){
            System.out.println("您输入格式有误，请重新输入：");
            signUp();
        }
        System.out.println("请输入密码：");
        String password = in.nextLine();

        return new Manager(stuffNo, password);
    }

    /**
     * 添加管理员成功
     */
    public void addManagerSuccess(){
        System.out.println("管理员添加成功！");
    }

    /**
     * 登陆失败提醒
     */
    public void loginFailed(){
        System.out.println("密码错误，登陆失败！");
    }

    /**
     * 登陆成功提示
     */
    public void loginSuccess(){
        System.out.println("登陆成功！");
    }

    /**
     * 管理员不存在提示
     */
    public void managerNotExists(){
        System.out.println("当前管理员不存在，请重新输入");
    }

    /**
     * 主菜单
     * @return
     */
    public int mainMenu(){
        System.out.println("请选择您要执行的操作：1-添加图书，2-修改图书信息，3-删除图书，4-搜索图书，5-查看所有图书，0-退出系统");
        int choice = -1;
        try {
            choice = Integer.parseInt(in.nextLine());
        }catch (NumberFormatException e){
            System.out.println("您输入的格式有误，请重新输入：");
            mainMenu();
        }

        if (choice<0 || choice>5){
            System.out.println("输入数据有误，请重新输入：");
            mainMenu();
        }

        return choice;
    }

    /**
     * 添加新的书
     * @return 被添加的新书
     */
    public Book addNewBook(){
        System.out.println("请输入新的书名：");
        String name = in.nextLine();
        System.out.println("请输入书的价格：");
        double price = 0;
        while(price == 0) {
            try {
                 price = Double.parseDouble(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("输入格式有误，请重新输入");
                continue;
            }
        }
        System.out.println("请输入日期：格式（xxxx-xx-xx）（年-月-日）)");
        String date = in.nextLine();
        String[] dateArr = date.split("-");
        return new Book(name, price, Integer.parseInt(dateArr[0]),Integer.parseInt(dateArr[1]),
                Integer.parseInt(dateArr[2]));

    }

    /**
     * 更改书的信息
     * @return 要更改的书名
     */
    public String update(){
        System.out.println("请输入要更改的书名：");
        return in.nextLine();
    }

    /**
     * 删除图书信息
     * @return 要删除的书名
     */
    public String delete(){
        System.out.println("请输入要删除的书名：");
        return in.nextLine();
    }

    /**
     * 查找提示
     * @return 要查找的书名
     */
    public String search(){
        System.out.println("请输入要查找的书名：");
        return in.nextLine();
    }

    /**
     * 提示确认删除
     * @param book 要被删除的书
     * @return 选择编号
     */
    public int ensureDelete(Book book){
        System.out.println("您要删除的图书为："+"《"+book.getName()+"》");
        System.out.println("是否确认删除？1-确认，2-取消，0-返回上一级");
        int choice = -1;
        try {
            choice = Integer.parseInt(in.nextLine());
        }catch (NumberFormatException e){
            System.out.println("您输入的格式有误，请重新输入：");
            mainMenu();
        }

        if (choice<0 || choice>2){
            System.out.println("输入数据有误，请重新输入：");
            mainMenu();
        }

        return choice;
    }

    /**
     * 图书更改成功提示
     */
    public void updateSuccess(){
        System.out.println("图书更改成功！");
    }

    /**
     * 删除成功提示
     */
    public void deleteSuccess(){
        System.out.println("删除成功！");
    }

    /**
     * 添加图书成功提示
     * @param book 要添加的图书
     */
    public void addBookSuccess(Book book){
        System.out.println("图书《"+book.getName()+"》添加成功");
    }

    /**
     * 查找的图书不存在提示
     */
    public void bookNotExists(){
        System.out.println("抱歉，您所要查找的图书不存在");
    }

    /**
     * 图书找到提示
     * @param book 找到的图书
     */
    public void bookFound(Book book){
        System.out.println("您查找的图书信息为："+book.toString());
    }

    /**
     * 排序方式
     * @return 选择
     */
    public int browseChoice(){
        System.out.println("请选择排序方式：1-价格从高到低排序，2-价格从低到高排序，3-按照新旧排序");
        int choice = -1;
        try {
            choice = Integer.parseInt(in.nextLine());
        }catch (NumberFormatException e){
            System.out.println("您输入的格式有误，请重新输入：");
            mainMenu();
        }

        if (choice<1 || choice>3){
            System.out.println("输入数据有误，请重新输入：");
            mainMenu();
        }

        return choice;
    }

    /**
     * 数据库为空提示
     */
    public void empty(){
        System.out.println("数据库为空，目前没有图书");
    }

    /**
     * 打印所有图书
     * @param sort
     */
    public void browse(String sort){
        System.out.printf("%-20.20s\t%-5.5s\t%-5.5s\t%-20.20s\n","书名","价格","出版日期","（"+sort+"）");
    }

    /**
     * 退出系统提示
     */
    public void exit(){
        System.out.println("谢谢使用，再见！");
    }
}


