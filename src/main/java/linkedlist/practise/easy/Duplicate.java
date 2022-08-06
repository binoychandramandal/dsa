package linkedlist.practise.easy;

import java.util.HashSet;
import java.util.Set;

public class Duplicate {

    public static void main(String[] args) {
       Node n1 = new Node(1);
       Node n2 = new Node(2);
        n1.next=n2;
       Node n3 = new Node(2);
        n2.next=n3;
        Node n4 = new Node(1);
        n3.next=n4;

        Node dup=removeDuplicates(n1);
        System.out.println(dup);
    }

    public static Node removeDuplicates(Node head)
    {
        Node previous = null;
        Node current = head;

        // take an empty set to store linked list nodes for future reference
        Set<Integer> set = new HashSet<>();

        // do till the linked list is empty
        while (current != null)
        {
            // if the current node is seen before, ignore it
            if (set.contains(current.data)) {
                previous.next = current.next;
            }
            else {
                // insert the current node into the set and proceed to the next node
                set.add(current.data);
                previous = current;
            }
            current = current.next;
        }

        return head;
    }
    static  class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
