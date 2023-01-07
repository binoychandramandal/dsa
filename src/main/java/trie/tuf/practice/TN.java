package trie.tuf.practice;

import java.util.HashMap;
import java.util.Map;

public class TN {

    private Map<Character, TN> children = new HashMap<>();
    private int prefixCount = 0;
    private int wordEndCount = 0;


    public void addChildren(char c) {
        this.children.put(c,new TN());
    }

    public TN getChildren(char c) {
        return this.children.get(c);
    }
    public Map<Character, TN> getAllChildren() {
        return this.children;
    }

    public int getPrefixCount() {
        return prefixCount;
    }

    public void incPrefixCount() {
        this.prefixCount++;
    }
    public void decPrefixCount() {
        this.prefixCount--;
    }

    public int getWordEndCount() {
        return wordEndCount;
    }

    public void  incWordEndCount() {
        this.wordEndCount++;
    }
    public void  decWordEndCount() {
        this.wordEndCount--;
    }
}
