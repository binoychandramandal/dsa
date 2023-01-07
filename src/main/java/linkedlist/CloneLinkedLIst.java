package linkedlist;


public class CloneLinkedLIst {
    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next = n2;
        Node n3 = new Node(3);
        n2.next = n3;
        Node clone = clone(n1);
        print(n1);
        print(clone);
    }


    static public Node clone(Node h) {
        if (h == null) {
            return h;
        }
        Node h2 = null;
        Node t1 = h;
        Node t2 = null;
        while (t1 != null) {
            Node tmp = new Node(t1.data);
            if (h2 == null) {
                h2 = tmp;
            }
            tmp.next = t1.next;
            t1.next = tmp;
            t2 = tmp;
            t1 = t2.next;
        }
        return h2;

    }

    static void print(Node h) {
        while (h != null) {
            System.out.print(h.data + " -> ");
            h = h.next;
        }
        System.out.println();
    }


    static class Node {
        int data;
        Node next;
        Node random;

        public Node(int data) {
            this.data = data;
        }
    }
}
