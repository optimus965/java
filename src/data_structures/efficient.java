package data_structures;
import java.util.*;
import java.util.Stack;
class alter {
    public int max(int[] arr) {
        int size = arr.length;
        Stack<Integer> st1 = new Stack<Integer>();
        int maxArea = 0;
        int topArea;
        int top;
        int i = 0;
       while(i < size) {
           while(i < size &&(st1.isEmpty() || st1.peek() <= arr[i])) {
               st1.push(i);
               i++;
           }
           while(!st1.isEmpty() && (i== size || arr[st1.peek()] > arr[i])) {
               top = st1.peek();
               st1.pop();
               topArea = arr[top]*(st1.isEmpty()?i:i-st1.peek()-1);
               if(maxArea < topArea) {
                   maxArea = topArea;
               }
           }
       }
        return maxArea;
    }
}
public class efficient {
}
