package MultiThread;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-07 21:35
 **/
public class LambdaDemo {
    public static void main(String[] args) {
        print((int x, int y)->{return x+y;}, 100, 200);
    }

    public static void print(MyMath m, int x, int y){
        int sum = m.sum(x, y);
        System.out.println(sum);
    }

    //注意：接口中必须只能有一个方法
    static interface MyMath{
        public int sum(int x, int y);
    }
}
