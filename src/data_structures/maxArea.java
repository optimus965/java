package data_structures;
class max {
    public int area(int[] arr) {
        int minHeight;
        int currArea= 0, maxArea = 0;
        for( int i = 0 ; i <arr.length;i++) {
            minHeight = arr[i];
            for(int j = i - 1; j >= 0; j--) {
                if(minHeight > arr[j]) {
                    minHeight = arr[j];
                }
                currArea = minHeight * (i - j + 1);
                if(currArea > maxArea) {
                    maxArea = currArea;
                }
            }
        }
        return maxArea;
    }
}
public class maxArea {

}
