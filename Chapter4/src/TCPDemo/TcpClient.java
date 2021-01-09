package TCPDemo;

import java.io.*;
import java.net.Socket;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-09 13:09
 **/
public class TcpClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",9999);
        //1. 获得文件输入
        FileInputStream fis = new FileInputStream(new File("d://壁纸//1039782.jpg"));
        //2. 获得输出流
        OutputStream os = socket.getOutputStream();
        //3. 写出文件
        byte[] buffer = new byte[1024*1024];
        int len;
        while((len = fis.read(buffer))!=-1){
            os.write(buffer, 0, len);
        }

        //通知服务器L已经发送成功
        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String s = br.readLine();
        System.out.println(s);



    }
}
