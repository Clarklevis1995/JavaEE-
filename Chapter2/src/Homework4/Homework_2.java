package Homework4;

import java.util.Scanner;

/*
找出数组的最值
 */
public class Homework_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }
        int max = nums[0];
        int min = nums[1];

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        System.out.println("The max number is: "+max+"\n"+"The min number is: "+min);
    }
}
