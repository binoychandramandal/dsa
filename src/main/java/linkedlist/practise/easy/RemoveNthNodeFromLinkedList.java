package linkedlist.practise.easy;

public class RemoveNthNodeFromLinkedList {
    public static void main(String[] args) {
        Node l1 = new Node(1, new Node(3, new Node(5)));
        display(l1);
        Node d1 = remove(l1, 3); //3,5
        display(d1);
        Node d2 = remove(d1, 1);//3
        display(d2);

    }

    static Node remove(Node head, int n) {

        Node dummy = new Node(1);
        dummy.setNext(head);
        Node slow = dummy;
        Node fast = dummy;
        for (int i = 1; i <= n; i++) {
            if(fast==null){
                return head;
            }
            fast = fast.getNext();
        }
        while (fast.getNext() != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        slow.setNext(slow.getNext().getNext());
//        if (slow.getNext() == head) {
//            slow.setNext(slow.getNext().getNext());
//            return head.getNext();
//        } else {
//            slow.setNext(slow.getNext().getNext());
//            return head;
//        }

        return dummy.getNext();
    }

    static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

}
