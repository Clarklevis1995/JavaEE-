package Homework4;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-21 08:28
 **/
public class demo {
    public static void main(String[] args) {
        int[] nums = {12,13,23,76,87,98,0,1,5,3,6,45};
        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        System.out.println("max: "+max+" , min: "+min);

        System.out.println("-------------------");
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("-------------------");
        System.out.println(binarySearch(nums, 12));
    }

    public static void bubbleSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length-i; j++) {
                if (nums[j]<nums[j-1]){
                    swap(nums, j, j-1);
                }
            }
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int binarySearch(int[] nums, int target){
        int max = nums.length-1;
        int min = 0;
        int mid = (max+min)/2;
        while(min<=max){
            if(target>nums[mid]){
                min = mid+1;
            }else if(target<nums[mid]){
                max = mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
