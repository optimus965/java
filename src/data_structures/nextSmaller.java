package data_structures;

class nextSmaller1 {
    public int[] next(int[] data) {
        int[] data2 = new int[data.length];
        int j = 0;
        for(int i = 0 ; i < data.length;i++) {
            for(j = i+1;j < data.length;j++) {
                if(data[j] < data[i]) {
                    data[i] = data[j];
                    break;
                }
                else {
                    data[i] = -1;
            }
            }
            if(j == data.length) {
                data[j - 1] = -1;
            }
        }
        return data;
    }
}
class nextSmaller {
    public static void main(String args[]) {
       nextSmaller1 new1 = new nextSmaller1();
       int[] data = { 4, 3, 2,1,0,9};
       int[] data1 =  new1.next(data);
       for(int x: data1) {
           System.out.println(x);
       }
    }
}

