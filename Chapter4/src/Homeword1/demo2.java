package Homeword1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-26 10:27
 **/
public class demo2 {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("1.001");
        BigDecimal b2 = new BigDecimal("2.000001");

        System.out.println(b1.add(b2));//+
        System.out.println(b1.subtract(b2));//-
        System.out.println(b1.multiply(b2));//*
        System.out.println(b1.divide(b2,10, RoundingMode.HALF_EVEN));// /

        int[] arr = new int[10];
        int[] a = Arrays.copyOf(arr, 10);
        String s = "";
        s.replace('a','\0');
    }
}
