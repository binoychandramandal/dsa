package trie.tuf;

/**
 * Trie node
 */
public class AdvancedNode {
    private AdvancedNode[] childs = new AdvancedNode[26];
    private int countEndWith;
    private int countPrefix;

    public void put(char key, AdvancedNode node) {
        childs[key - 'a'] = node;
    }

    public AdvancedNode get(char key) {
        return childs[key - 'a'];
    }

    public boolean containsKey(char key) {
        return childs[key - 'a'] != null;
    }

    public void increaseEnd() {
        countEndWith++;
    }

    public void deleteEnd() {
        countEndWith--;
    }

    public void increasePrefix() {
        countPrefix++;
    }

    public void reducePrefix() {
        countPrefix--;
    }

    public int getEnd() {
        return countEndWith;
    }

    public int getPrefix() {
        return countPrefix;
    }

}
