package kuangshenWeb;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-08 20:52
 **/
public class TestInetAdd {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("127.0.0.1");
        System.out.println(address);

        InetAddress address1 = InetAddress.getByName("www.baidu.com");
        System.out.println(address1);

        System.out.println(Arrays.toString(address1.getAddress()));
        System.out.println(address1.getCanonicalHostName());
        System.out.println(address1.getHostAddress());
        System.out.println(address1.getHostName());
    }
}
