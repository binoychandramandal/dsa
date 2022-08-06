package linkedlist.dll;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyLRUCache<K extends Comparable<K>, V> {

    private Map<K, DNode<K,V>> lookupMap;
    private DLinkedList<K,V> store;
    private int capacity;

    public MyLRUCache(int capacity) {
        this.capacity = capacity;
        clear();
    }

    public void clear() {
        store = new DLinkedList<>();
        lookupMap = new HashMap<>();
    }

    public int size() {
        return store.size();
    }

    public boolean isFull() {
        return store.size() == capacity;
    }

    public Set<K> getKeys() {
        return lookupMap.keySet();
    }

    public V get(K key) {
        if (lookupMap.containsKey(key)) {
            DNode<K,V> dNode = lookupMap.get(key);
            store.remove(dNode);
            lookupMap.put(key,store.addLast(key,dNode.value));
            return dNode.value;
        } else {
            return null;
        }

    }

    public void set(K key, V value) {
        DNode<K,V> existsKey = lookupMap.get(key);
        if (existsKey == null) {
            if(isFull()) {
                lookupMap.remove(store.getHead().key);
                store.remove(store.getHead());
            }
        } else {
            store.remove(existsKey);
        }
        existsKey = store.addLast(key,value);
        lookupMap.put(key, existsKey);
    }

    public void display() {
        DNode cur = store.getHead();
        while (cur != null) {
            System.out.print(cur.key+"->"+cur.value + ", ");
            cur = cur.next;
        }
        System.out.println();
    }
}
