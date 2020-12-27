package Homework4;

import java.util.Scanner;

/*
查找某个整数
 */
public class Homework_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println("Please input a target: ");
        int target = in.nextInt();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                System.out.println("The target's index is: "+i);
                break;
            }
        }
    }
}
