package Homework3;

/*
三位数中的水仙花数
 */
public class Homework_5 {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            if (isNarcissistic(i)){
                System.out.println(i);
            }
        }
    }

    /**
     * 判断当前数是否是水仙花数
     * @param num 当前数
     * @return
     */
    public static boolean isNarcissistic(int num){
        int result = 0;
        int copy = num;
        while(num>0){
            int remain = num%10;
            result += remain*remain*remain;
            num = num/10;
        }
        return result == copy;
    }
}
