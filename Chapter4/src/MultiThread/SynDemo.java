package MultiThread;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-06 17:42
 **/
public class SynDemo {
    public static void main(String[] args) {
        Runnable r = new Ticket();
        //创建三个线程同时完成一个任务
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();

    }

    static class Ticket implements Runnable{
        private int count = 10;
        Object o = new Object();//任何对象都可以作为锁对象传入同步代码块
        @Override
        public void run() {
            while(true){
                if (!sellTicket()){
                    break;
                }

            }
        }

        public synchronized boolean sellTicket(){
            if (count>0) {
                System.out.println("开始卖票");
                count--;
                try {//延长售票时间，可以放大冲突产生的可能性
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"卖票结束，余票为：" + count);
                return true;
            }
            return false;
        }
    }
}
