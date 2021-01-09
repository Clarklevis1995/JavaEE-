package MultiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-07 18:01
 **/
public class CallableDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> c = new MyCallable();
        FutureTask<Integer> task = new FutureTask<>(c);
        new Thread(task).start();
        int result = task.get();
        System.out.println("子线程返回："+result);
        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            System.out.println("主线程--"+i);
        }
    }

    static class MyCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(100);
                System.out.println("子线程——"+i);
            }
            return 100;
        }
    }
}
