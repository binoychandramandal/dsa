package pepcoding.tree.binary;


public class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }

    public Node(Node left, int val, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return val + " ";
    }
}
