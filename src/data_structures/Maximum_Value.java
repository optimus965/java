package data_structures;
import java.util.*;
class Maxi {
    public int[] max(int[] arr,int k) {
        int maxValue = 0;
        int[] data1 = new int[2];
        int minValue =  99999;
        int size = arr.length;
        ArrayDeque<Integer> deque1 = new ArrayDeque<Integer>();
        for(int i = 0; i <= (size - k);i++) {
            while(deque1.size() > 0 && deque1.peek() <= i-k)  {
                deque1.remove();
            }
            while (deque1.size() > 0 && arr[deque1.peek()] <= arr[i]) {
                deque1.removeLast();
            }
            deque1.add(i);
            if(i>=k-1) {
                if(arr[deque1.peek()] > maxValue) {
                    maxValue = arr[deque1.peek()];
                }
                if(arr[deque1.peek()] < minValue) {
                    minValue = arr[deque1.peek()];
                }
            }
        }
        data1[0] = maxValue;
        data1[1] = minValue;
        return data1;
    }
}
class Maximum_value {
    public static void main(String[] args) {
        Maxi max1 = new Maxi();
        int[] data =  { 11, 2, 75, 92, 59, 90, 55 };
        int[] data1 = max1.max(data,3);
       for(int i= 0; i < 2;i++) {
           if(i==0) {
               System.out.println("the max value is :" + data1[0]);
           }
           else {
               System.out.println("the min value is :"+ data1[1]);
           }
       }

    }

}
