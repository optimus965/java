package Jvastr;

class numbe1 {
    public boolean solver(int[] numbers,int number, int start) {
        if(number == 24 || number == -24) return true;
        if(start >= 4) return false;
        for(int i = 0 ; i< 4;i++) {
            if(i == 0) {
                int temp = number;
                number = number + numbers[start];
                if(solver(numbers, number,start + 1)) return true;
                number = temp;
            }
            if(i == 1) {
                int temp = number;
                number = number - numbers[start];
                if(solver(numbers,number, start + 1)) return true;
                number = temp;
            }
            if(i == 2) {
                int temp = number;
                number = number * numbers[start];
                if(solver(numbers, number,start + 1)) return true;
                number = temp;
            }
            if(i== 3) {
                int temp = number;
                number  = number / numbers[start];
                if(solver(numbers, number, start + 1)) return true;
                number = temp;
            }
        }
        return false;
    }
}

public class numbers {
    public static void main(String[] args)  {
        numbe1 check = new numbe1();
        int[] array = {1,8,2,5};
        System.out.println(check.solver(array,0,0));
    }
}
