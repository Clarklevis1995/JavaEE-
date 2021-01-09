package TCPDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-09 13:10
 **/
public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);
        //1. 等待客户端连接
        Socket socket = server.accept();
        //2. 获得输入流
        InputStream is = socket.getInputStream();
        //3. 创建转存文件
        File file = new File("d://haha//receive.jpg");
        //4. 文件输出
        FileOutputStream fos = new FileOutputStream(file);
        byte[] buffer = new byte[1024*1024];
        int len;
        while((len = is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }

        //通知客户端已接收完毕
        OutputStream os = socket.getOutputStream();
        os.write("我已经接收完毕，你可以断开连接了".getBytes());

        fos.close();
        is.close();
        socket.close();
        server.close();

    }
}
