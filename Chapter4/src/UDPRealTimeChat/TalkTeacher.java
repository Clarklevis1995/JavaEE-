package UDPRealTimeChat;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-10 09:05
 **/
public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkSend(7777, "localhost", 6666)).start();
        new Thread(new TalkReceive(9999, "学生")).start();
    }
}
