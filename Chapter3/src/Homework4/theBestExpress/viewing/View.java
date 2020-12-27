package Homework4.theBestExpress.viewing;

import Homework4.theBestExpress.bean.Express;

import java.util.Scanner;

/*
包含了所有的输出界面，欢迎界面，输入界面，结束界面
 */
public class View {
    private Scanner in = new Scanner(System.in);

    public void welcome(){
        System.out.println("欢迎使用 the best 快递柜");
    }

    public int mainMenu(){
        System.out.println("请根据提示选择您的服务：（1-管理员  2-普通用户  0-退出系统）");
        String input = in.nextLine();
        int choice = -1;
        try {
            choice = Integer.parseInt(input);
        }catch (NumberFormatException e){
        }

        if (choice<0 || choice>2){
            System.out.println("输入不合法，请重新输入");
            mainMenu();
        }

        return choice;
    }

    /**
     * 管理员界面
     */
    public int  managerView(){
        System.out.println("你好管理员，请根据提示选择操作：（1-快递录入 2-删除快递 3-修改快递 4-查看所有快递 0-返回上一层）");
        String input = in.nextLine();
        int choice = -1;
        try {
            choice = Integer.parseInt(input);
        }catch (NumberFormatException e){
        }

        if (choice<0 || choice>4){
            System.out.println("输入不合法，请重新输入");
            managerView();
        }

        return choice;
    }

    /**
     * 用户界面
     */
    public void clientView(){
        System.out.println("尊敬的客户您好");
        inputCode();
    }

    /**
     * 用户输入取件码
     * @return 用户输入的正确的取件码
     */
    public int inputCode(){
        System.out.println("请输入取件码：");
        String input = in.nextLine();
        int code = -1;
        try {
            code = Integer.parseInt(input);
        }catch (NumberFormatException e){
        }

        if (code<100000 || code>999999){
            System.out.println("输入不合法，请重新输入");
            return inputCode();
        }
        return code;
    }

    /**
     * 如果取件码对应的快递不存在，提示用户
     */
    public void isNull(){
        System.out.println("快递不存在，请确认后重新输入");
    }

    /**
     * 插入新的快递
     * @return 被插入的快递
     */
    public Express insert(){
        System.out.println("请输入快递单号：");
        String eNumber = in.nextLine();
        System.out.println("请输入快递公司：");
        String eCompany = in.nextLine();
        Express e = new Express();
        e.setNumber(eNumber);
        e.setCompany(eCompany);
        return e;
    }

    /**
     * 取件成功提醒
     * @param e 取出的快递
     */
    public void getSuccess(Express e){
        System.out.print("当前快递为：");
        printExpress(e);
        System.out.println(" 取件成功!");
    }

    /**
     * 添加成功提示，打印取件码
     * @param code 要打印的取件码
     */
    public void addSuccess(int code){
        System.out.println("添加成功，取件码为："+code);
    }

    /**
     * 添加失败提示，柜子满了
     */
    public void addFailed(){
        System.out.println("添加失败，柜子已经满了");
    }

    /**
     * 确认是否要删除当前快递
     * @return
     */
    public int delete(Express express){
        System.out.println("您要删除的快递为：");
        printExpress(express);
        System.out.println("请确认是否要删除？（1-确认 2-重新输入 0-返回）");
        String input = in.nextLine();
        int choice= -1;
        try {
            choice = Integer.parseInt(input);
        }catch (NumberFormatException e){
        }
        if (choice<0 || choice>2){
            return delete(express);
        }
        return choice;
    }

    public void deleteSuccess(){
        System.out.println("删除成功！");
    }

    /**
     * 输入合理包裹单号
     * @return
     */
    public String findByNumber(){
        System.out.println("请输入要处理的包裹单号：");
        String num = in.nextLine();
        return num;
    }

    /**
     * 更新当前快递信息
     * @param e 要被更新信息的快递
     * @return 已经被更新的快递
     */
    public Express update(Express e){
        System.out.println("请输入新的单号：");
        String newNumber = in.nextLine();
        System.out.println("请输入新的快递公司：");
        String newCompany = in.nextLine();
        e.setNumber(newNumber);
        e.setCompany(newCompany);
        return e;
    }

    /**
     * 打印当前的快递信息
     * @param e 当前被打印的快递
     */
    public void printExpress(Express e){
        System.out.println(e.toString()+"\t位置："+e.getLocation().toString());
    }

    /**
     * 提示如果当前单号已经存在
     */
    public void duplicatedNumber(){
        System.out.println("当前单号已存在，请确认后再输入：");
    }

    /**
     * 更新快递成功提示
     * @param e 已经更新完的新的快递
     */
    public void updateSuccess(Express e){
        System.out.println("更新完成！当前快递信息为：");
        printExpress(e);
    }


    /**
     * 退出界面
     */
    public void byeView(){
        System.out.println("谢谢使用，再见！");
    }

    /**
     * 空柜子警告
     */
    public void empty(){
        System.out.println("柜子是空的！");
    }


}
