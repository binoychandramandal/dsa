package pepcoding.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void setHead(Node head) {
        this.head = head;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Add new Node at last
     *
     * @param data
     */
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public Integer getFirst() {
        return isEmpty() ? null : head.data;
    }

    public Integer getLast() {
        return isEmpty() ? null : tail.data;
    }

    public Integer getAt(int index) {
        if (index < 0 || index >= size()) {
            return null;
        } else {
            Node tem = head;
            for (int i = 0; i < index; i++) {
                tem = tem.next;
            }
            return tem != null ? tem.data : null;
        }
    }

    public void addAt(int index, int data) {
        if (index < 0 || index > size) {
            System.out.println("Invalid argument");
            return;
        } else if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node newNode = new Node(data);
            Node tmp = head;
            for (int i = 0; i < index - 1; i++) {
                tmp = tmp.next;
            }

            newNode.next = tmp.next;
            tmp.next = newNode;
            size++;
        }
    }

    public void display() {
        Node tmp = head;
        while (tmp != null) {
            if (tmp.next != null) {
                System.out.print(tmp.data + ", ");
            } else {
                System.out.print(tmp.data);
            }
            tmp = tmp.next;
        }
        System.out.println();
    }

    public Integer removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if (head.next == null) {
            tail = null;
        }
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public Node getNodeAt(int index) {
        Node tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

    /**
     * Without modify address. only data change
     */
    public void reverse() {
        int li = 0;
        int ri = size - 1;
        while (li < ri) {
            Node left = getNodeAt(li);
            Node right = getNodeAt(ri);
            int tempData = left.data;
            left.data = right.data;
            right.data = tempData;
            li++;
            ri--;
        }
    }

    /**
     *  modify address. only data change
     */
    public void reverseWithAddress() {
        Node prev = null;
        Node cur = head;
        while (cur!=null){
            Node next =cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        head=prev;
    }
    public Integer removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (size == 1) {
            return removeFirst();
        }
        Node tmp = head;
        Node prev = null;
        while (tmp.next != null) {
            prev = tmp;
            tmp = tmp.next;
        }
        int data = tail.data;
        tail = prev;
        prev.next = null;
        size--;
        return data;
    }

    public Integer removeAt(int index) {
        if (isEmpty() || index<0 || index>=size) {
            return null;
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == size-1) {
            return removeLast();
        }
       Node nodeAt=getNodeAt(index-1);
        int data = nodeAt.next.data;
        nodeAt.next=nodeAt.next.next;
        size--;
        return data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Node getHead() {
        return head;
    }
    public Node getTail() {
        return tail;
    }


}
