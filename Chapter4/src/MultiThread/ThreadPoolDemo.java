package MultiThread;

import java.util.concurrent.*;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-07 19:17
 **/
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"-啦啦啦");
            }
        },5,1,TimeUnit.SECONDS);
    }


}
