package linkedlist.practise.easy;

public class IntersectionPoint {
    public static void main(String[] args) {
        Node inter = new Node(10, new Node(11, new Node(12)));
        Node l1 = new Node(1, new Node(3, new Node(5, inter)));
        Node l2 = new Node(2, new Node(4, new Node(6,inter)));
        display(l1);
        display(l2);
        Node n = intersectionPresent(l1, l2);
        System.out.println(n != null ? n.getData() : null);

        n = intersectionPresentOptimized(l1, l2);
        System.out.println(n != null ? n.getData() : null);
         n = intersectionOptimized1(l1,l2);
        System.out.println(n != null ? n.getData() : null);

    }

    static Node intersectionPresent(Node head1, Node head2) {
        int diff = getDifference(head1, head2);
        if (diff < 0) {
            while (diff++ != 0) head2 = head2.getNext();
        } else {
            while (diff-- != 0) head1 = head1.getNext();
        }
        while (head1 != null) {
            if (head1 == head2) return head1;
            head2 = head2.getNext();
            head1 = head1.getNext();
        }
        return null;
    }

    static Node intersectionOptimized1(Node head1, Node head2) {
        Node d1 = head1;
        Node d2 = head2;
        while (d1 != d2) {
            d1 = d1 == null ? head2 : d1.getNext();
            d2 = d2 == null ? head1 : d2.getNext();
        }
        return d1;
    }


    static int getDifference(Node head1, Node head2) {
        int len1 = 0, len2 = 0;
        Node t1 = head1;
        Node t2 = head2;
        while (t1 != null || t2 != null) {
            if (t1 != null) {
                len1++;
                t1 = t1.getNext();
            }
            if (t2 != null) {
                len2++;
                t2 = t2.getNext();
            }
        }
        return len1 - len2;
    }


    static Node intersectionPresentOptimized(Node head1, Node head2) {
        Node d1 = head1;
        Node d2 = head2;

        while (d1 != d2) {
            d1 = d1 == null ? head2 : d1.getNext();
            d2 = d2 == null ? head1 : d2.getNext();
        }

        return d1;
    }


    static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

}
