package Tree;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
class treeD {
    int maxValue = -999;
    Queue<Integer> que  = new ArrayDeque<>();
    Stack<Integer> stack  = new Stack<Integer>();
    int count2 = 0;
    int maxvalue9 = -99999;
    public void tree(Node root) {
        if(count2 == 0) {
            stack.add(root.value);
        }
        count2 = 9;

        int maxvalue2 = -99;
        if(root == null) {
            que.remove();
            return;
        }
        if(root.left != null) {
            que.add(1);
            stack.add(root.left.value);
            tree(root.left);
            if(stack.size() != 0) {
                stack.pop();
            }
            que.remove();
        }
        if(root.right != null) {
            que.add(1);
            stack.add(root.right.value);
            tree(root.right);
            que.remove();
            if(stack.size() != 0) {
                stack.pop();
            }
        }
        List<Integer> stack1 = stack;
        int temp = 0;
        while (!stack1.isEmpty()) {
            temp = temp + stack1.remove(0);
        }
        if(temp > maxvalue9) {
            maxvalue9 = temp;
        }
        if(que.size() > maxValue) {
            maxValue = que.size();
        }

    }
    public int[] max1() {
        int[] data = new int[2];
        data[0] = this.maxValue;
        data[1] = this.maxvalue9;
        return data;
    }
}
public class treeDepth {
    public static void main(String[] args) {
        treeD tree1 = new treeD();
        Node bot1 = new Node(null,null,3);
        Node bot2 = new Node(null,null,5);
        Node roc = new Node(null,null,7);
        Node second = new Node(bot2,bot1,8);
        Node second1 = new Node(roc,null,2);
        Node root1 = new Node(second,second1,10);
        tree1.tree(root1);
        int[] data1 =tree1.max1();
        for(int x:data1) {
            System.out.println(x);
        }
    }
}
