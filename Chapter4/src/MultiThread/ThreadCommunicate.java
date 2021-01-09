package MultiThread;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-07 10:16
 **/
public class ThreadCommunicate {
    //多线程通信，生产者与消费者关系
    public static void main(String[] args) {
        Food food = new Food();
        new Cook(food).start();
        new Waiter(food).start();
    }

    static class Cook extends Thread{
        private Food food;
        public Cook(Food f){
            this.food = f;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                if (i%2==0){
                    food.setNameAndTaste("老干妈炒饭","香辣味");
                }else {
                    food.setNameAndTaste("水果捞","香甜味");
                }
            }
        }
    }

    static class Waiter extends Thread{
        private Food food;
        public Waiter(Food f){
            this.food = f;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                //每0.1s端一道菜
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                food.get();
            }
        }
    }

    static class Food{
        private String name;
        private String taste;
        private Boolean flag = true;//flag为true的时候可以做饭
        public synchronized void setNameAndTaste(String name, String taste){
            if (flag){//如果为true，厨师开始做饭
                this.name = name;
                //休眠一段时间，可以让冲突更容易发生
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.taste = taste;
                flag = false;
            }
            this.notifyAll();//当前拥有food的monitor的线程，调用notifyAll方法，去唤醒正在等待当前food对象的monitor的所有其他线程
            try {
                this.wait();//
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized void get(){
            if (!flag){
                System.out.println("服务员端出：菜名："+name+"，味道："+taste);
                flag = true;
                this.notifyAll();
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
