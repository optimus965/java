package stqude;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
public class cloning {
    public static void main(String args[]) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(2);
        System.out.println("Contents of the array" + al);
         System.out.println("Array isempty"+ al.isEmpty());
        al.remove(al.size()-1);
        al.removeAll(al);
        System.out.println("Array IsEmpty" + al.isEmpty());
    }
}
