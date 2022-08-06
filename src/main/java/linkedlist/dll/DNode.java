package linkedlist.dll;

public class DNode<K  extends Comparable<K>,V> {
    K key;
    V value;
    DNode next;
    DNode prev;

    public DNode() {
    }

    public DNode(K key,V value) {
        this.value = value;
        this.key = key;
    }
}
