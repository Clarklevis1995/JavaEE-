package Homework3;

import java.util.Scanner;

/*
计算该年该月天数
 */
public class Homework_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = in.nextInt();
        System.out.println("请输入月份：");
        int month = in.nextInt();
        int days = 0;
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: days = 31; break;
            case 2:
                days = isLeapYear(year)? 29: 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11: days = 30; break;
        }
        System.out.println(year+"年"+month+"月有"+days+"天");
    }

    /**
     * 判断当前年份是否是闰年
     * @param year 当前年
     * @return
     */
    public static boolean isLeapYear(int year){
        return (year%100 == 0 && year%400 == 0) || (year%100 != 0 && year%4 == 0);
    }
}
