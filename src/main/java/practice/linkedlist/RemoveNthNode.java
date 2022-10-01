package practice.linkedlist;

public class RemoveNthNode {

    public static void main(String[] args) {
        Node l1 = new Node(1, new Node(3, new Node(8, new Node(12))));
        display(l1);
        Node nn = removeLastNthNode(l1, 4);
        display(nn);
        Node n1 = removeNthNode(l1, 1);
        display(n1);
    }

    static Node removeLastNthNode(Node root, int n) {
        if (root == null) return root;
        Node dummyNode = new Node(0);
        Node slow = dummyNode;
        Node fast = dummyNode;
        dummyNode.next = root;
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (slow.next == root) {
            return slow.next;
        } else {
            slow.next = slow.next.next;
            return root;

        }
    }

    static Node removeNthNode(Node root, int n) {
        int size = size(root);
        if (size == 0 || n > size) {
            return root;
        }
        if (n == 1 && size == 1) {
            return root.next;
        }
        Node cur = root;
        for (int i = 0; i < (size - n - 1); i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return root;
    }


    static int size(Node root) {
        if (root == null)
            return 0;
        int count = 0;
        Node cur = root;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
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
