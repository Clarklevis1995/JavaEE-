package Homework3;

import java.util.ArrayList;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-22 20:08
 **/
public class demo {
    final int a = 0;
    public static void main(String[] args) {

        int a = 10;
        something(new Person() {
            @Override
            public void say() {
                System.out.println(a);
            }
        });

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        Integer[] result = new Integer[10];
        result = list.toArray(result);

    }

    public static void something(Person p){
        p.say();
    }
}




