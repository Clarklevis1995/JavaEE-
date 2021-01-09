package Homework2;

/*
测试二叉树
 */
public class MyTreeTest {
    public static void main(String[] args) {
        MyTree tree = new MyTree();
        tree.add(4);
        tree.add(2);
        tree.add(5);
        tree.add(1);
        tree.add(3);
        tree.add(6);
        System.out.println("先序遍历");
        tree.preOrder(tree.root);
        System.out.println("\n中序遍历");
        tree.inOrder(tree.root);
        System.out.println("\n后序遍历");
        tree.postOrder(tree.root);


    }
}
