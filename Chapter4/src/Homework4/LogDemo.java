package Homework4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-04 10:46
 **/
public class LogDemo {
    public static void main(String[] args) throws FileNotFoundException {
        try{
            String s = null;
            s.toCharArray();
        }catch (Exception e){
            PrintWriter pw = new PrintWriter("d://haha//log.txt");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            pw.println(sdf.format(new Date()));
            e.printStackTrace(pw);
            pw.close();
        }
    }
}
