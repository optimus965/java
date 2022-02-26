package data_structures;
import java.util.*;
import java.util.EmptyStackException;
import java.util.IllformedLocaleException;
import java.util.Stack;

class StackLL {
    private class Node {
        private int val;
        private Node next;
        public Node(int value,Node next) {
            this.val = value;
            this.next = next;
        }
        private Node head = null;
        private int size = 0;
        public int size() {
            return  size();
        }
        public boolean isEmpty() {
            return size==0;
        }
        public int peek() throws IllegalStateException {
            if(isEmpty()) {throw new IllegalStateException("stack Empty Exception");}
            return head.val;
        }
        public void push(int value) {
            head = new Node(value,head);
            size++;
        }
        public int pop() throws  IllegalStateException {
            if(isEmpty()) {
                throw new IllegalStateException("Stack Empty exception");
            }
            Node temp = head;
            head  = head.next;
            return head.val;
        }
        public void print() {
            Node temp = head;
            while(temp!= null) {
                System.out.println(temp.val);
                temp = temp.next;
            }
        }

    }

}
class Sorted {
    void sortedInsert(Stack<Integer> stk, int element) {
        int temp;
        if(stk.isEmpty() || (element > stk.peek())) {
            stk.push(element);
        }
        else {
            temp = stk.pop();
            sortedInsert(stk,element);
            stk.push(temp);
        }
    }
}

public class linkedsStack {
    public static void main(String args[]) {
        StackLL st  = new StackLL();

    }
}
