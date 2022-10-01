package linkedlist;

public class IncrementBy1 {
    public static void main(String[] args) {
        Node root = new Node(7, new Node(9, new Node(8)));
        display(root);

        Node temp = findLastNon9(root);
        if (temp == null) {
            Node n1 = new Node(1);
            n1.next = root;
            root = n1;
            Node cur =root.next;
            while (cur.next != null) {
                cur.val=0;
            }
        }else{

        }
        display(root);
    }


    static Node findLastNon9(Node head) {
        Node non9 = null;
        Node tmp = head;
        while (tmp != null) {
            if (tmp.val != 9) {
                non9 = tmp;
            }
            tmp = tmp.next;
        }
        return non9;
    }


    static void display(Node node) {
        Node cur = node;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    static Node reverse(Node head) {
        Node cur = head;
        Node prev = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }


}
