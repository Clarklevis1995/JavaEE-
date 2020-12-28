package Homeword1;

import java.util.Date;

public class demo3 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        long time = date.getTime()-(60*60*24*1000);
        Date date2 = new Date(time);
        System.out.println(date2);
        //Sun Dec 27 09:36:56 CST 2020
        //Sat Dec 26 09:36:56 CST 2020
    }
}
