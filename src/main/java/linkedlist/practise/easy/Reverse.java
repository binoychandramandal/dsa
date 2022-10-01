package linkedlist.practise.easy;

public class Reverse {

    public static void main(String[] args) {
        Node root = new Node(7, new Node(9, new Node(9)));
        display(root);
        Node increment = increment(root);
        display(increment);
    }

    static int iterate(Node node) {
        if (node == null) {
            return 1;
        }
        int carry = iterate(node.getNext());
        int sum = node.getData() + carry;
        node.setData(sum % 10);
        return sum / 10;
    }

    static Node increment(Node root) {
        int carry = iterate(root);
        if (carry > 0) {
            root = new Node(carry, root);
        }
        return root;
    }

    static void display(Node root) {
        Node cur = root;
        while (cur != null) {
            System.out.print(cur.getData() + " ");
            cur = cur.getNext();
        }
        System.out.println();
    }


}
