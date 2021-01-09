package WebDevelope;

import java.io.*;
import java.net.Socket;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-08 10:00
 **/
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.124.21",55565);
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String text = br.readLine();
        System.out.println("客户端收到消息："+text);

        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os);
        ps.println("服务器你好");



    }
}
