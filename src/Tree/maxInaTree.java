package Tree;
class max2 {
    int maxValue = -9999;
    public void max1(Node root) {
        if(root == null) return;
        max1(root.left);
        max1(root.right);
        if(root.value > maxValue) {
            maxValue = root.value;
        }
    }
    public int max2() {
        return this.maxValue;
    }
}

public class maxInaTree {
    public static void main(String[] args) {
        max2  max1 =new max2();
        Node bot1 = new Node(null,null,300000000);
        Node bot2 = new Node(null,null,5);
        Node roc = new Node(null,null,700000);
        Node second = new Node(bot2,bot1,8);
        Node second1 = new Node(roc,null,2);
        Node root1 = new Node(second,second1,1000);
        max1.max1(root1);
        System.out.println(max1.max2());
    }
}
