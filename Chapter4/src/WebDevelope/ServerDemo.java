package WebDevelope;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-08 10:00
 **/
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //创建服务器
        ServerSocket serverSocket = new ServerSocket(55565);
        System.out.println("服务器启动完毕");
        Socket socket = serverSocket.accept();
        System.out.println("一个客户端连接进来了");
        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os);
        ps.println("欢迎连接到服务器");

        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String text = br.readLine();
        System.out.println("收到客户端的问候："+text);

        System.out.println("服务器程序执行结束");



    }
}
