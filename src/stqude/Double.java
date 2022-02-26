package stqude;
class DoubleLinkedList<E> {
    class Node<E> {
        E element;
        private Node<E> next;
        private Node<E> prev;
        Node(E e, Node<E> prev, Node<E> next) {
            this.element = e;
            this.next = next;
            this.prev = prev;
        }
        public E getElement() {
            return this.element;
        }
        public Node<E> getNext() {
            return this.next;
        }
        public Node<E> getPrev() {
            return this.prev;
        }
        public void setNext(Node<E> next) {
            this.next = next;
        }
        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;
    public DoubleLinkedList() {
        header  = new Node<>(null,null,null);
        trailer = new Node<>(null,header,null);
        header.setNext(trailer);
    }
    public int size() {return size;}
    private void addBetween(E e,Node<E> predecessor,Node<E> successor) {
        Node<E> newest = new Node<>(e,predecessor,successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> sucessor = node.getNext();
        predecessor.setNext(sucessor);
        sucessor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
    public boolean isEmpty() {
        return (size==0);
    }
    public void addFirst(E e) {
        addBetween(e,header,header.getNext());
    }
    public void addLast(E e) {
        addBetween(e,trailer.getPrev(),trailer);
    }
    public E removeFirst() {
        if(isEmpty()) return null;
        return remove(header.getNext());
    }
    public  E removeLast() {
        if(isEmpty()) return null;
        return remove(trailer.getPrev());
    }
}

