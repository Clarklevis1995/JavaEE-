package Homework1;

import java.util.Scanner;

/**
 * 判断该5位正整数是不是回文数
 */
public class Homework_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        System.out.println(isPalindrome(a));
    }

    public static boolean isPalindrome(int a){
        int copy = a;
        int reflect = 0;
        while(a>0){
             reflect = reflect*10+a%10;
             a /= 10;
        }
        return copy == reflect;
    }
}
