package ChatDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-09 21:07
 **/
public class UdpReceiver {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);
        byte[] receivedData = new byte[1024];
        DatagramPacket packet = new DatagramPacket(receivedData, 0, receivedData.length);
        socket.receive(packet);

        byte[] data = packet.getData();
        String receive = new String(data, 0, data.length);
        System.out.println(receive);

        socket.close();
    }
}
