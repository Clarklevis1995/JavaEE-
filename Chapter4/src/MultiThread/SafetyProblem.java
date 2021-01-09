package MultiThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-06 16:56
 **/
public class SafetyProblem {
    public static void main(String[] args) {
        Runnable r = new Ticket();
        //创建三个线程同时完成一个任务
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();

    }

    static class Ticket implements Runnable{
        private int count = 10;
        Lock l = new ReentrantLock(true);
        @Override
        public void run() {
            while(true){
                l.lock();
                try{
                    if (count>0) {
                        System.out.println("开始卖票");
                        count--;
                        try {//延长售票时间，可以放大冲突产生的可能性
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("卖票结束，余票为：" + count);
                    }else {
                        break;
                    }
                }finally {
                    l.unlock();
                }

            }
        }
    }
}
