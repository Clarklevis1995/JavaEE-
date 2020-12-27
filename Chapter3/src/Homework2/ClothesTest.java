package Homework2;

/*
通过类描述衣服，每个衣服对象创建的时候需要自动生成一个序号值
 */
public class ClothesTest {
    public static void main(String[] args) {
        System.out.println(new Clothes());
        System.out.println(new Clothes());
        System.out.println(new Clothes());
        System.out.println(new Clothes());
        System.out.println(new Clothes());
    }
}

class Clothes{
    private static int seq = 0;
    private int singleSeq;//用于将静态变量的值存储在单个对象中
    public Clothes() {
        seq++;
        singleSeq = seq;
    }
    public String toString(){
        return "clothes-"+singleSeq;
    }
}
