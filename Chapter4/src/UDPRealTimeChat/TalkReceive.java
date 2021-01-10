package UDPRealTimeChat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-10 08:48
 **/
public class TalkReceive implements Runnable {
    private DatagramSocket socket;
    private int port;
    private String fromWho;

    public TalkReceive(int port, String fromWho) {
        this.port = port;
        this.fromWho = fromWho;
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true){

            try {
                //准备接受包裹
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);
                socket.receive(packet);


                //获得并打印数据
                int len = packet.getLength();//获得的内容长度
                byte[] data = packet.getData();//container包裹的内容，真实长度为container数组的长度
                String receivedText = new String(data, 0, len);
                System.out.println(fromWho+": "+receivedText);

                //收到bye，中断
                if (receivedText.equals("bye")){
                    break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        socket.close();

    }
}
