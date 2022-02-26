package data_structures;

import java.util.ArrayList;
import java.util.Arrays;

// stack can be implemented using array or linked list
//stack using array
class Stack {
    private int[] data;
    int size = 0;
    int Capacity;
    Stack(int n) {
        this.Capacity = n;
        data = new int[this.Capacity];
    }
    Stack() {
        this(5);
    }
    public boolean isEmpty() {
        return size==0;
    }
    public int size() {
        return size;
    }
    public void print() {
        for(int i  = size-1; i >= 0;i--) {
            System.out.println("  " + data[i]);
        }
    }
    public void push(int value)  {
        if (size() == data.length)  {
            this.Capacity = this.Capacity*2;
            int[] newData = new int[this.Capacity];
            System.arraycopy(data,0,newData,0,data.length);
            data = newData;
        }
        data[size] = value;
        size++;
    }

    public int pop() {
        if(isEmpty()) throw new IllegalStateException("stack is underflow");
        int temp = data[size - 1];
        size--;
        if(size() == this.Capacity/2) {
            this.Capacity  =Capacity/2;
            int[] newdata =  Arrays.copyOf(data,size);
            data = newdata;
        }
        return temp;
    }
}

public class stack1 {
        public static void main(String args[]) {
            Stack st1 = new Stack();
            st1.push(10);
            st1.push(20);
            st1.push(30);
            for(int i = 4; i < 11; i ++) {
                st1.push(i*10);
            }
            System.out.println(st1.size());
        }
}

