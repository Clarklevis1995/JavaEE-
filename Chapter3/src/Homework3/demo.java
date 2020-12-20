package Homework3;

import java.util.Scanner;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-19 12:56
 **/
public class demo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if(in.hasNextInt()){
            int num = in.nextInt();
            System.out.println("输入的数据为："+num);
        }else {
            System.out.println("输入的内容为："+in.next());
        }
    }
}
