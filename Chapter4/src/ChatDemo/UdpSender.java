package ChatDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-09 21:07
 **/
public class UdpSender {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(6666);

        while(true) {
            Scanner in = new Scanner(System.in);
            String sendText = in.nextLine();
            byte[] data = sendText.getBytes();

            DatagramPacket packet = new DatagramPacket(data, 0, data.length, InetAddress.getByName("192.168.124.8"), 9999);
            socket.send(packet);
            if (sendText.equals("bye")){
                break;
            }
        }
        socket.close();

    }
}
