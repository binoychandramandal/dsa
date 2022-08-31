package trie.tuf;

public class AdvancedTrieTest {

    public static void main(String[] args) {
        AdvancedTrie t =new AdvancedTrie();
        t.add("samsung");
        t.add("samsung");
        t.add("samsung");
        t.add("samsung");
        t.add("samsungi");
        t.add("vivo");
        t.add("vivo");

        System.out.println(t.countWordsEqualsTo("samsung"));
        System.out.println(t.countWordsEqualsTo("samsungi"));
        System.out.println(t.countWordsStartsWith("samsung"));
        System.out.println(t.countWordsStartsWith("sam"));
        System.out.println(t.countWordsStartsWith("v"));
        t.erase("vivo");
        t.erase("vivo");
        t.erase("vivo");
        t.erase("vivo");
        t.erase("vivo");
        t.erase("vivo");
        t.erase("samsungi");
        System.out.println(t.countWordsStartsWith("vivo"));
        System.out.println(t.countWordsEqualsTo("samsungi"));
        System.out.println(t.countWordsStartsWith("sam"));
    }
}
