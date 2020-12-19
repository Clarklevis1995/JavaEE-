package Homework1;

import java.util.Scanner;

/**
 * 求5位数字各位只和
 */
public class Homework_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(sum(in.nextInt()));
    }

    public static int sum(int a){
        int result = 0;
        while(a>0){
            result += a%10;
            a = a/10;
        }
        return result;
    }
}
