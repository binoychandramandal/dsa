package pepcoding.linkedlist;

public class QuestionOnLinkedList1 {

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        l.addLast(2);
        l.addLast(1);
//        l.addLast(6);
//        l.addLast(7);
        l.display();
//        oddEvenArrange(l);
//        l.dfs();
//        kReverse(l,3);
//        l.dfs();
//        System.out.println(l.size());
//
//        displayUsingRecursive(l);
        //reversePR(l);
        //l.dfs();
        reverseDR(l);
        l.display();
        reverseDR(l);
        l.display();
        System.out.println(isPalindrome(l));
        fold(l);
        l.display();
   LinkedList  l1 =new LinkedList();
   l1.addLast(9);
   l1.addLast(7);
   l1.addLast(8);

        LinkedList  l2 =new LinkedList();
        l2.addLast(3);
        l2.addLast(2);

       LinkedList r= addTwoList(l1,l2);
       r.display();
    }



    static int findIntersectionPoint(LinkedList one,LinkedList two){
        Node t1 =one.getHead();
        Node t2=two.getHead();
        int delta =Math.abs(one.size()-two.size());
        if(one.size()>two.size()){
            for (int i = 0; i < delta; i++) {
                t1=t1.next;
            }
        }else{
            for (int i = 0; i < delta; i++) {
                t2=t2.next;
            }
        }
        while (t1!=t2){
            t1=t1.next;
            t2=t2.next;
        }
        return t1.data;
    }

    static int addListHelper(Node one, int pv1, Node two, int pv2, LinkedList result) {
        if (one == null && two == null) {
            return 0;
        }
        int data =0;
        if (pv1 > pv2) {
           int oc= addListHelper(one.next, pv1 - 1, two, pv2, result);
           data=one.data+oc;
        } else if (pv1 < pv2) {
            int oc=addListHelper(one, pv1, two.next, pv2 - 1, result);
            data+=two.data+oc;
        } else {
           int oc= addListHelper(one.next, pv1 - 1, two.next, pv2 - 1, result);
             data=one.data+ two.data+oc;

        }
        int nd=data%10;
        int nc= data/10;
        result.addFirst(nd);
        return nc;
    }

    static LinkedList addTwoList(LinkedList one, LinkedList two) {
        LinkedList result = new LinkedList();
        int oc = addListHelper(one.getHead(), one.size(), two.getHead(), two.size(), result);
        if(oc>0){
            result.addFirst(oc);
        }
        return result;
    }

    private static void foldHelper(Node right, int floor, LinkedList l) {
        if (right == null) {
            return;
        }
        foldHelper(right.next, floor + 1, l);
        if (floor > l.size() / 2) {
            Node temp = foldLeft.next;
            foldLeft.next = right;
            right.next = temp;
            foldLeft = temp;
        } else if (floor == l.size() / 2) {
            l.setTail(right);
            l.getTail().next = null;
        }
    }

    static Node foldLeft = null;

    static void fold(LinkedList l) {
        foldLeft = l.getHead();
        foldHelper(l.getHead(), 0, l);
    }

    static boolean isPalindrome(LinkedList r) {
        palindromLeft = r.getHead();
        return isPalindrome(r.getHead());
    }

    static Node palindromLeft;

    private static boolean isPalindrome(Node right) {
        if (right == null) {
            return true;
        }
        boolean rres = isPalindrome(right.next);
        if (rres == false) {
            return false;
        } else if (palindromLeft.data != right.data) {
            return false;
        } else {
            palindromLeft = palindromLeft.next;
            return true;
        }

    }

    static void reverseDRHelper(Node head, int floor, LinkedList l) {
        if (head == null) {
            return;
        }
        reverseDRHelper(head.next, floor + 1, l);
        if (floor > l.size() / 2) {
            int temp = head.data;
            head.data = rleft.data;
            rleft.data = temp;
            rleft = rleft.next;
        }
    }

    static Node rleft;

    static void reverseDR(LinkedList l) {
        rleft = l.getHead();
        reverseDRHelper(l.getHead(), 0, l);
    }

    static void reversePRHelper(Node head, LinkedList l) {
        if (head == null) {
            return;
        }
        reversePRHelper(head.next, l);
        if (head == l.getTail()) {

        } else {
            head.next.next = head;
        }
    }

    static void reversePR(LinkedList l) {
        reversePRHelper(l.getHead(), l);
        l.getHead().next = null;
        Node temp = l.getHead();
        l.setHead(l.getTail());
        l.setTail(temp);

    }

    static void displayUsingRecursive(LinkedList l) {
        displayUsingRecursiveCode(l.getHead());
        System.out.println();
    }

    private static void displayUsingRecursiveCode(Node head) {
        if (head == null) {
            return;
        }
        displayUsingRecursiveCode(head.next);
        System.out.print(head.data + " ");
    }


    static void kReverse(LinkedList l, int k) {
        LinkedList prev = null;
        while (l.size() > 0) {
            LinkedList cur = new LinkedList();

            if (l.size() >= k) {
                for (int i = 0; i < k; i++) {
                    int data = l.getFirst();
                    l.removeFirst();
                    cur.addFirst(data);
                }
            } else {
                int os = l.getSize();
                for (int i = 0; i < os; i++) {
                    int data = l.getFirst();
                    l.removeFirst();
                    cur.addLast(data);
                }
            }
            if (prev == null) {
                prev = cur;
            } else {
                prev.getTail().next = cur.getHead();
                prev.setTail(cur.getTail());
                prev.setSize(prev.getSize() + cur.getSize());
            }
        }
        l.setHead(prev.getHead());
        l.setTail(prev.getTail());
        l.setSize(prev.getSize());
    }

    static void oddEvenArrange(LinkedList l) {
        LinkedList odd = new LinkedList();
        LinkedList even = new LinkedList();
        while (l.size() > 0) {
            int data = l.getFirst();
            l.removeFirst();
            if (data % 2 == 0) {
                even.addLast(data);
            } else {
                odd.addLast(data);
            }
        }
        if (!odd.isEmpty() && !even.isEmpty()) {
            odd.getTail().next = even.getHead();
            l.setHead(odd.getHead());
            l.setTail(even.getTail());
            l.setSize(odd.getSize() + even.getSize());
        } else if (!odd.isEmpty()) {
            l.setHead(odd.getHead());
            l.setTail(odd.getTail());
            l.setSize(odd.getSize());
        } else if (!even.isEmpty()) {
            l.setHead(even.getHead());
            l.setTail(even.getTail());
            l.setSize(even.getSize());
        }
    }
}
