package linkedlist.practise.easy;

public class MergeLinkedList {
    public static void main(String[] args) {
        Node l1 = new Node(1, new Node(3, new Node(5)));
        Node l2 = new Node(2, new Node(4, new Node(6)));
        Node merged = merge(l1, l2);
        System.out.println(merged);
    }

    static Node merge(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        Node newHead = null, newTail = null, h1 = l1, h2 = l2;
        if (h1.getData() < h2.getData()) {
            newHead = new Node(h1.getData());
            h1 = h1.getNext();
        } else {
            newHead = new Node(h2.getData());
            h2 = h2.getNext();
        }
        newTail = newHead;

        while (h1 != null && h2 != null) {
            if (h1.getData() < h2.getData()) {
                newTail.setNext(new Node(h1.getData()));
                h1 = h1.getNext();
            } else {
                newTail.setNext(new Node(h2.getData()));
                h2 = h2.getNext();
            }
            newTail = newTail.getNext();
        }

        while (h1 != null) {
            newTail.setNext(new Node(h1.getData()));
            h1 = h1.getNext();
            newTail = newTail.getNext();
        }

        while (h2 != null) {
            newTail.setNext(new Node(h2.getData()));
            h2 = h2.getNext();
            newTail = newTail.getNext();
        }

        return newHead;

    }

}
