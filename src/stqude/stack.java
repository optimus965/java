package stqude;
interface Stack<E> {
    void push(E n);
    E pop();
    boolean isEmpty();
    E top();
    int size();
}
class ArrayStack<E> implements Stack<E> {
    int sz = 0;
    E n1;
    E[] data;
    ArrayStack(int n) {
        data = (E[]) new Object[n];
    }
    ArrayStack() {
        this(1000);
    }

    public void push(E n) {
        data[sz] = n;
        sz++;
    }
    public E pop() {
        if(sz==0) throw new IllegalStateException("there is no chance to pop");
        E temp = data[sz-1];
        data[sz-1] = null;
        sz--;
        return temp;
    }
    public boolean isEmpty() {
        return (sz == 0);
    }
    public E top() {
        if(isEmpty()) return null;
        return data[sz -1];
    }
    public int size() {
        return sz;
    }
}