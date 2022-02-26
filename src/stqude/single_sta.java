package stqude;
class LinkedList {
    class Node {
        private int value;
        private Node next;
        public Node(int value,Node n) {
            this.next = n;
            this.value = value;
        }
    }
    private Node head = null;
    private int size = 0;
    public void addHead(int value) {
        head = new Node(value,head);
        size++;
    }
    public void addTail(int value) {
        Node temp = head;
        Node temp1 = new Node(value , null);
        if(head == null) {
            head = temp1;
        }
        else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = temp1;
        }
        size++;
    }
    public void print() {
        Node temp;
        temp = head;
        while(temp!= null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    public void sortedInsert(int value) {
        Node temp2 = new Node(value, null);
        Node temp = head;
        if(head == null || head.value > value) {
            addHead(value);
        }
        while(temp.next != null && temp.next.value < value) {
            temp = temp.next;
        }
        temp2.next = temp;
        temp.next = temp2;
        size++;
    }
    public boolean searchList(int data) {
        Node temp;
        temp = head;
        while(temp != null) {
            if(temp.value == data) {
                return true;
            }
            temp  = temp.next;
        }
        return false;
    }
    private boolean isEmpty() {
        return size==0;
    }
    public int removeHead() throws IllegalStateException {
        if(isEmpty()) throw new IllegalStateException("EmptyListException");
        int value = head.value;
        head = head.next;
        size--;
        return value;
    }
    public boolean deleteNode(int delvalue) {
        Node temp = head;
        if (isEmpty()) return false;
        if (delvalue == head.value) {
            head = head.next;
            size--;
            return true;
        }
        while (temp.next != null) {
            if (temp.next.value == delvalue) {
                temp.next = temp.next.next;
                size--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public void deleteNodes(int delValue) {
        while(head != null && head.value == delValue) {
            head = head.next;
            head = head;
        }
        Node tmp = head;
        while(tmp.next != null) {
            if(tmp.next != null && tmp.next.value == delValue) {
                tmp.next = tmp.next.next;
                size--;
            }
            tmp = tmp.next;
        }
    }
    public void deleteList() {
        head = null;
        size = 0;
    }
    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next = null;
        while(curr != null) {
           next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
        }
        head = prev;
    }
    public void removeDuplicate() {
        Node curr = head;
        while(curr!= null) {
            if(curr.next!=null && curr.next.value == curr.value) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
    }
    public LinkedList copyLinkdList() {
        Node tempNode = null;
        Node tempNode2 = null;
        Node curr = head;
        while(curr!=null) {
            tempNode =  new Node(curr.value,tempNode);
            curr = curr.next;
        }
        LinkedList ll2 = new LinkedList();
        ll2.head = tempNode;
        return ll2;
    }
    public boolean compareLists(LinkedList ll) {
        return compareList(head,ll.head);
    }
    public boolean compareList(Node head,Node head2)  {
        if(head == null && head2 == null) {return true;
        }
        else if(head == null|| head2 == null || head.value != head2.value) {
            return false;
        }
        else {
            return compareList(head.next,head2.next);
        }
    }

}
class single_sta {
    public static void main(String args[]) {
        LinkedList new1 = new LinkedList();
        new1.addHead(4);
        new1.addHead(8);
        new1.addHead(5);
        new1.addHead(2);
        new1.print();
        LinkedList new3 = new1.copyLinkdList();
        System.out.println("    ");
        new3.print();
    }
}