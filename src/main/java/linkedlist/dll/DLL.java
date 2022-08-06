package linkedlist.dll;

public class DLL {
    private Node head;
    private Node tail;
    private int size;


    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    void addFirst(int data) {
        addFirst(new Node(data));
    }

    void addFirst(Node newNode) {
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    Node addLast(int data) {
       return  addLast(new Node(data));
    }
    Node addLast(int key,int data) {
        return  addLast(new Node(key,data));
    }

    Node  addLast(Node newNode) {
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return newNode;
    }

    void removeFirst() {
        if (!isEmpty()) {
            if (size() == 1) {
                tail = head = null;
            } else {
               head=head.next;
               head.prev=null;
            }
            size--;
        }
    }

    Node getAt(int index){
        if(isEmpty() || index<0 || index>=size){
            return null;
        }
        Node cur=head;
        for (int i = 0; i < index; i++) {
            cur=cur.next;
        }
        return  cur;
    }

    void removeNode(Node node){
        if(!isEmpty()){
            if(size()==1 && head==node){
                head=tail=null;
            }else if(head==node){
                  head=head.next;
                  head.prev=null;
            }else if(tail==node){
                tail = tail.prev;
                tail.next.prev=null;
                tail.next=null;
            }else{
                node.next.prev=node.prev;
                node.prev.next=node.next;
            }
            size--;
        }
    }



    void removeLast() {
        if (!isEmpty()) {
            if (size() == 1) {
                tail = head = null;
            } else {
               tail= tail.prev;
                tail.next.prev=null;
                tail.next=null;
            }
            size--;
        }
    }
    void displayForward(){
        Node  cur =head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }

    void displayBackward(){
        Node  cur =tail;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.prev;
        }
        System.out.println();
    }

    Node getHead(){
        return head;
    }

    Node getTail(){
        return tail;
    }
}


