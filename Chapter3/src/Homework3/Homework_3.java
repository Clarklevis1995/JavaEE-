package Homework3;

/*
图形打印
 */
public class Homework_3 {
    public static void main(String[] args) {
        System.out.println("-----Demo1-----");
        printDemo1();
        System.out.println("-----Demo2-----");
        printDemo2();
        System.out.println("-----Demo3-----");
        printDemo3();
    }

    public static void printDemo1(){
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printDemo2(){
        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printDemo3(){
        //*:2*n-1
        //" ": 5-n
        for (int i = 1; i <= 5 ; i++) {
            for (int j = 0; j < 5-i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
