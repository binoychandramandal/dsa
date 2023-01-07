package trie.tuf.practice;

public class TrieTest {
    public static void main(String[] args) {
        Trie t =new Trie();
        t.add("hello");
        t.add("apple");
        t.add("world");
        System.out.println(t.existsWord("hello"));
        System.out.println(t.existsWord("apple"));
        System.out.println(t.existsWord("appl"));
        System.out.println(t.existsPrefix("applee"));
        System.out.println(t.erase("apple"));
        t.add("apple");
        System.out.println(t.existsWord("apple"));
        System.out.println(t.existsPrefix("apple"));
    }
}
