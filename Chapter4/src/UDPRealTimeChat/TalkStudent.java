package UDPRealTimeChat;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-10 09:01
 **/
public class TalkStudent {
    public static void main(String[] args) {
        //开启两个线程
        new Thread(new TalkSend(8888, "localhost", 9999)).start();
        new Thread(new TalkReceive(6666, "老师")).start();
    }
}
