package  data_structures;
import java.util.*;
import java.util.Stack;
class nextLargerElement  {
    public int[] next1(int[] data) {
        int size = data.length;
        int curr,index;
        Stack<Integer> st1 = new Stack<Integer>();
       for(int i = 0; i < (2*data.length-1);i++) {
           curr = data[i%size];
           while(!st1.isEmpty() && st1.peek() <= curr) {
               index = st1.pop();
               data[index] = curr;
           }
           st1.push(i%size);
       }
       while(st1.isEmpty() == false) {
           index = st1.pop();
           data[index] = -1;
       }
       return data;
    }
}
class newClass {
    public static void main(String args[]) {
        nextLargerElement new1 = new nextLargerElement();
        int[] data = {6, 3, 9, 8, 10, 2, 1, 15, 7};
        int[] data1 = new1.next1(data);
        for(int x:data1) {
            System.out.println(x);
        }
    }

}