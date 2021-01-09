package MultiThread;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-05 22:51
 **/
public class GetThreadName {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        new Thread(new NewRunnable()).start();
        new Thread(new NewRunnable()).start();
        new Thread(new NewRunnable()).start();
        new Thread(new NewRunnable()).start();
    }


}
class NewRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
