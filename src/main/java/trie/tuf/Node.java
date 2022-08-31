package trie.tuf;

/**
 * Trie node
 */
public class Node {
    private final  Node[] children = new Node[26];
    private boolean flag;

    public Node() {
    }
    public Node[] getChildren(){
        return children;
    }

    public boolean containsKey(char key) {
        return children[key - 'a'] != null;
    }

    public Node get(char key) {
        return children[key - 'a'];
    }

    public void put(char key, Node node) {
        children[key - 'a'] = node;
    }

    public void setEnd() {
        flag = true;
    }

    public boolean isEnd() {
        return flag;
    }

}
