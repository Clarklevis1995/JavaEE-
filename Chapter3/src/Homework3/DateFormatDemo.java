package Homework3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatDemo {
    public static void main(String[] args) throws ParseException {
        /*
        y--年
        M--月
        d--日
        H--时
        m--分
        s--秒
         */
        //format:将date对象转化为字符串（yyyy年MM月dd日 HH时mm分ss秒）
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String text = format.format(new Date());
        System.out.println(text);//2020年12月27日 09时53分19秒

        //parse,将yyyy年MM月dd日 HH时mm分ss秒转换成毫秒数：
        Date date = format.parse("2020年12月12日 9时12分52秒");
        System.out.println(date.getTime());//1607735572000
    }
}
