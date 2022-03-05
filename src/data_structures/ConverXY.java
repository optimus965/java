package data_structures;
import java.util.*;
public class ConverXY {
    public int Convert(int[] arr) {
        ArrayDeque<Integer> arr1 =  new ArrayDeque<Integer>();
        int steps = 0;
        int value;
        int index = 0;
        int[] data = new int[100];
        int count = 0;
        arr1.add(arr[0]);
        while(arr1.size() != 0) {
            value = arr1.remove();
            data[index++] = value;
            if (arr[1] == value) {
                for (int i = 0; i < data.length; i++) {
                    System.out.println(data[i]);
                }
                System.out.println("steps count :" + steps);
                return steps;
            }
            steps++;
            if (arr[0] < arr[1]) {
                arr1.add(arr[0] * 2);
            } else {
                arr1.add(value - 1);
            }
        }
        return -1;
    }
}
