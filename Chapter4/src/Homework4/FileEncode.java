package Homework4;

import java.io.*;
import java.util.Scanner;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-03 18:24
 **/
public class FileEncode {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入绝对路径：");
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();
        File oldFile = new File(path);//旧文件
        File newFile = new File(oldFile.getParent(), "mi-"+oldFile.getName());//根据父路径和子路径创建新文件
        FileInputStream fis = new FileInputStream(oldFile);//输入流
        FileOutputStream fos = new FileOutputStream(newFile);//输出流
        //加密解密算法
        int value = 0;
        while((value = fis.read())!=-1){
            fos.write(value^10);//一个数据对同一个数据进行两次异或，结果是不变的
        }
        fis.close();
        fos.close();
        System.out.println("加密/解密完成");
    }
}
