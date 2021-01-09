package Homework4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-04 08:43
 **/
public class ReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("d://haha//c.txt", StandardCharsets.UTF_8);
        char[] chars = new char[100];
        int c = 0;
        while((c = fr.read(chars))!=-1){
            System.out.println(new String(chars, 0, c));
        }
    }
}
