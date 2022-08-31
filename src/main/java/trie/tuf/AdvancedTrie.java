package trie.tuf;

public class AdvancedTrie {
    private AdvancedNode root;

    public AdvancedTrie() {
        root = new AdvancedNode();
    }

    /**
     * Insert A word in Trie
     *
     * @param word
     */
    public void add(String word) {
        AdvancedNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                node.put(c, new AdvancedNode());
            }
            node = node.get(c);
            node.increasePrefix();
        }
        node.increaseEnd();
    }

    /**
     * How many words with given word
     *
     * @param word
     * @return
     */
    public int countWordsEqualsTo(String word) {
        AdvancedNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                return 0;
            }
            node = node.get(c);
        }
        return node.getEnd();
    }

    /**
     * How many words which start with given prefix
     *
     * @param word
     * @return
     */
    public int countWordsStartsWith(String word) {
        AdvancedNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                return 0;
            }
            node = node.get(c);
        }
        return node.getPrefix();
    }

    /**
     * Erase this word in trie
     *
     * @param word
     */
    public void erase(String word) {
        if (!exists(word)) {
            return;
        }
        AdvancedNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                return;
            }
            node = node.get(c);
            node.reducePrefix();
        }
        node.deleteEnd();
    }

    /**
     * Exists this word in trie or not
     *
     * @param word
     * @return
     */
    public boolean exists(String word) {
        AdvancedNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                return false;
            }
            node = node.get(c);
        }
        return node.getEnd() > 0;
    }

}
