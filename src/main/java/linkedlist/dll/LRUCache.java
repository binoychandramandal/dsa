package linkedlist.dll;

import java.util.HashMap;
import java.util.Set;

public class LRUCache {
    private HashMap<Integer, Node> lookupMap;
    private DLL store;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        lookupMap = new HashMap<>();
        store = new DLL();
        store.addLast(Integer.MIN_VALUE);
    }

    int size() {
        return store.size() - 1;
    }

    boolean isFull() {
        return store.size() - 1 == capacity;
    }

    boolean exists(int key) {
        Node node = lookupMap.get(key);
        if (node == null) {
            return false;
        } else {
            store.removeNode(node);
            node = store.addLast(key);
            lookupMap.put(key, node);
        }
        return true;
    }

    int get(int key) {
        Node node = lookupMap.get(key);
        if (node == null) {
            return -1;
        } else {
            store.removeNode(node);
            node = store.addLast(key,node.data);
            lookupMap.put(key, node);
            return node.data;
        }
    }

    Set<Integer> getKeySet() {
        return lookupMap.keySet();
    }


    void put(int key,int value) {
        Node node = lookupMap.get(key);
        if (node == null) {
            if (isFull()) {
                lookupMap.remove(store.getHead().next.key);
                store.removeNode(store.getHead().next);
            }
            node = store.addLast(key,value);
        } else {
            store.removeNode(node);
            node = store.addLast(key,value);
        }
        lookupMap.put(key, node);
    }

    void display() {
        Node cur = store.getHead().next;
        while (cur != null) {
            System.out.print("["+cur.key + " -> "+cur.data+"]"+ " ");
            cur = cur.next;
        }
        System.out.println();
    }

}
