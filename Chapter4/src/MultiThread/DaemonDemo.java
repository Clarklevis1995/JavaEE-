package MultiThread;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-06 16:41
 **/
public class DaemonDemo {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.setDaemon(true);//线程t被设置为守护线程，如果main结束，守护线程就会死亡（要在线程启动之前去设置）
        t.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("main——"+":"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("main线程结束");

    }

    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("守护线程在执行"+":"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
