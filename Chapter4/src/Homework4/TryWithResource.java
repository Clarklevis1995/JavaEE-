package Homework4;

import javax.imageio.IIOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-04 12:44
 **/
public class TryWithResource {
    public static void main(String[] args) throws FileNotFoundException {
        //JDK1.7的时候(放在try（）中的流必须实现了 Closable或者 AutoCloseable接口)
//        try(FileReader fr = new FileReader("d://haha//b.txt")){//流会在结束后自动关闭
//            int c = fr.read();
//            System.out.println((char)c);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        FileReader fr = new FileReader("d://haha//b.txt");
        PrintWriter pw = new PrintWriter("d://haha//e.txt");
        try(fr;pw){//JDK1.9之后可以传入已经创建好的流对象，且可以为多个流对象
            int c = fr.read();
            System.out.println((char)c);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
