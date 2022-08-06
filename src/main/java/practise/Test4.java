package practise;

import pepcoding.linkedlist.Node;

import java.util.ArrayList;
import java.util.List;

public class Test4 {
    public static void main(String[] args) {
       Node head = new Node(1,new Node(2,new Node(3,new Node(4))));
       print(head);
       reverse(head);
       head.next=null;
        print(head);
    }

    static void reverse(Node head) {
        if (head==null) {
            return ;
        }
        reverse(head.next);
        if(head.next!=null){
            head.next.next=head;
        }

    }

    static void print(Node head){
        while(head!=null){
            System.out.print(head.data);
            head=head.next;
        }
    }

}
