package linkedlist.practise.easy;

public class FlattenLinkedList {
    public static void main(String[] args) {
        Node l1 = new Node(5, new Node(10, new Node(19, new Node(28))));
        Node l01 = new Node(new Node(new Node(30),8),7);
        Node l21 = new Node(new Node(50),22);
        l1.down = l01;
        l1.next.next.down = l21;
        display(l1);
        displayDown(l1.next.next.down);
        displayDown(l1.down);
       // displayDown(mergeTwoSortedList(l1,l1.next));
        displayDown(flatten(l1));
    }

    static Node mergeTwoSortedList(Node a, Node b) {
        Node temp = new Node(0);
        Node res = temp;
        while(a!=null && b!=null){
            if(a.data<b.data){
                temp.down=a;
                temp= temp.down;
                a=a.down;
            }else{
                temp.down=b;
                temp= temp.down;
                b=b.down;
            }
        }
        if(a!=null) temp.down=a;
        else temp.down=b;
        return res.down;
    }

    static Node flatten(Node head){
        if(head==null || head.next==null) return head;
        head.next = flatten(head.next);
        head = mergeTwoSortedList(head,head.next);
        return head;
    }



    static void displayDown(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.down;
        }
        System.out.println();
    }
    static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static class Node {
        int data;
        Node next;
        Node down;

        public Node(int data) {
            this.data = data;
        }

        public Node(Node down, int data, Node next) {
            this.data = data;
            this.next = next;
            this.down = down;
        }
        public Node(Node down, int data) {
            this.data = data;
            this.down = down;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
            this.down = down;
        }
    }

}
