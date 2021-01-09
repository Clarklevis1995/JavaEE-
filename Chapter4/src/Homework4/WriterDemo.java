package Homework4;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-04 08:31
 **/
public class WriterDemo {
    public static void main(String[] args) throws IOException {
//        FileInputStream fis = new FileInputStream("d://haha//c.txt");
//        //将字节输入流转化为字符输入流
//        //参数1：要转换的字节流
//        //参数2：指定编码名称
//        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
//        int c = 0;
//        while((c = isr.read())!=-1){
//            System.out.print((char)c);
//        }
        FileOutputStream fos = new FileOutputStream("d://haha//d.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        osw.write("床前明月光");
        osw.flush();
        osw.close();
    }
}
