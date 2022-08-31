package trie.tuf;

import java.util.ArrayList;
import java.util.List;

public class AutoComplete {
    private Node root;

    public AutoComplete() {
        this.root = new Node();
    }

    public void add(String word) {
        if (word == null || word.length() <= 0) {
            return;
        }
        Node node = root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                node.put(c, new Node());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    public List<String> autoComplete(String prefix) {
        List<String> auto = new ArrayList<>();
        if (prefix == null || prefix.length() <= 0) {
            return auto;
        }
        Node node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.containsKey(c)) {
                return auto;
            }
            node = node.get(c);
        }
        search(node, auto, prefix);
        return auto;
    }

    private void search(Node node, List<String> auto, String prefix) {
        if (node == null) {
            return;
        }
        if (node.isEnd()) {
            auto.add(prefix);
        }
        for (int i = 0; i < node.getChildren().length; i++) {
            Node child = node.getChildren()[i];
            if (child != null) {
                search(child, auto, prefix + "" + ((char) (i + 'a')));
            }
        }
    }

    public List<String> allWords() {
        List<String> words = new ArrayList<>();
        search(root, words, "");
        return words;
    }
}
