package Homework3;

import java.util.Scanner;

/*
编写用户登陆方法
 */
public class UserService {
    static Scanner in = new Scanner(System.in);
    static User u1 = new User("admin", "123");

    public static void main(String[] args) {
        login();
    }

    public static void login(){
        System.out.println("请输入用户名：");
        String account = in.next();
        System.out.println("请输入密码：");
        String password = in.next();
        if (account.equalsIgnoreCase(u1.getAccount()) && password.equalsIgnoreCase(u1.getPassword())){
            System.out.println("登陆成功，欢迎"+u1.getAccount());
        }

    }
}
