package data_structures;
import java.util.*;
import java.util.Stack;
class LongBalance {
    int depth = 0;
    int maxdepth = 0;
    Stack<Character> stack2 = new Stack<Character>();
    public int longBalc(String str) {

        for(char c: str.toCharArray()) {
            if(c == '(')  {
                stack2.push(c);
            }
           if(stack2.isEmpty() && c == ')') {
               continue;
            }
            else if(c == ')') {
                if (stack2.pop() == '(') {
                    depth = depth + 1;
                    continue;
                }
            }
            if(depth >= maxdepth) {
                maxdepth = depth;
            }
            depth = 0;
        }
        return maxdepth;
    }
}
public class longestBalanced {
    public static void main(String argrs[]) {
        LongBalance l1 = new LongBalance();
        System.out.println(l1.longBalc("(())()(()"));
        System.out.println(l1.stack2);
    }
}
