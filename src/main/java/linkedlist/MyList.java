package linkedlist;

public class MyList {

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        node1.next=node2;
        ListNode node3=new ListNode(3);
        node2.next=node3;
        ListNode node4=new ListNode(4);
        node3.next=node4;
        ListNode node5=new ListNode(5);
        node4.next=node5;
        System.out.println(node1);
        ListNode rev=new MyList().solve(node1,1);
        System.out.println(rev);

        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        n1.next=n2;
        ListNode n3=new ListNode(3);
        n2.next=n3;

        ListNode nn1=new ListNode(1);
        ListNode nn2=new ListNode(2);
        nn1.next=nn2;
        ListNode nn3=new ListNode(3);
        nn2.next=nn3;

        new MyList().solve1(n1,nn2);

    }

    //reverse the linked list
    public ListNode solve(ListNode A, int B) {
        ListNode prev = null;
        ListNode curr = A;
        ListNode next=null;
        while (curr != null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;

    }

    public ListNode solve1(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curr = result;
        while (l1 != null && l2 != null) {
            if(l1.val<l2.val){
                curr.next=l1;
                l1=l1.next;
            }else {
                curr.next=l2;
                l2=l2.next;
            }
            curr=curr.next;
        }
        while (l1 != null) {
                curr.next=l1;
                l1=l1.next;
        }
        while (l2 != null) {
            curr.next=l2;
            l2=l2.next;
        }
        return result.next;

    }

  static   class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

      @Override
      public String toString() {
          return  val +
                  "->" + next ;
      }
  }
}
