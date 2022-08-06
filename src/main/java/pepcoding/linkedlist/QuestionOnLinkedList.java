package pepcoding.linkedlist;

public class QuestionOnLinkedList {

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        l.addLast(4);
        //l.addAt(4,5);
        l.display();
        System.out.println(kthFromLast(l, 2));
        System.out.println(kthFromLast(l, 0));

        System.out.println(getMiddle(l));


        LinkedList l1 = new LinkedList();
        l1.addLast(1);
        l1.addLast(3);
        l1.addLast(4);
        l1.addLast(7);
        l1.addLast(30);

        LinkedList l2 = new LinkedList();
        l2.addLast(2);
        l2.addLast(5);
        l2.addLast(6);
        l2.addLast(8);
        LinkedList result = mergeTwoSortedList(l1, l2);
        result.display();

        System.out.println(getMiddle1(l1.getHead(), l1.getTail()).data);


        LinkedList l3 = new LinkedList();
        l3.addLast(2);
        l3.addLast(20);
        l3.addLast(9);
        l3.addLast(6);
        l3.addLast(1);

        LinkedList res1 = mergeSort(l3.getHead(), l3.getTail());
        res1.display();


        LinkedList l4 = new LinkedList();
        l4.addLast(2);
        l4.addLast(2);
        l4.addLast(3);
        l4.addLast(3);
        l4.addLast(3);
        l4.addLast(4);
        removeDuplicate(l4.getHead());
        l4.display();

    }

    public static void removeDuplicate(Node head) {
        Node cur = head;
        while (cur != null && cur.next != null) {
            if (cur.data == cur.next.data) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
    }

    public static LinkedList mergeTwoSortedList(LinkedList l1, LinkedList l2) {
        Node h1 = l1.getHead();
        Node h2 = l2.getHead();
        LinkedList l = new LinkedList();
        while (h1 != null && h2 != null) {
            if (h1.data < h2.data) {
                l.addLast(h1.data);
                h1 = h1.next;
            } else {
                l.addLast(h2.data);
                h2 = h2.next;
            }
        }

        while (h1 != null) {
            l.addLast(h1.data);
            h1 = h1.next;
        }

        while (h2 != null) {
            l.addLast(h2.data);
            h2 = h2.next;
        }

        return l;
    }

    public static LinkedList mergeSort(Node head, Node tail) {
        if (head == tail) {
            LinkedList l = new LinkedList();
            l.addLast(head.data);
            return l;
        }
        Node mid = getMiddle1(head, tail);
        LinkedList l1 = mergeSort(head, mid);
        LinkedList l2 = mergeSort(mid.next, tail);
        return mergeTwoSortedList(l1, l2);
    }

    public static int getMiddle(LinkedList l) {
        Node s = l.getHead();
        Node f = l.getHead();
        while (f != null && f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s.data;
    }

    public static Node getMiddle1(Node head, Node tail) {
        Node s = head;
        Node f = head;
        while (f != tail && f.next != tail) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    public static int kthFromLast(LinkedList l, int k) {
        Node s = l.getHead();
        Node f = l.getHead();

        for (int i = 0; i < k; i++) {
            f = f.next;
        }

        while (f != l.getTail()) {
            s = s.next;
            f = f.next;
        }
        return s.data;
    }
}
