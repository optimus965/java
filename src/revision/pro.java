package revision;
import java.util.HashMap;
import java.util.Map;
class sum {
    Map<Integer,Integer> k1 = new HashMap<>();
    public boolean prime(int n) {
        int count = 0;
        for(int i = 2;i < n;i++) {
            if(n%i== 0)   {
                count = 1;
            }
        }
        if(count == 1) return false;
        else return true;
    }
    public boolean perfe(int n) {
        int temp;
        int sum = 0;
       for(int i = 1 ; i <= n /2;i++) {
           if(n%i == 0) sum = sum + i;
       }
       if(sum == n) return true;
       else return false;
    }
    public int fibanocci(int n) {
        if(n <= 1) return 1;
        return fibanocci(n - 1) + fibanocci(n - 2);
    }
    public int factorial(int n) {
        if(n <= 0) return 1;
        return n * factorial(n - 1);

    }
    public boolean armstrong(int n) {
        int original = n;
        int temp;
        int sum =0;
        while(n > 0) {
            temp = n%10;
            sum = sum+ temp*temp*temp;
            n = n/10;
        }
        if( original == sum) return true;
        else  return false;
    }
    int gcdByBruteForce(int n1, int n2) {
        int gcd = 1;
        for (int i = 1; i <= n1 && i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
    public int sum1(int n) {
        int sum = 0;
        for(int i = 1 ; i <= n;i++) {
            sum = sum + i;
        }
        return sum;
    }
}
public class pro {
    public static void main(String[] args){
        sum prime1 = new sum();
        System.out.println(prime1.sum1(3));

    }
}
