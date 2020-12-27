package Homework4;

import java.util.Arrays;

/*
排序并查找
 */
public class Homework_4 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 9, 5, 6, 7, 15, 4, 8};
        bubbleSort(nums);
        System.out.println("排序之后的数组为：");
        System.out.println(Arrays.toString(nums));
        System.out.println("-------------------");
        System.out.println("6 所在的下标为： "+binarySearch(nums, 6));


    }

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (right + left) / 2;
        while (left <= right) {
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
