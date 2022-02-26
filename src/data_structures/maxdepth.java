package data_structures;
import java.util.*;
import java.util.Stack;
class maxdepth1 {
    int depth = 0;
    int maxdepth;
    public int maxdepth(String str) {
        Stack<Character> stack1 = new Stack<Character>();
        for(char c: str.toCharArray()) {
            if(c == '(') {
                depth = depth + 1;
            }
            else if(c == ')')  {
                depth = depth - 1;
            }
            if(depth > maxdepth) {
                maxdepth = depth;
            }
        }
        return maxdepth;
    }
}
class maxdepth {
    public static void main(String args[]) {
        maxdepth1 d1 = new maxdepth1();
        String str = "((()))()";
        System.out.println(d1.maxdepth(str));
    }
}
