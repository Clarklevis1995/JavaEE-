package Homework4;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-04 10:57
 **/
public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
//        Properties pr =  new Properties();
//        pr.put("name","金苹果");
//        pr.put("info","讲述了苹果种植过程");
//        FileWriter fw = new FileWriter("d://haha//book.properties");
//        pr.store(fw,"The books in store");
//        fw.close();
        Properties pr = new Properties();
        FileReader reader = new FileReader("d://haha//book.properties");
        pr.load(reader);
        System.out.println(pr.get("name"));
        System.out.println(pr.get("info"));
    }
}
