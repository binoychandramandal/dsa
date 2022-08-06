package linkedlist.dll;

public class Node {
    int data;
    int key;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
    }
    public Node(int key, int data) {
        this.data = data;
        this.key = key;
    }
    public Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return key+" - "+data;
    }
}
