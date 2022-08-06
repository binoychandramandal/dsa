package linkedlist;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LRUCache {
    public static void main(String[] args) {
        LRUCache s = new LRUCache(1);
        //S 2 1 S 2 2 G 2 S 1 1 S 4 1 G 2
        s.set(2, 1);
        s.set(2, 2);
        System.out.println(s.get(2));
        s.set(1, 1);
        s.set(4, 1);
        System.out.println(s.get(2));
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        LRUCache.Node entry = hm.get(LRUCache.Entry.of(key, 0));
        if (entry != null) {
            remove(entry);
            insertAtBack(entry);
        } else {
            return -1;
        }
        return entry != null ? entry.data.value : -1;
    }

    private Map<Entry, Node> hm = new HashMap<>();
    private Node head = new Node(Entry.of(1, Integer.MIN_VALUE));
    private Node tail = head;
    private int capacity;

    public void insertAtBack(Node newNode) {
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void remove(Node t) {
        if (t.next == null) {
            Node pre = tail.prev;
            pre.next = null;
            tail.prev = null;
            tail = pre;
        } else {
            t.prev.next = t.next;
            t.next.prev = t.prev;
        }
    }

    public void set(int key, int value) {
        Entry entry = Entry.of(key, value);
        Node temp = hm.get(entry);
        if (temp != null) {
            //HIT
            //edge case when element is in last position
            // if (temp.next != null) {
            remove(temp);
            temp.data = entry;
            hm.remove(entry, temp);
            insertAtBack(temp);
            hm.put(entry, temp);
            // }
        } else {
            //MISS
            Node newNode = new Node(entry);
            hm.put(entry, newNode);
            if (hm.size() >= capacity) {
                //insert directly
            } else {
                hm.remove(entry);
                remove(newNode);
            }
            insertAtBack(newNode);
        }
    }

    static class Node {
        Entry data;
        Node next;
        Node prev;

        public Node(Entry data) {
            this.data = data;
        }
    }

    static class Entry {
        int key;
        int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        static Entry of(int key, int value) {
            return new Entry(key, value);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return key == entry.key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }

}
