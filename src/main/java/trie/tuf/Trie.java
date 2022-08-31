package trie.tuf;

public class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    /**
     * Insert A word in Trie
     *
     * @param word
     */
    public void add(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                node.put(c, new Node());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    /**
     * Does word exists in trie
     *
     * @param word
     * @return
     */
    public boolean exists(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                return false;
            }
            node = node.get(c);
        }
        return node.isEnd();
    }

    /**
     * Does any words start with given prefix
     *
     * @param word
     * @return
     */
    public boolean startWith(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                return false;
            }
            node = node.get(c);
        }
        return true;
    }
}
