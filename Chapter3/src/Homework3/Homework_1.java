package Homework3;

import java.util.Scanner;

/*
计算应缴金额
 */
public class Homework_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int price = in.nextInt();
        int credits = in.nextInt();
        double totalMoney = 0;
        if(credits<2000){
            totalMoney = price * 0.9;
        }else if (credits<4000){
            totalMoney = price * 0.8;
        }else if (credits<8000){
            totalMoney = price * 0.75;
        }else {
            totalMoney = price * 0.7;
        }
        System.out.println("应缴纳"+totalMoney+"元");
    }
}
