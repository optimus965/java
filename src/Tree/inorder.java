package Tree;
import  java.util.*;
import Tree.Post_order;
class inorder1 {
    public void inorder2(TreeNode root) {
        if(root != null) {
            inorder2(root.leftChild);
            System.out.println(root.value);
            inorder2(root.rightChild);
        }
    }
}
class LevelOrder {
    Queue<TreeNode> que1 = new LinkedList<TreeNode>();
    public void LevelOrder(TreeNode root) {
        que1.add(root);
        while(que1.size() != 0)  {
            TreeNode temp = que1.remove();
            System.out.println(temp.value);
            if(temp.leftChild != null) {
                que1.add(temp.leftChild);
            }
            if(temp.rightChild != null) {
                que1.add(temp.rightChild);
            }
        }
    }
}
class DepthFirst {
    Stack<TreeNode> stack2 = new Stack<TreeNode>();
    public void printDepth(TreeNode root) {
        stack2.add(root);
        while(stack2.size() != 0) {
            TreeNode temp = stack2.pop();
            System.out.println(temp.value);
            if(temp.leftChild != null) {
                stack2.push(temp.leftChild);
            }
            if(temp.rightChild != null) {
                stack2.push(temp.rightChild);
            }
        }
    }
}
class Print {
    Stack<Integer> stack2 = new Stack<Integer>();
    public void print(TreeNode root, Stack<Integer> stk) {
        if(root == null) {
            return;
        }
        stk.push(root.value);
        if(root.rightChild == null && root.leftChild == null) {
            System.out.println(stk);
            stk.pop();
            return;
        }
        print(root.rightChild,stk);
        print(root.leftChild,stk);
        stk.pop();
    }
}
class No_of_Nodes {
    public int Nodes(TreeNode node1) {
        if(node1 == null) {
            return 0;
        }
        else {
            return 1 + Nodes(node1.leftChild) + Nodes(node1.rightChild);
        }
    }
    public int Nodes1(TreeNode node1){
        if(node1 == null) {
            return 0;
        }
        return (node1.value + Nodes(node1.leftChild)+Nodes(node1.rightChild));
    }
    public int LeafNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.leftChild == null && root.rightChild ==null) {
            return 1;
        }
        return LeafNodes(root.leftChild) + LeafNodes(root.rightChild);
    }
    public int fullNodes(TreeNode root) {
        int count = 0;
        if(root == null) {
            return 0;
        }
        count = fullNodes(root.rightChild) + fullNodes(root.leftChild);
        if(root.leftChild != null && root.rightChild != null) {
            count++;
        }
        return  count;

    }
    public boolean searching(TreeNode tree,int target) {
        boolean left,right;
        if(tree == null) {
            return false;
        }
        if(tree.value == target) return  true;
        left = searching(tree.leftChild,target);
        if(left) return true;
        right = searching(tree,target);
        if(right) return true;
        return false;
    }

}

