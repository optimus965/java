package data_structures;
import java.util.*;
class minSliding1 {
    public int[] Window(int[] arr,int k) {
        int maxValue = -9999;
        int minValue = 99999;
        int[] data = new int[2];
        ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
        for(int i = 0;i <= (arr.length-k);i++) {
            if(deq.size()>0 && deq.peek() <= (i-k)) {
                deq.remove();
            }
            while(deq.size() > 0 && arr[deq.peekLast()] >= arr[i]) {
                deq.remove();
            }
            deq.add(i);
            if(i>=k-1 && arr[deq.peek()] < minValue ) {
                minValue = arr[deq.peek()];
            }
            if(i>=k-1 && arr[deq.peek()] > maxValue) {
                maxValue = arr[deq.peek()];
            }
        }
        data[0] = minValue;
        data[1] = maxValue;
        return data;
    }

}
class minSliding {
    public static void main(String[] args) {
        minSliding1 new1 = new minSliding1();
        int[] data =  { 11, 2, 75, 92, 59, 90, 55 };
        int[] data1 = new1.Window(data,3);
        int count = 0;
        for(int i: data1) {
            if(count == 0) {
                System.out.println("Min value of the given windows is :" + i);
            }
            else {
                System.out.println("Maxvalue is:" + i);
            }
            count = count + 1;
        }
    }
}
