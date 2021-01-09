package Homework2;

/*
实现单向链表
 */
public class MyLinkedList {

    Node head;
    int size;

    class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }

        public String toString(){
            return this.value+"";
        }
    }

    /**
     * add方法
     * @param value 要被添加的值
     * @return true：添加成功
     */
    public boolean add(int value){
        Node node = new Node(value);
        Node cur = head;
        if (cur == null){
            head = node;
        }else {
            while(cur.next!=null){
                cur = cur.next;
            }
            cur.next = node;

        }
        size++;
        return true;
    }

    /**
     * 删除对应下标的值
     * @param index 要删除的下标
     * @return 被删除的下标对应的值
     */
    public Node remove(int index){
        Node removed = null;
        if (index == 0){
            head = head.next;
        }else {
            Node cur = head;
            for (int i = 0; i < index-1; i++) {
                cur = cur.next;
            }
            removed = cur;
            cur.next = cur.next.next;
        }
        size--;
        return removed;
    }

    /**
     * 遍历打印的方法
     * @return
     */
    public String toString(){
        StringBuilder s = new StringBuilder();
        if (size == 0){
            return null;
        }
        Node node = head;
        while(node != null){
            s.append(node.toString());
            if (node.next!=null){
                s.append("->");
            }
            node = node.next;
        }
        return s.toString();
    }

}
