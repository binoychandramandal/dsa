package trie.tuf;

public class TestTrie {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.add("apple");
        t.add("help");
        t.add("people");
        System.out.println(t.exists("apple"));
        System.out.println(t.startWith(null));
    }
}
