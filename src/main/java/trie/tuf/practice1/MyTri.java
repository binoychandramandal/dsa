package trie.tuf.practice1;

import java.util.HashMap;
import java.util.Map;

public class MyTri {

    public static void main(String[] args) {
        MyTri head =new MyTri();
        head.insert("techie");
        head.insert("techi");
        head.insert("tech");

        System.out.println(head.search("tech"));            // true
        System.out.println(head.search("techi"));           // true
        System.out.println(head.search("techie"));          // true
        System.out.println(head.search("techiedelight"));   // false

        head.insert("techiedelight");

        System.out.println(head.search("tech"));            // true
        System.out.println(head.search("techi"));           // true
        System.out.println(head.search("techie"));          // true
        System.out.println(head.search("techiedelight"));   // true
    }

    private Node root = new Node();

    public Node getRoot() {
        return root;
    }

    public void insert(String word) {
        if (word != null && !word.isEmpty()) {
            Node cur = root;
            for (Character c : word.toCharArray()) {
                if (!cur.isChildExists(c)) {
                    cur.addChild(c);
                }
                cur = cur.getChild(c);
            }
            cur.setLeaf(true);
        }
    }


    public boolean search(String word) {
        if (word == null || word.isEmpty())
            return false;
        Node cur = root;
        for (Character c : word.toCharArray()) {
            if (!cur.isChildExists(c)) {
                return false;
            }
            cur = cur.getChild(c);
        }
        return cur.isLeaf();
    }

    public static class Node {

        private boolean isLeaf;
        private Map<Character, Node> childMap = new HashMap<>();


        public boolean isLeaf() {
            return isLeaf;
        }

        public void setLeaf(boolean leaf) {
            isLeaf = leaf;
        }

        public Map<Character, Node> getAllChild() {
            return childMap;
        }

        public void addChild(Character c) {
            this.childMap.put(c, new Node());
        }

        public void addChild(Character c, Node node) {
            this.childMap.put(c, node);
        }

        public boolean isChildExists(Character c) {
            return childMap.containsKey(c);
        }

        public Node getChild(Character c) {
            return childMap.get(c);
        }
    }
}
