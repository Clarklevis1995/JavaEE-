package Homework3;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-30 18:16
 **/
public class demo {
    public static void main(String[] args) throws IOException {
        File dir = new File("D://haha/ha/ha");
        File file1 = new File("D://haha.txt");
        File file2 = new File("D://haha/ha/a.txt");
        file1.renameTo(file2);

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
    }
}
