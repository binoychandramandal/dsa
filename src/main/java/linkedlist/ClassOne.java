package linkedlist;

public class ClassOne {
    public static void main(String[] args) {

        Node head = createNode(1);
        display(head);
        System.out.println(size(head));
        System.out.println(size1(head));
        //// System.out.println(getKthElement(head,0));

        Node h1 = null;
        h1 = insertAt(h1, 1, 0);
        h1 = insertAt(h1, 10, 1);
        display(h1);
        h1 = insertInSortedList(h1, 3);
        h1 = insertInSortedList(h1, 0);
        h1 = insertInSortedList(h1, 40);
        h1 = insertInSortedList(h1, -1);
        display(h1);
        h1=reverse(new Node(1,new Node(2)));
        display(h1);
    }

    static Node reverse(Node head){
        if(head==null){
            return null;
        }
        Node cur=head;
        Node prev=null;
        while (cur!=null){
            Node next =cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }

    /**
     * Insert into sorted linked list
     * @param head
     * @param data
     * @return
     */
    static Node insertInSortedList(Node head, int data) {
        Node cur = head;
        Node prev = null;
        while (cur != null) {
            if (cur.data > data) {
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        Node newNode = new Node(data);
        if (prev == null) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        return head;
    }

    /**
     * Insert at given position
     *
     * @param head
     * @param data
     * @param position
     * @return
     */
    static Node insertAt(Node head, int data, int position) {
        int size = size(head);
        if (position < 0 || position > size + 1) {
            System.out.println("Illegal argument");
            return head;
        }

        Node newNode = new Node(data);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        Node cur = head;
        for (int i = 1; i < position - 1; i++) {
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        return head;
    }

    /**
     * Using two pointer concept
     *
     * @param head
     * @return
     */
    static int size1(Node head) {
        Node cur = head;
        Node s = head;
        Node f = head;
        int count = 0;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            count++;
        }
        count *= 2;

        return f == null ? count : count + 1;
    }

    /**
     * Get kth index value
     *
     * @param head
     * @param k    index
     * @return
     */
    static int getKthElement(Node head, int k) {
        Node cur = head;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }
        return cur.data;

    }

    /**
     * Generate 1 to N node and return head of linkedlist
     *
     * @param numberOfNode
     * @return
     */
    static Node createNode(int numberOfNode) {
        Node head = new Node(1);
        Node cur = head;
        for (int i = 2; i <= numberOfNode; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
        return head;
    }

    /**
     * Get the size of linked list
     *
     * @param head
     * @return
     */
    static int size(Node head) {
        Node cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }

        return count;
    }

    /**
     * Display entire list
     *
     * @param head
     */
    static void display(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}



