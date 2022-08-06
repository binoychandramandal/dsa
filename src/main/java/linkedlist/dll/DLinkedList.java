package linkedlist.dll;

public class DLinkedList<K extends Comparable<K>,V> {
    private DNode<K,V> head;
    private DNode<K,V> tail;
    private int size;

    public DNode<K,V> getHead() {
        return head;
    }

    public DNode<K,V> getTail() {
        return tail;
    }

    public void remove(DNode<K,V> node) {
        if (!isEmpty()) {
            if (size() == 1  && head==node) {
                head = tail = null;
            } else if (node == tail) {
                tail = tail.prev;
                tail.next.prev = null;
                tail.next = null;
            }  else if (node.prev ==null) {
                head = head.next;
                head.prev= null;
            }
            else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size--;
        }
    }

    public DNode<K,V> addLast(K key,V value) {
        DNode newNode = new DNode(key,value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return newNode;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void displayForward(){
        DNode cur=head;
        System.out.print("[");
        while (cur!=null){
            System.out.print(cur.key+"->"+cur.value+", ");
            cur=cur.next;
        }
        System.out.print("]");
        System.out.println();
    }

    public void displayBackward(){
        DNode cur=tail;
        System.out.print("[");
        while (cur!=null){
            System.out.print(cur.key+" -> "+cur.value+", ");
            cur=cur.prev;
        }
        System.out.print("]");
        System.out.println();
    }
}
