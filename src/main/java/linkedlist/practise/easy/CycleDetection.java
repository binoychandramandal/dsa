package linkedlist.practise.easy;

import java.util.HashSet;
import java.util.Set;

public class CycleDetection {
    public static void main(String[] args) {
        Node l1 = new Node(1);
        Node l2 = new Node(2);
        Node l3 = new Node(3);
        l1.setNext(l2);
        l3.setNext(l2);
        l2.setNext(l1);
        //display(l1);
        System.out.println(cycleDetect(l1));
        System.out.println(cycleDetectTwoPointer(l1));

    }

    static boolean cycleDetect(Node head) {
        if (head == null) return false;
        Set<Node> s = new HashSet<>();
        Node t = head;
        while (t != null) {
            if (s.contains(t)) {
                return true;
            }
            s.add(t);
            t = t.getNext();
        }
        return false;
    }

    static boolean cycleDetectTwoPointer(Node head) {
        if (head == null) return false;
        Node slow = head;
        Node fast = head;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) {
                return true;
            }
        }
        return false;
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
