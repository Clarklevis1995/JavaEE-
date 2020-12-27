package Homeword1;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-25 19:23
 **/
public class Person <T> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
