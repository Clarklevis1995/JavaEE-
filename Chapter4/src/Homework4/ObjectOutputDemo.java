package Homework4;

import java.io.*;

/**
 * @program: 开课吧JavaEE
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-04 11:53
 **/
public class ObjectOutputDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Book b = new Book("金苹果","描述了苹果种植");
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d://haha//book.txt"));
//        oos.writeObject(b);
//        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d://haha//book.txt"));
        Object o = ois.readObject();
        System.out.println(o);
        //Book{name='金苹果', info='描述了苹果种植'}
    }

    public static class Book implements Serializable {
        private String name;
        private String info;

        public Book(String name, String info) {
            this.name = name;
            this.info = info;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    ", info='" + info + '\'' +
                    '}';
        }
    }
}
