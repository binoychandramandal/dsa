package trie.tuf;

import java.util.HashMap;
import java.util.Map;

public class DistinctSubString {
    public static void main(String[] args) {
        DistinctSubString t =new DistinctSubString();
        System.out.println(t.countDistinct("abab"));

    }

    private DN root = new DN();

    public int countDistinct(String s){
        int count=1;
        for (int i = 0; i < s.length(); i++) {
              DN node= root;
            for (int j = i; j < s.length(); j++) {
                 if(!node.exists(s.charAt(j))){
                     count++;
                     node.put(s.charAt(j),new DN());
                 }
                 node=node.get(s.charAt(j));
            }
        }
        return count;
    }


    static class DN {
        private Map<Character, DN> store = new HashMap<>();

        public void put(Character c, DN node) {
            store.put(c, node);
        }

        public DN get(Character c) {
            return store.get(c);
        }

        public boolean exists(Character c) {
            return store.get(c) != null;
        }

    }
}
