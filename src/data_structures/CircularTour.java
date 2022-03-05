package data_structures;
import java.util.*;

class CircularTour1 {
    public int[] next(int[][] arr,int n) {
       ArrayDeque<Integer> que1 = new ArrayDeque<Integer>();
       int nextPump = 0;
       int prevPump = 0;
       int petrol = 0;
       int count = 0;
       while(que1.size() != n) {
           petrol =0;
           while(petrol>=0 && que1.size() != n) {
               que1.add(nextPump);
               petrol += (arr[nextPump][0] - arr[nextPump][1]);
               nextPump = (nextPump + 1) %n;
            }
           while(petrol < 0 && que1.size() > 0) {
               prevPump = que1.remove();
               petrol -= (arr[prevPump][0] - arr[prevPump][1]);
           }
           count += 1;
           if(count == n) {
               return null;
           }
       }
       if(petrol >= 0) {
           return arr[que1.remove()];
       }
       else {
           return null;
       }
    }
}
class CircularTour {
    public static void main(String args[]) {
        CircularTour1 new1 = new CircularTour1();
        int[][] data  =  { { 8, 6 }, { 1, 4 }, { 7, 6 } };
        int[] data1 = (new1.next(data,3));
        for(int x: data1) {
            System.out.println(x);
        }
    }

}
