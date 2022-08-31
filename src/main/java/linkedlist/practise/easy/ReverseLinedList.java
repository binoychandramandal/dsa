package linkedlist.practise.easy;

public class ReverseLinedList {
    public static void main(String[] args) {
        Node node = new Node(1, new Node(2, new Node(3, new Node(4))));
        Node reverse = reverse(node);
        System.out.println(reverse);
    }

    static Node reverse(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node node = reverse(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return node;
    }
}
