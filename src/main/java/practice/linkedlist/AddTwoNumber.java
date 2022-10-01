package practice.linkedlist;

public class AddTwoNumber {
    public static void main(String[] args) {
        Node l1 = new Node(2, new Node(3, new Node(4)));
        Node l2 = new Node(5, new Node(6, new Node(4)));
        Node sum = addTwoNumbers(l1, l2);
        while (sum != null) {
            System.out.println(sum.val);
            sum = sum.next;
        }
    }

    public static Node addTwoNumbers(Node l1, Node l2) {

        Node result = new Node(0);
        Node runner = result;
        int carry = 0;
        Node list1 = l1;
        Node list2 = l2;

        while (list1 != null || list2 != null) {
            int sum = 0;
            if (list1 != null) {
                sum += list1.val;
                list1 = list1.next;
            }

            if (list2 != null) {
                sum += list2.val;
                list2 = list2.next;
            }
            sum += carry;
            carry = sum / 10;
            runner.next = new Node(sum % 10);
            runner = runner.next;
        }
        if (carry > 0) {
            runner.next = new Node(carry);
        }
        return result.next;

    }
}
