package Homeword1;

import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
    public static void main(String[] args) {
        Calendar c1 = Calendar.getInstance();

        //获取真实的最大数量：
        //比如获取当前月的最大天数
        int maxDays = c1.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(maxDays);//31  当前是12月，当然是31天

        for (int i = 0; i < 12; i++) {
            c1.set(Calendar.MONTH, i);
            maxDays = c1.getActualMaximum(Calendar.DAY_OF_MONTH);
            System.out.println(i+1+"月有"+maxDays+"天");
        }
        //1月有31天
        //2月有29天
        //3月有31天
        //4月有30天
        //5月有31天
        //6月有30天
        //7月有31天
        //8月有31天
        //9月有30天
        //10月有31天
        //11月有30天
        //12月有31天



    }
}
