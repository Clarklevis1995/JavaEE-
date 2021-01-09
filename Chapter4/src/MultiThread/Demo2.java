package MultiThread;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-05 19:57
 **/
public class Demo2 {
    public static void main(String[] args) {
        //1. 创建一个任务对象
        MyRunnable r = new MyRunnable();
        //2. 创建一个线程，并为其分配一个任务
        Thread t = new Thread(r);
        //3. 执行这个线程
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("线程main——"+i);
        }
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程2——" + i);
        }
    }
}
