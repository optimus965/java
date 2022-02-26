package data_structures;
import java.util.*;
import java.util.Stack;
class NextLargetArray {
    Stack<Integer> stack = new Stack<Integer>();
    public void stack1(int[] data) {
        int index =0;
        int[] data1 = new int[data.length];
        for(int i = 0 ; i< data.length;i++) {
            int curr = data[i];
            while(!stack.isEmpty() && (stack.peek() <= curr)) {
                index = stack.pop();
                data1[index] = curr;
            }
        }
        while(!stack.isEmpty()) {
            index = stack.pop();
            data1[index] = -1;
        }
    }
}
public class StockAnalyst {
    public static void main(String args[]) {

    }
}
