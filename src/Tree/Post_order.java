package Tree;

class TreeNode {
    TreeNode  rightChild;
    TreeNode leftChild;
    int value;
    TreeNode(int v,TreeNode left,TreeNode right) {
        this.rightChild = right;
        this.leftChild = left;
        this.value = v;
    }
    TreeNode(int v) {
        this(v , null, null);
    }
}
class Tree {
    public void Tree1(TreeNode root) {
        if(root != null) {
            Tree1(root.leftChild);
            Tree1(root.rightChild);
            System.out.println("the values of tree in post order " + root.value);
        }
    }
}
public class Post_order {
}
