package linkedlist.practise.easy;

public class Util {

    public static void print(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.getData() + "->");
            cur = cur.getNext();
        }
        System.out.println();
    }

    public static void printRec(Node head) {
        if (head == null)
            return;
        System.out.print(head.getData() + "->");
        printRec(head.getNext());
    }

    public static int countRec(Node head) {
        return head == null ? 0 : 1 + countRec(head.getNext());
    }

    public static int count(Node head) {
        if (head == null)
            return 0;
        int count = 0;
        Node cur = head;
        while (cur != null) {
            count++;
            cur = cur.getNext();
        }
        return count;
    }

}
