package linkedlist;

public class List1 {
    public static void main(String[] args) {

        Node head= new Node(1);
        Node n1=new Node(2);
        head.setNext(n1);
        Node n2=new Node(3);
        n1.setNext(n2);
        Node n3=new Node(4);
        n2.setNext(n3);

        System.out.println(head);

        System.out.println(reverse(head));

    }

    public static  Node reverse(Node n) {
        Node head = null;
        Node curr = n;
        Node next = null;
        while (curr != null) {
            next = curr.getNext();
            curr.setNext(head);
            head = curr;
            curr = next;

        }
        return head;
    }
}
