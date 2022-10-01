package trie.tuf;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestCompleteString {
    public static void main(String[] args) {
        LongestCompleteString t = new LongestCompleteString();
        //System.out.println(t.longestCompleteString(Arrays.asList("n", "ni", "nin", "ninj", "ninja")));
        System.out.println(t.longestCompleteString(Arrays.asList("ni", "nin", "ninj", "ninja")));
    }

    public String longestCompleteString(List<String> words) {
        for (String word : words) {
            add(word);
        }
        String maxWord = "";

        for (String word : words) {
            if (checkPrefix(word)) {
                if (maxWord.length() < word.length() || (maxWord.length() == word.length() && word.compareTo(maxWord) < 0)) {
                    maxWord = word;
                }
            }
        }
        return maxWord;
    }

    public void add(String word) {
        TNode node = root;
        for (Character c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                node.put(c, new TNode());
            }
            node = node.get(c);
        }
        node.setEnd(true);
    }

    public boolean checkPrefix(String word) {
        TNode node = root;
        for (Character c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                return false;
            }
            node = node.get(c);
            if (!node.isEnd()) {
                return false;
            }

        }
        return true;
    }

    private TNode root = new TNode();

    static class TNode {
        private boolean isEnd;
        private Map<Character, TNode> children = new HashMap<>(1);

        public Map<Character, TNode> getChildren() {
            return children;
        }

        public TNode get(Character c) {
            return children.get(c);
        }

        public void put(Character c, TNode node) {
            children.put(c, node);
        }

        public boolean containsKey(Character c) {
            return children.get(c) != null;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }
    }
}
