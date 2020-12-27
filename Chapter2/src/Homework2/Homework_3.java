package Homework2;

import java.util.Scanner;

/**
 * 不借助第三个变量实现交换
 */
public class Homework_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        swap(a,b);

    }

    public static void swap(int a, int b){
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a = "+a+" , b = "+b);
    }
}
