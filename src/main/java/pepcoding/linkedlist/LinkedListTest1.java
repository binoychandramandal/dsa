package pepcoding.linkedlist;

public class LinkedListTest1 {
    public static void main(String[] args) {
        LinkedList l=new LinkedList();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        l.addLast(4);
        l.display();
        System.out.println(l.size());
        System.out.println(l.isEmpty());
         int size = l.size();
        for (int i = 0; i < size+10; i++) {
            l.removeFirst();
        }
        System.out.println(l.size());
        System.out.println(l.isEmpty());
        l.addFirst(1);
        l.addFirst(2);
        l.addFirst(3);
        l.addFirst(4);
        l.display();
        System.out.println(l.size());
        System.out.println(l.isEmpty());
         size = l.size();
        for (int i = 0; i < size+10; i++) {
            l.removeFirst();
        }

        System.out.println(l.size());
        System.out.println(l.isEmpty());
    }
}
