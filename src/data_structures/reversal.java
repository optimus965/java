package data_structures;
import java.util.*;
import java.util.Stack;

class reversalParentheses {
    public int reverse(String str) {
        int opencount = 0;
        int closecount = 0;
        Stack<Character> stk = new Stack<Character>();
        for(char c: str.toCharArray()) {
            if(c == '(') {
                stk.push(c);
            }
            else if(c == ')') {
                if(stk.size() != 0 && stk.peek() == '(') {
                    stk.pop();
                }
                else {
                    stk.push(c);
                }
            }
        }
        while (stk.size() != 0) {
            if(stk.pop() == '(') {
                opencount = opencount + 1;
            }
            else {
                closecount = closecount + 1;
            }
        }
        int result = (int)Math.ceil(opencount/2.0) + (int)Math.ceil(closecount/2.0);
        return result;
    }
}

public class reversal {
    public static void main(String args[]) {
        reversalParentheses r1 = new reversalParentheses();
        System.out.println(r1.reverse(")((()))((("));
    }
}
