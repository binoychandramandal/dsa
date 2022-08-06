package linkedlist.practise.easy;

public class InsertIntoCorrectPosition {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(5);
        n1.setNext(n2);
        Node n3 = new Node(8);
        n2.setNext(n3);
        Node f=insertIntoCorrectPosition(n1,0);
         f=insertIntoCorrectPosition(f,11);
        f=insertIntoCorrectPosition(f,4);
        System.out.println(f);
    }

    static  Node insertIntoCorrectPosition(Node head,int k){
        Node newNode = new Node(k);
        if(head==null || k<head.getNext().getData()){
            newNode.setNext(head);
            head=newNode;
            return head;}
        Node cur=head;
        while(cur.getNext()!=null && cur.getNext().getData()<k){
            cur=cur.getNext();
        }
        newNode.setNext(cur.getNext());
        cur.setNext(newNode);
        return head;
    }
}
