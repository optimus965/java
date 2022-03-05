package Tree;
class TreeNod {
    public boolean main1(Node root,int target) {
        if(root == null) return false;
        if(root.value == target) return true;
       boolean left1 = main1(root.left,target);
       boolean right1 = main1(root.right,target);
       return (left1 || right1);
    }
}
public class Search {
    public static void main(String[] args) {
        TreeNod new1 = new TreeNod();
        Node bot1 = new Node(null,null,3);
        Node bot2 = new Node(null,null,5);
        Node roc = new Node(null,null,7);
        Node second = new Node(bot2,bot1,8);
        Node second1 = new Node(roc,null,2);
        Node root1 = new Node(second,second1,10);
        System.out.println(new1.main1(root1,5));
    }
}
