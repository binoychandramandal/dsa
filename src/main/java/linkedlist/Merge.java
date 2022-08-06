package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(3);
        n1.next=n2;
        ListNode n11=new ListNode(2);
        ListNode n22=new ListNode(4);
        n11.next=n22;
        ArrayList<ListNode> l=new ArrayList<>();
        l.add(n1);
        l.add(n11);
        System.out.println(new Merge().mergeKLists(l));

    }
    public ListNode mergeKLists(ArrayList<ListNode> a) {

        ListNode n= merge(null,a.get(0));
        for(int i=1;i<a.size();i++){
            n= merge(n,a.get(i));
        }
        return n;
    }


    ListNode merge(ListNode h1,ListNode h2){
        if(h1==null) return h2;
        if(h2==null) return h1;
        ListNode h3=null,t1=h1,t2=h2,t3=null;

        if(t1.val<t2.val){
            h3=h1;t3=h1;t1=t1.next;
        }else{
            h3=h2;t3=h2;t2=t2.next;
        }

        while(t1!=null && t2!=null){
            if(t1.val<t2.val){
                t3.next=t1;
                t3=t3.next;
                t1=t1.next;
            }else{

                t3.next=t2;
                t3=t3.next;
                t2=t2.next;
            }
        }

        if(t1!=null){
            t3.next=t1;
        }
        if(t2!=null){
            t3.next=t2;
        }
        return h3;
    }

   static class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
}
