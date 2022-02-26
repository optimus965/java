package data_structures;
import java.util.*;
import java.util.Stack;

public class Balanced {
    public boolean isBalanced(String expn) {
        Stack<Character> stack = new Stack<Character>();
        for(char ch: expn.toCharArray()) {
            switch(ch) {
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;
                case '}':
                    if(stack.pop() != '{') {
                        return false;
                    }
                case ']':
                    if(stack.pop() != '[') {
                        return false;
                    }
                case ')':
                    if(stack.pop() != '(') {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }
 }
