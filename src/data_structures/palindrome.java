package data_structures;
import java.util.Stack;

class palindrom {
    public void palindrom(String str) {
        int i = 0;
        Stack<Character> string1 = new Stack<Character>();
        char[] data = str.toCharArray();
        if(data.length%2 == 0) {
            for(i = 0; i < (data.length)/2;i++){
                string1.push(data[i]);
            }
            for(i = i;i< data.length;i++) {
                if(string1.pop() == data[i]) {
                    continue;
                }
                else {
                    System.out.println("the given string is not a palindrome");
                    break;
                }
            }


        }
        else {
            System.out.println("the given number is a palindrome");

        }
        if(data.length%2 == 1) {
            for(i = 0; i < (data.length-1)/2;i++) {
                string1.push(data[i]);
            }
            for(i = i+1;i < data.length;i++) {
                if(string1.pop() == data[i]) {
                   continue;
                }
                else {
                    System.out.println("the given number is not a palindrome");
                }
            }
            System.out.println("the given string is a palindrome");
        }
    }
}
class largestIsland {
    public static void main(String args[]) {
        palindrom pal1  = new palindrom();
        pal1.palindrom("AABBBCCCBBBAAA");
    }
}
