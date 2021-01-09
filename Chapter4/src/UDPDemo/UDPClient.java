package UDPDemo;

import java.io.IOException;
import java.net.*;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-09 16:53
 **/
public class UDPClient {
    public static void main(String[] args) throws IOException {
        //新建一个Socket
        DatagramSocket socket = new DatagramSocket();
        //建一个数据包
        String s = "你好服务器";
        //参数1：要发送的数据；参数2：要发送数据的偏移量；参数3：要发送数据的长度；参数4：目的地ip；目的地端口
        DatagramPacket packet = new DatagramPacket(s.getBytes(), 0, s.getBytes().length, InetAddress.getByName("localhost"),9000);
        //将包发送出去
        socket.send(packet);
        //关闭流
        socket.close();
    }
}
