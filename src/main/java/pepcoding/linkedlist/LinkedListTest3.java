package pepcoding.linkedlist;

public class LinkedListTest3 {
    public static void main(String[] args) {
        LinkedList l=new LinkedList();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        l.addLast(4);
        l.addAt(4,5);
        l.addAt(5,6);
        l.addAt(0,0);
        l.display();
        l.reverse();
        l.display();
        l.reverseWithAddress();
        l.display();

        int size = l.size();
        for (int i = 0; i < size; i++) {
            System.out.println(l.removeAt(1));
        }
        System.out.println(l.getHead());
        System.out.println(l.getTail());
    }
}
