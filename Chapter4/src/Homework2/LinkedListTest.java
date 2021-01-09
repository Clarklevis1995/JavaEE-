package Homework2;

/*
实现单向链表
 */
public class LinkedListTest {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println("链表的长度：");
        System.out.println(list.size);
        System.out.println("遍历整个链表：");
        System.out.println(list.toString());

        //移除下标为3的数
        System.out.println("移除下表为3的数");
        list.remove(3);
        System.out.println(list.toString());
    }

}
