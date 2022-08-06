package linkedlist.dll;

public class Test2 {
    public static void main(String[] args) {
        DLL dll=new DLL();
        dll.addLast(5);
        dll.removeLast();
        dll.addLast(4);
        dll.removeLast();
        dll.addLast(3);
        dll.addLast(2);
        dll.removeLast();
        dll.addLast(1);
        dll.addLast(0);
        dll.displayBackward();
        dll.displayForward();
        System.out.println("Delete 2");
        dll.removeLast();
        dll.removeFirst();
        dll.removeFirst();
        dll.displayBackward();
        dll.displayForward();
        System.out.println(dll.size());
        System.out.println(dll.isEmpty());

        dll.addFirst(20);
        dll.displayBackward();
        dll.displayForward();
        System.out.println(dll.size());
        System.out.println(dll.isEmpty());
    }
}
