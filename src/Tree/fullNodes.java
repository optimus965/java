package Tree;
import java.util.*;
class Node {
    Node left;
    Node right;
    int value;
    Node(Node right1,Node left1, int value1) {
        this.right = right1;
        this.left = left1;
        this.value = value1;
    }
}
 class fullNodes1{
    List<Integer> list1 = new ArrayList<>();
    int count = 0;
    public void full(Node root) {
        if(root == null) {
            return;
        }
        if(root.left != null) {
            full(root.left);
        }
        if(root.right != null) {
            full(root.right);
        }
        if(root.right != null && root.left != null) {
            count++;
            list1.add(root.value);
        }
    }
    int[] data = new int[10];
    int count5 = 0;
    public int[] noof() {
      for(int c:list1) {
          data[count5++] = c;
      }
      return  data;
    }
}
class fullNodes {
    public static void main(String[] args) {
        fullNodes1 full1 = new fullNodes1();
        Node bot1 = new Node(null,null,3);
        Node bot2 = new Node(null,null,5);
        Node roc = new Node(null,null,7);
        Node second = new Node(bot2,bot1,8);
        Node second1 = new Node(roc,null,2);
        Node root1 = new Node(second,second1,10);
        full1.full(root1);
        int[] data6 = full1.noof();
        for(int c:data6) {
            System.out.println(c);
        }
    }

}

