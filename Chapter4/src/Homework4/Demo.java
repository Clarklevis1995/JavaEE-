package Homework4;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-03 14:37
 **/
public class Demo {
    public static void main(String[] args) throws IOException {
        File file1 = new File("a.txt");
        boolean newFile = file1.createNewFile();
        System.out.println(file1.getAbsolutePath());
    }



}
