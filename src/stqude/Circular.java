package stqude;
class CircularLinkedList<E> {
    class Node<E> {
        E element;
        Node<E> next;
        Node(E e,Node<E> n) {
            this.element = e;
            this.next = n;
        }
        Node<E> getNext() {
            if(this.next == null) return null;
            return this.next;
        }
        void setNext(Node<E> n) {
            this.next = n;
        }
        E getElement() {
            return this.element;
        }
    }
    private Node<E> tail;
    private int size = 0;
    boolean isEmpty() {
        return (size==0);
    }
    public void rotate() {
        Node<E> temp = tail;
        while(temp!= null) {
            temp = temp.next;
            System.out.println(temp.element);
        }
    }
    void addFirst(E e) {
       if(isEmpty()) {
           tail = new Node<>(e,null);
           tail.setNext(tail);
       }
       else {
           Node<E> newest = new Node<>(e,tail.getNext());
           tail.setNext(newest);
       }
       size++;
    }
    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }
    public E removeFirst() {
        if(isEmpty()) return null;
        Node<E> head = tail.getNext();
        if(head == null) tail = null;
        else tail.setNext(head.getNext());
        size--;
        return head.getElement();
    }
}
