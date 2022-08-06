package linkedlist;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 * int label;
 * RandomListNode next, random;
 * RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 s=new Solution2();
        RandomListNode n1=new RandomListNode(1);
        RandomListNode n2=new RandomListNode(2);
        n1.next=n2;
        RandomListNode n3=new RandomListNode(3);
        n2.next=n3;
        n1.random=n3;
        n2.random=n1;
        n3.random=n1;
        System.out.println(n1);
        RandomListNode r=s.copyRandomList(n1);

    }

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode h1=head;
        RandomListNode h2=insertInBetween(head);
        setRandom(h1,h2);
        separate(h1,h2);
        return h2;
    }

    void separate(RandomListNode head1,RandomListNode head2) {
        RandomListNode t1=head1;
        RandomListNode t2=head2;
        while(t1!=null){
           t1.next=t2.next;
            t1=t1.next;
            if(t1!=null){
                t2=t1.next;
            }
        }

    }


    void setRandom(RandomListNode head1,RandomListNode head2) {
        RandomListNode t1=head1;
        RandomListNode t2=head2;
        while(t1!=null){
            t2.random=t1.random.next;
            t1=t1.next.next;
            if(t1!=null){
                t2=t2.next.next;
            }
        }

    }


    RandomListNode insertInBetween(RandomListNode h) {
        if (h == null) {
            return h;
        }
        RandomListNode h2 = null, t1 = h, t2 = null;
        while (t1 != null) {
            RandomListNode tmp = new RandomListNode(t1.label);
            if (h2 == null) {
                h2 = tmp;
            }
            tmp.next = t1.next;
            t1.next = tmp;
            t2 = tmp;
            t1 = t2.next;
        }
        return h2;
    }

    static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }


}
