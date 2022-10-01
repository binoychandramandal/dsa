package practice.linkedlist;

public class MergeTwoSortedLinkedList {
    public static void main(String[] args) {
        Node l1 = new Node(1, new Node(3, new Node(8, new Node(12))));
        Node l2 = new Node(2, new Node(4, new Node(7, new Node(13))));
//        display(l1);
//        display(l2);
        display(merge(l1, l2));
        //Node node = mergeUsingExtraSpace(l1, l2);
        // display(node);
    }

    /**
     * Without extra space
     *
     * @param l1
     * @param l2
     * @return
     */
    static Node merge(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val > l2.val) {
            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }
        Node res = l1;
        while (l1 != null && l2 != null) {
            Node temp = null;
            while (l1 != null && l1.val <= l2.val) {
                temp = l1;
                l1 = l1.next;
            }
            temp.next = l2;
            //swap
            Node tmp = l1;
            l1 = l2;
            l2 = tmp;
        }
        return res;

    }

    static Node mergeUsingExtraSpace(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        Node cur1 = l1;
        Node cur2 = l2;
        Node result = null;
        Node tail = null;
        if (l1.val < l2.val) {
            tail = result = new Node(l1.val);
            cur1 = cur1.next;
        } else {
            tail = result = new Node(l2.val);
            cur2 = cur2.next;
        }

        while (cur1 != null && cur2 != null) {
            int data = 0;
            if (cur1.val < cur2.val) {
                data = cur1.val;
                cur1 = cur1.next;
            } else {
                data = cur2.val;
                cur2 = cur2.next;
            }
            tail.next = new Node(data);
            tail = tail.next;
        }
        if (cur1 != null) {
            tail.next = cur1;
        }
        if (cur2 != null) {
            tail.next = cur2;
        }
        return result;
    }


    static void display(Node root) {
        Node cur = root;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
