package linkedlist.practise.easy;

public class AddTwoNumber {
    public static void main(String[] args) {
        Node l1 = new Node(1, new Node(3, new Node(5)));
        display(l1);
        Node add =add(l1,l1);
        display(add);

    }

    static Node add(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node t = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if(l1!=null){
                sum+=l1.getData();
                l1=l1.getNext();
            }
            if(l2!=null){
                sum+=l2.getData();
                l2=l2.getNext();
            }
            sum+=carry;
            carry=sum/10;
            t.setNext(new Node(sum%10));
            t=t.getNext();
        }

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
