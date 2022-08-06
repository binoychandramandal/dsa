package linkedlist;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    private Map<Entry, Node> hm = new HashMap<>();
    private Node head = new Node(Entry.of(1, Integer.MIN_VALUE));
    private Node tail = head;
    private int capacity;

    public static void main(String[] args) {
        String opstring="95 11 S 1 1 G 11 G 11 S 3 10 G 10 S 3 12 S 1 15 S 4 12 G 15 S 8 6 S 5 3 G 2 G 12 G 10 S 11 5 G 7 S 5 1 S 15 5 G 2 S 13 8 G 3 S 14 2 S 12 11 S 7 10 S 5 4 G 9 G 2 S 13 5 S 10 14 S 9 11 G 5 S 13 11 S 8 12 G 10 S 5 12 G 8 G 11 G 8 S 9 11 S 10 6 S 7 12 S 1 7 G 10 G 9 G 15 G 15 G 3 S 15 4 G 10 G 14 G 10 G 12 G 12 S 14 7 G 11 S 9 10 S 6 12 S 14 11 G 3 S 7 5 S 1 14 S 2 8 S 11 12 S 8 4 G 3 S 13 15 S 1 4 S 5 3 G 3 G 9 G 14 G 9 S 13 10 G 14 S 3 9 G 8 S 3 5 S 6 4 S 10 3 S 11 13 G 8 G 4 S 2 11 G 2 G 9 S 15 1 G 9 S 7 8 S 4 3 G 3 G 1 S 8 4 G 13 S 1 2 G 3";
        Queue<String> q=new LinkedList<>(Arrays.stream(opstring.split(" ")).collect(Collectors.toList()));
       int time=Integer.valueOf(q.poll());
        Solution s=new Solution(Integer.valueOf(q.poll()));

        while (!q.isEmpty()) {
            String o= q.poll();
            if(o.equalsIgnoreCase("S")){
                 int key=Integer.valueOf(q.poll());
                 int value=Integer.valueOf(q.poll());
                 s.set(key,value);
            }else if(o.equalsIgnoreCase("G")){
                System.out.print(s.get(Integer.valueOf(q.poll()))+" ");
            }
        }

    }
    
    public Solution(int capacity) {
        this.capacity=capacity;
    }
    public int get(int key) {
        Solution.Node entry = hm.get(Solution.Entry.of(key, 0));
        if (entry != null) {
            remove(entry);
            insertAtBack(entry);
        } else {
            return -1;
        }
        return entry != null ? entry.data.value : -1;
    }

    public void insertAtBack(Solution.Node newNode) {
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public Node remove(Solution.Node t) {
        if(hm.size()==0){
            tail=head;
            return null;
        }
        if (t.next == null) {
            Solution.Node pre = tail.prev;
            pre.next = null;
            tail.prev = null;
            Node current=tail;
            tail = pre;
            return current;
        } else {
            t.prev.next = t.next;
            t.next.prev = t.prev;
        }
        return null;
    }

    public void set(int key, int value) {
        Solution.Entry entry = Solution.Entry.of(key, value);
        Solution.Node temp = hm.get(entry);
        if (temp != null) {
            //HIT
            //edge case when element is in last position
             if (temp.next == null) {}else{
            remove(temp);
            temp.data = entry;
            hm.remove(entry);
            insertAtBack(temp);
            hm.put(entry, temp);
            }
        } else {
            //MISS
            Solution.Node newNode = new Solution.Node(entry);
            hm.put(entry, newNode);
            if (hm.size() <= capacity) {
                //insert directly
            } else {
                hm.remove(head.next.data);
                remove(head.next);
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
