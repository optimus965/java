package stqude;

import javax.swing.*;

class SinglyLinkedList<E> {
    class Node<E> {
        E element;
        Node<E> next;
        Node(E e, Node<E> n) {
            this.element = e;
            this.next = n;
        }
        Node<E> getNext() {
            if(this.next==null) return null;
            return this.next;
        }
        void setNext(Node<E> n) {
            this.next = n;
        }
        public E getElement() {
            return this.element;
        }
    }
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;
    SinglyLinkedList() {

    }
    boolean isEmpty()  {
        return (size==0);
    }
    public E first() {
        if(isEmpty()) return null;
        return head.element;
    }
    public E last() {
        if(isEmpty()) return null;
        return tail.getElement();
    }
    public void addFirst(E e) {
        head = new Node<>(e,head);
        if(isEmpty()) tail = head;
        size++;
    }
    public void addLast(E e) {
        Node<E> new1 = new Node<>(e,null);
        if(isEmpty()) head = new1;
        else tail.setNext(new1);
        tail = new1;
        size++;
    }
    public E removeFirst() {
        if(isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if(size==0) tail = null;
        return answer;
    }
    public E getNext() {
        if(head.next == null) return null;
        return head.next.getElement();
    }
}
