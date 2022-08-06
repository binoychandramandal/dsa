package linkedlist.dll;

public class Test1 {
    public static void main(String[] args) {
        DLL dll=new DLL();
        System.out.println(dll.isEmpty());
        System.out.println(dll.size());
        dll.addFirst(5);
        dll.addFirst(4);
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(0);
        dll.displayBackward();
        dll.displayForward();
        System.out.println(dll.size());
        System.out.println(dll.isEmpty());

        int size =dll.size();
        for (int i = 0; i < size; i++) {
            dll.removeFirst();
        }

        dll.displayBackward();
        dll.displayForward();
        System.out.println(dll.size());
        System.out.println(dll.isEmpty());
    }
}
