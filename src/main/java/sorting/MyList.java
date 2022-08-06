package sorting;


class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
class MyList{
    /**
     * [1, 13, -1]
     *   [3, 0, -1]
     *   [3, 1, -1]
     *   [2, 15, 0]
     *   [3, 0, -1]
     *   [1, 12, -1]
     *   [3, 0, -1]
     *   [1, 19, -1]
     *   [1, 13, -1]
     *   [3, 0, -1]
     *   [0, 12, -1]
     *   [1, 13, -1]
     *   [3, 2, -1]
     * @param args
     */
    public static void main(String[]args){
      MyList m=new MyList();
//      m.addLast(13);
//        m.delete(0);
//        m.delete(1);
//      m.addBefore(0,13);
//        m.delete(0);
//     m.addLast(12);
//     m.delete(0);
//     m.addLast(19);
//     m.addLast(13);
//        m.delete(0);
//        m.addFirst(12);
//        m.addLast(13);
//        m.delete(2);



        m.addBefore(0,18);
        m.addBefore(1,5);
        m.addBefore(0,8);
        m.addLast(7);
        m.addLast(5);
        System.out.println(m);
    }
    private ListNode head;
    private ListNode tail;
    int size;
    public ListNode getHead(){
        return head;
    }

    public void  addFirst(int value){
        ListNode newNode =new ListNode(value);
        newNode.next=head;
        head=newNode;
        if(tail==null){
            tail=head;
        }
        size++;
    }

    public void  addLast(int value){
        ListNode newNode =new ListNode(value);
        if(head==null && tail==null){
            head=tail=newNode;
        }else{
            tail.next=newNode;
            tail=newNode;
        }
        size++;
    }

    public void  addBefore(int index,int value){
        if(index>size){
            return;
        }
        if(index==0){
            addFirst(value);
        }else if(index==size){
            addLast(value);
        }else{
            ListNode temp =head;
            int count=0;
            while(count++<index-1){
                temp=temp.next;
            }
            ListNode newNode =new ListNode(value);
            newNode.next= temp.next;
            temp.next=newNode;
            size++;
        }

    }

    public void delete(int index){
        if(index>=0 && index<=size-1){
            if(index<=0){
                if(head!=null){
                    head=head.next;
                }
                if(head==null){
                    tail=null;
                }
            }else  {
                ListNode temp=head;
                int count=0;
                while(count<index-1){
                    temp=temp.next;
                    count++;
                }
                ListNode n=temp.next;
                if(n!=null){
                    n=n.next;
                }
                temp.next=n;
                if(index==size-1){
                    tail=temp;
                }
                if(head==null){
                    tail=null;
                }
            }
            size--;
        }
    }
}
