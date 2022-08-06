package pepcoding.linkedlist;

public class LinkedListTest2 {
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
        l.removeFirst();
        l.display();
        System.out.println(l.size());

        int size= l.size();
        for (int i = 0; i < size+1; i++) {
            System.out.println(l.removeLast());
        }
        System.out.println(l.size());

    }
}
