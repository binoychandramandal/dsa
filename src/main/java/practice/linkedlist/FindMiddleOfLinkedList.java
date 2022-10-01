package practice.linkedlist;

public class FindMiddleOfLinkedList {
    public static void main(String[] args) {
        Node root = new Node(1, new Node(2, new Node(3, new Node(4))));
        root = new Node(1);
        display(root);
        System.out.println(findMiddle(root));
        System.out.println(findMiddleOptimized(root));
    }

    static int findMiddle(Node node) {
        int size = size(node) / 2;
        Node cur = node;
        for (int i = 0; i < size - 1; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /**
     * Slow and fast method
     *
     * @param node
     * @return
     */
    static int findMiddleOptimized(Node node) {
        Node slow = node;
        Node fast = node;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow.val;
    }

    static int size(Node node) {
        Node cur = node;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
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
