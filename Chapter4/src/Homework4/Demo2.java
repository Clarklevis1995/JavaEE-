package Homework4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-03 17:30
 **/
public class Demo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("a.txt");
        byte[] bytes = new byte[100];
        int len = fis.read(bytes);
        System.out.println(new String(bytes, 0, len));

        fis.close();

    }
}
