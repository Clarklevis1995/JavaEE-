package Homework3;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-23 16:35
 **/
public class demo2 {
    public static void main(String[] args) {
        System.out.println(sum(1,2,3,4,5,6,7));

    }

    public static int sum(int ... nums){
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n+=nums[i];
        }
        return n;
    }
}
