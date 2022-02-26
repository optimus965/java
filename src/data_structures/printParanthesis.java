package data_structures;
import java.io.PrintWriter;
import java.util.SplittableRandom;
import java.util.Stack;
class print {
    public void print1(String str) {
        String str1 = "";
        int count = 1;
        Stack<Integer> st4 = new Stack<Integer>();
        for(char c : str.toCharArray()) {
            if(c == '(') {
                st4.push(count);
                str1 += count;
                count = count + 1;
            }
            else if(c == ')') {
                str1 = str1 + st4.pop();
            }
        }
        System.out.println("parentheses count");
        System.out.println(str1);
    }
}

public class printParanthesis {
    public static void main(String args[]) {
      print print2 = new print();
      String str = "(((a+(b))+(c+d)))";
      print2.print1(str);

    }
}
