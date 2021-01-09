package WebDevelope.EchoDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-08 11:15
 **/
public class Server {
    public static void main(String[] args) throws IOException {
        //启动服务器
        ServerSocket server = new ServerSocket(8888);
        //打印提示
        System.out.println("服务器已启动，等待客户端连接中...");
        //等待客户端连接
        Socket socket = server.accept();
        //获取客户端的ip地址
        System.out.println("一个客户端连接成功："+socket.getInetAddress().toString());
        //获取输入流
        InputStream is = socket.getInputStream();
        //将输入流转化为字符流
        BufferedReader br = new BufferedReader(new InputStreamReader(is));


        //获取输出流
        OutputStream os = socket.getOutputStream();
        //将字节输出流转化为打印流
        PrintStream ps = new PrintStream(os);
        while (true){
            //循环读取一行一行的数据，读取操作会阻塞线程，直到客户端真的发送了数据，才会继续执行下面的代码
            String text = br.readLine();
            //将这个文字再打印给客户端
            ps.println("服务器："+text);
            if ("886".equals(text)){
                break;
            }
        }
    }
}
