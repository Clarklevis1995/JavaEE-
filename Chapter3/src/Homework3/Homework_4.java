package Homework3;

/*
打印九九乘法表
 */
public class Homework_4 {
    public static void main(String[] args) {
        //column x line = column * line
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+"*"+i+"="+j*i+"\t");
            }
            System.out.println();
        }
    }
}