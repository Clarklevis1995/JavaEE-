package MultiThread;

import Homework2.MyTree;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-05 18:28
 **/
public class Demo1 {
    //主线程（main线程）
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("线程1——"+i);

                }
            }
        }.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("线程main——"+i);
        }
    }

}

