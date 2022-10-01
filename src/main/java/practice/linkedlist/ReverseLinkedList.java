package practice.linkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Node root = new Node(1, new Node(2, new Node(3, new Node(4))));
        display(root);
        Node reverse = reverse(root);
        display(reverse);
        Node re=reverseUsingRec(reverse);
        display(re);
    }

    static Node reverseUsingRec(Node root) {
        if (root == null || root.next == null)
            return root;
        Node node = reverseUsingRec(root.next);
        root.next.next = root;
        root.next = null;
        return node;
    }

    static Node reverse(Node root) {
        if (root == null) {
            return root;
        }
        Node cur = root;
        Node prev = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    static void display(Node root) {
        Node cur = root;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
