package Homework2;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-22 13:00
 **/
public class demo {
    public static void main(String[] args) {
        Person person = new Person();
    }
}

class Person{
    private String name;
    private int age;

    {
        System.out.println("对象创建的时候执行1");
    }

    static {
        System.out.println("静态代码块在类加载时执行");
    }

    public Person(){
        System.out.println("对象创建的时候执行2");
    }
}
