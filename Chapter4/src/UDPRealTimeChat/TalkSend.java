package UDPRealTimeChat;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-10 08:38
 **/
public class TalkSend implements Runnable {

    private DatagramSocket socket = null;
    private int fromPort;
    private String toIp;
    private int toPort;
    Scanner in = null;

    public TalkSend(int fromPort, String toIp, int toPort) {

        this.fromPort = fromPort;
        this.toIp = toIp;
        this.toPort = toPort;

        try {
            socket = new DatagramSocket(fromPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        in = new Scanner(System.in);


    }

    @Override
    public void run() {
        while(true){

            try {
                String data = in.nextLine();
                byte[] datas = data.getBytes();
                DatagramPacket packet = new DatagramPacket(datas,0,datas.length,InetAddress.getByName(toIp),toPort);
                socket.send(packet);

                if (data.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        socket.close();
    }
}
