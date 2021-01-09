package MultiThread;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-06 16:15
 **/
public class Interrupt {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());//开启新的线程
        t.start();
        for (int i = 0; i < 5; i++) {//只循环五次，之后就停止子线程
            System.out.println(Thread.currentThread().getName()+":"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //通过给子线程打中断标记的方法让子线程自己终止
        t.interrupt();

    }

    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+":"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //当捕捉到中断异常的时候会来到这里，可以在这里采取对这个子线程的操作
                    System.out.println("发现了中断标记，线程开始死亡");
                    return;//直接调用return方法，就可以终止这个线程
                }
            }
        }
    }
}
