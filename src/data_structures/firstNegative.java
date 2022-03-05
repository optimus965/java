package data_structures;
import java.util.*;
class firstNegative1 {
    public void first(int[] arr,int k) {
        ArrayDeque<Integer> new1 = new ArrayDeque<Integer>();
        for(int i = 0; i < arr.length;i++) {
           if(new1.size()>0 && new1.peek() <=(i -k)) {
               new1.remove();
           }
           if(arr[i] < 0) {
               new1.add(i);
           }
           if(i >= (k -1)) {
               if(new1.size()>0) {
                   System.out.println(arr[new1.peek()]);
               }
               else
                   System.out.println("NAN");
           }
        }
    }
}
class firstNegative {
    public static void main(String[] args) {
        firstNegative1 new1 = new firstNegative1();
        int[] data = { 3, -2, -6, 10, -14, 50, 14, 21 };
        new1.first(data,3);
    }

}
