package Tree;
import java.util.*;
import java.util.*;
public class sum {
    public static void main(String[] args) {
       Stack<Integer> new1 = new Stack<>();
       int count2 = 5;
       while(count2 >= 0) {
           new1.add(count2);
           count2--;

       }
       System.out.println(new1);
        List<Integer> stack1 = new1;
        int temp = 0;
        while (!stack1.isEmpty()) {
            temp = temp + stack1.remove(0);

        }
       System.out.println(temp);

    }

}
