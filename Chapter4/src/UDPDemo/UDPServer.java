package UDPDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-09 16:53
 **/
public class UDPServer {
    public static void main(String[] args) throws IOException {
        //开放端口
        DatagramSocket socket = new DatagramSocket(9000);
        //接收数据包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
        //阻塞接收
        socket.receive(packet);
        //打印接收到的包(接收到的数据是byte数组类型)
        System.out.println(packet.getAddress()+" "+new String(packet.getData()));
        socket.close();

    }
}
