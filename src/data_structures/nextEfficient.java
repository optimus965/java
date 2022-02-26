package data_structures;
import java.net.Inet4Address;
import java.util.Stack;
class nextSmaller12 {
    public int[] next1(int[] arr) {
        int index = 0;
        int[] data1 = new int[arr.length];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            while(!stack.isEmpty() && arr[stack.peek()] > curr ) {
                index = stack.pop();
                data1[index] = curr;
            }
            stack.push(i);
        }
        while(stack.isEmpty() == false) {
            index = stack.pop();
            data1[index] = -1;
        }
        return data1;
    }
}
public class nextEfficient {
    public static void main(String args[]) {
        nextSmaller12  new1 = new nextSmaller12();
        int[] data = {2,3,1};
        int[] data3 = new1.next1(data);
        for(int x: data3) {
            System.out.println(x);
        }
    }
}
