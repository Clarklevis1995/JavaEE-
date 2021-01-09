package Homework2;

import java.util.*;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-28 12:34
 **/
public class demo {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("A");
        set.add("E");
        for (String s:set
             ) {
            System.out.println(s);
        }
        Map<String, String > map = Map.of("haha1","1111","haha2","2222");
    }
}
