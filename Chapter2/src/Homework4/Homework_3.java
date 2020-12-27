package Homework4;

import java.util.Arrays;
import java.util.HashMap;

/*
两数之和
 */
public class Homework_3 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15,3,5,6};
        System.out.println("array: "+Arrays.toString(nums)+", target: "+10+"\nThe result is: ");
        System.out.println(Arrays.toString(twoSum(nums, 10)));
    }

    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
