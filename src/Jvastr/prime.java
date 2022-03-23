package Jvastr;
public class prime {
    public static  boolean prime(int num) {
        int count = 0;
        for(int i = 2; i*i < num;i++) {
            if(num%i == 0)
                count = 1;
            else {
                continue;
            }
        }
        if(count == 1) return false;
        else return true;
    }
    public static void main(String[] args) {
        System.out.println(prime(59));
    }
}
