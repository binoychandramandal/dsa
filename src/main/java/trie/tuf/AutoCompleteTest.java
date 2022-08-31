package trie.tuf;

public class AutoCompleteTest {
    public static void main(String[] args) {
        AutoComplete a = new AutoComplete();
        a.add("apple");
        a.add("samsung");
        a.add("vivo");
        a.add("van");
        a.add("school");
        a.add("snake");
        System.out.println(a.autoComplete("sa"));
        System.out.println(a.autoComplete("v"));
        System.out.println(a.allWords());
    }
}

