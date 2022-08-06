package linkedlist.dll;

public class Test3 {
    public static void main(String[] args) {
        DLL dll=new DLL();
        dll.addLast(1);
        dll.addLast(2);
        dll.addLast(3);
        dll.addLast(4);
        dll.addLast(5);
        dll.addLast(6);
        System.out.println(dll.getAt(0));
        System.out.println(dll.getAt(1));
        System.out.println(dll.getAt(2));
        System.out.println(dll.getAt(3));
        System.out.println(dll.getAt(4));
        dll.displayForward();
        dll.removeNode(dll.getAt(2));
        dll.displayForward();
        dll.removeNode(dll.getAt(1));
        dll.displayForward();
        dll.removeNode(dll.getAt(0));
        dll.displayForward();
        dll.removeNode(dll.getAt(2));
        dll.displayForward();
    }
}
