package MultiThread;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-07 08:37
 **/
public class DeadLock {
    public static void main(String[] args) {
        Criminal c = new Criminal();
        Police p = new Police();
        new MyThread(p,c).start();
        c.say(p);//这里：main线程调用罪犯对象c的say方法，罪犯对象c被锁住

    }

    static class MyThread extends Thread{
        private Police p;
        private Criminal c;

        public MyThread(Police p, Criminal c){
            this.p = p;
            this.c = c;
        }

        @Override
        public void run() {
            p.say(c);//这里：子线程调用警察对象p的say方法，警察对象被锁住
        }
    }

    static class Criminal{
        public synchronized void say(Police p){
            System.out.println("罪犯：你放了我，我放了人质");
            p.reply();
        }
        public synchronized void reply(){
            System.out.println("罪犯：我放了人质，我跑了");
        }
    }

    static class Police{
        public synchronized void say(Criminal c){
            System.out.println("警察：你放了人质，我放了你！");
            c.reply();
        }
        public synchronized void reply(){
            System.out.println("警察：我救了人质，罪犯逃跑了");
        }
    }
}
