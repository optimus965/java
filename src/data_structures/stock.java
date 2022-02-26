package data_structures;

class stock1 {
    public int[] stock2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
            for (int j = i - 1; (j >= 0) && (arr[i] >= arr[j]); j--) {
                arr[i]++;
            }
        }
        return arr;
    }
}
class stock {
    public static void main(String args[]) {
        stock1 st1 = new stock1();
        int[] data1=  { 6, 5, 4, 3, 2, 4, 5, 7, 9 };
        int[] data = st1.stock2(data1);
        for(int d : data) {
            System.out.println(d);
        }
    }
}
