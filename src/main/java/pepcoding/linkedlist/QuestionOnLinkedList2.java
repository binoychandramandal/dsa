package pepcoding.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class QuestionOnLinkedList2 {

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        l.addLast(4);
        l.addLast(5);
        l.display();
//        Node head = l.getHead();
//        Node re = reverse(head);
//        dfs(re);
        Node head = l.getHead();
        Stack<Node> s=new Stack<>();
        s.push(head);
        reverseHelper(head,s,4,0);
        display(head);


    }

    static void reverseHelper(Node head, Stack<Node> holder,int size,int floor) {
        if (head == null) {
            return;
        }
        reverseHelper(head.next, holder,size,floor+1);
        if(floor>=size/2) {
            Node left = holder.pop();
            int temp = head.data;
            head.data = left.data;
            left.data = temp;
            left = left.next;
            holder.push(left);
        }

    }


    static void display(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }


    static void reverseHelper(Node head, List<Node> tail) {
        if (head == null) {
            return;
        }
        reverseHelper(head.next, tail);
        if (head.next == null) {
            tail.add(head);
        } else {
            head.next.next = head;
        }
    }

    static Node reverse(Node head) {
        List<Node> tail = new ArrayList<>(1);
        reverseHelper(head, tail);
        head.next = null;
        head = tail.get(0);
        return head;
    }


}
