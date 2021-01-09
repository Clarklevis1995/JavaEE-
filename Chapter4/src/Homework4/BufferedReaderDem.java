package Homework4;

import java.io.*;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-04 10:27
 **/
public class BufferedReaderDem {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("d://haha//c.txt");
        BufferedReader br = new BufferedReader(fr);
        String text = null;
        while((text = br.readLine())!=null){//readLine()一次读取一行，如果到了末尾，返回null
            System.out.println(text);
        }
    }
}
