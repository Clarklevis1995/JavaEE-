package Homework4;

import java.util.Arrays;

/*
将数组中的0都移动到末尾
 */
public class Homework_5 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        System.out.println("移动之前: ");
        System.out.println(Arrays.toString(nums));
        moveZero(nums);
        System.out.println("移动之后: ");
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZero(int[] nums){
        int tail = nums.length-1;
        int head = 0;
        while (head<=tail) {
            if (nums[head] == 0){
                for (int j = head; j < tail; j++) {
                    nums[j] = nums[j+1];
                }
                nums[tail--] = 0;
            }
            if (nums[head]!=0){
                head++;
            }
        }
    }
}
