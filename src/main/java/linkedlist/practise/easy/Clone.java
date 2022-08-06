package linkedlist.practise.easy;

public class Clone {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.setNext(n2);
        Node n3 = new Node(3);
        n2.setNext(n3);
        Util.print(n1);
        Node cloned = clone(n1);
        cloned.setData(10);
        Util.print(n1);
        Util.print(cloned);
        Node clR = cloneRec(n1);
        clR.setData(30);
        Util.print(clR);
        Util.printRec(clR);
        Util.printRec(clR);
        System.out.println();
        System.out.println(Util.count(cloned));
        System.out.println(Util.countRec(cloned));
    }

    static Node clone(Node h1) {
        if (h1 == null) {
            return h1;
        }
        Node cur = h1;
        Node cloneHead = null;
        Node cloneRunner = null;
        while (cur != null) {
            Node temp = new Node(cur.getData());
            if (cloneHead == null) {
                cloneHead = temp;
                cloneRunner = temp;
            }
            cloneRunner.setNext(temp);
            cloneRunner = temp;
            cur = cur.getNext();
        }
        return cloneHead;
    }

    static Node cloneRec(Node h1) {
        if (h1 == null) {
            return h1;
        }
        Node temp = new Node(h1.getData());
        temp.setNext(cloneRec(h1.getNext()));
        return temp;
    }


}
