package trie.tuf;

import java.util.*;

public class MyTrie {

    public static void main(String[] args) {
        MyTrie t = new MyTrie();
        t.add("APPLE");
        t.add("HELP");
        t.add("DOC");
        t.add("APPLE");
        t.add("WINDOW");
        t.add("WINDOWS");
        t.add("DOCUMENT");

        //System.out.println(t.longestCompleteString(Arrays.asList("n","ni","nin","ninj","ninja")));
        //System.out.println(t.longestCompleteString(Arrays.asList("ni","nin","ninj","ninja")));
        System.out.println(t.getAllWords());
        System.out.println(t.autoComplete("D"));
        System.out.println(t.autoComplete("DOCU"));
        System.out.println(t.exists("APPLE"));
        System.out.println(t.existsPrefix("A"));
        System.out.println(t.existsPrefixCount("A"));
        System.out.println(t.existsPrefixCount("D"));
        System.out.println(t.existsPrefixCount("Z"));
        System.out.println(t.existsPrefixCount("DOC"));
        t.erase("DOC");
        System.out.println(t.existsPrefixCount("DOC"));
        System.out.println(t.exists("DOC"));
        System.out.println(t.exists("DOCUMENT"));
    }

    private TN root;


    public MyTrie() {
        this.root = new TN();
    }


    public  String longestCompleteString(List<String> words) {
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


    public  boolean checkPrefix(String prefix) {
        TN node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!node.exists(prefix.charAt(i)) && node.getEndCount() <= 1) {
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }

    public void add(String word) {
        TN node = root;
        for (char c : word.toCharArray()) {
            if (!node.exists(c)) {
                node.put(c, new TN());
            }
            node = node.get(c);
            node.incrementPrefixCount();
        }
        node.incrementEndCount();
    }

    public boolean exists(String word) {
        TN node = root;
        for (char c : word.toCharArray()) {
            if (!node.exists(c)) {
                return false;
            }
            node = node.get(c);
        }
        return node.getEndCount() > 0;
    }

    public boolean erase(String word) {
        TN node = root;
        if (exists(word)) {
            for (char c : word.toCharArray()) {
                node = node.get(c);
                node.decrementPrefixCount();
            }
            node.decrementEndCount();
            return true;
        } else return false;
    }

    public boolean existsPrefix(String word) {
        TN node = root;
        for (char c : word.toCharArray()) {
            if (!node.exists(c)) {
                return false;
            }
            node = node.get(c);
        }
        return true;
    }

    private void search(TN root, String prefix, String wsf, List<String> words) {
        TN node = root;
        if (node == null) {
            return;
        }
        if (node.getEndCount() > 0) {
            words.add(prefix + wsf);
        }
        for (Map.Entry<Character, TN> e : node.getChild().entrySet()) {
            search(e.getValue(), prefix, wsf + e.getKey(), words);
        }
    }

    public List<String> getAllWords() {
        List<String> words = new ArrayList<>();
        TN node = root;
        if (node == null) {
            return words;
        }
        search(node, "", "", words);
        return words;
    }

    public List<String> autoComplete(String prefix) {
        List<String> words = new ArrayList<>();
        TN node = root;
        if (node == null) {
            return words;
        }
        for (Character c : prefix.toCharArray()) {
            if (!node.exists(c)) {
                return words;
            }
            node = node.get(c);
        }
        search(node, prefix, "", words);
        return words;
    }

    public int existsPrefixCount(String word) {
        TN node = root;
        for (char c : word.toCharArray()) {
            if (!node.exists(c)) {
                return 0;
            }
            node = node.get(c);
        }
        return node.getPrefixCount();
    }

    static class TN {
        private Map<Character, TN> store;
        private int prefixCount;
        private int endCount;

        public TN() {
            this.store = new HashMap<>();
        }

        public void put(Character c, TN node) {
            store.put(c, node);
        }

        public TN get(Character c) {
            return store.get(c);
        }

        public Map<Character, TN> getChild() {
            return store;
        }

        public boolean exists(Character c) {
            return store.get(c) != null;
        }

        public int getPrefixCount() {
            return prefixCount;
        }

        public void incrementPrefixCount() {
            prefixCount++;
        }

        public void decrementPrefixCount() {
            prefixCount--;
        }

        public void setPrefixCount(int prefixCount) {
            this.prefixCount = prefixCount;
        }

        public int getEndCount() {
            return endCount;
        }

        public void incrementEndCount() {
            endCount++;
        }

        public void decrementEndCount() {
            endCount--;
        }

        public void setEndCount(int endCount) {
            this.endCount = endCount;
        }
    }
}
