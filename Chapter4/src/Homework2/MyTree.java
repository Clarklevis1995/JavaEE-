package Homework2;

/*
实现二叉树
 */
public class MyTree {
    TreeNode root;
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value){
            this.value = value;
        }

        public String toString(){
            return this.value+"";
        }
    }

    public boolean add(int value){
        TreeNode node = new TreeNode(value);
        if (root == null){
            root = node;
        }else {
            TreeNode cur = root;
            while(cur != null) {
                if (value > cur.value) {
                    if (cur.right == null){
                        cur.right = node;
                    }
                    cur = cur.right;
                } else if (value < cur.value) {
                    if (cur.left == null){
                        cur.left = node;
                    }
                    cur = cur.left;
                } else {
                    break;
                }
            }
        }
        return true;
    }

    /**
     * 先序遍历
     * @param root 树根
     */
    public void preOrder(TreeNode root){
        if (root == null){
            return;
        }
        System.out.print(root.value+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     * @param root 树根
     */
    public void inOrder(TreeNode root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.value+" ");
        inOrder(root.right);
    }

    /**
     * 后序遍历
     * @param root 树根
     */
    public void postOrder(TreeNode root){
        if (root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value+" ");
    }
}
