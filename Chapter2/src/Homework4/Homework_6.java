package Homework4;

import java.util.Scanner;

/*
选队长
 */
public class Homework_6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入孩子的数量：");
        int num = in.nextInt();
        System.out.println("队长的编号为：");
        System.out.println(chooseLeader(num));
    }

    public static int chooseLeader(int num) {
        int[] nums = new int[num];

        int size = num;//用于表示当前还剩下多少个孩子
        int count = 1;//用于1，2，3循环叫号
        //队列初始化
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        int i = 0;//用于遍历每一个元素
        while(size > 1) {//循环，直到 size == 1
            if(count == 3){//如果当前叫号为3，将当前位置的孩子置0，同时孩子的数量-1
                nums[i] = 0;
                size--;
            }
            count++;//继续向上叫号
            if (count == 4){//如果当前号码为4，就将号码置 1
                count = 1;
            }
            i = (i+1)%num;//如果遍历用的指针出界了，就置0
            while(nums[i] == 0){//如果当前位置是0了，说明已经没有孩子了，指针继续向下遍历
                i = (i+1)%num;
            }
        }

        for (int n :nums //遍历整个数组，找到唯一的不为0的孩子，就是leader的编号
             ) {
            if (n != 0){
                return n;
            }
        }
        return -1;
    }
}
