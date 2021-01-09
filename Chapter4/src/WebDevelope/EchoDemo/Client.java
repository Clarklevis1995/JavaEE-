package WebDevelope.EchoDemo;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-08 11:15
 **/
public class Client {
    public static void main(String[] args) throws IOException {
        //连接服务器
        Socket socket = new Socket("127.0.0.1",8888);
        //得到输出流
        OutputStream os = socket.getOutputStream();
        //将输出流转化为打印流
        PrintStream ps = new PrintStream(os);
        //得到输入流
        InputStream is = socket.getInputStream();
        //将字节输入流转化为字符输入流
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        //循环接收用户的输入
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("请输入要发送给服务器的内容：");
            String text1 = input.nextLine();
            //将用户输入的内容发送给服务器
            ps.println(text1);
            //接收服务器的回复消息
            String text2 = br.readLine();
            System.out.println(text2);
            if ("886".equals(text1)){//如果客户端发送的内容为886，则终止循环
                break;
            }
        }
    }
}
