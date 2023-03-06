package trie.tuf.practice1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LCP {
    public static void main(String[] args) {
        System.out.println(findLCP( Arrays.asList("abcd","abcde","wwwww",
                "code", "coder", "coding", "codable", "codec", "codecs", "coded",
                "codeless", "codependence", "codependency", "codependent",
                "codependents", "codes", "codesign", "codesigned", "codeveloped",
                "codeveloper", "codex", "codify", "codiscovered", "codrive"
        )));
    }

    public static String findLCP(List<String> dict) {

        //insert all word
        MyTri myTri = new MyTri();
        for (String word : dict) {
            myTri.insert(word);
        }

        // traverse the Trie and find the longest common prefix

        String max ="";
        for (Map.Entry<Character,MyTri.Node > entry :myTri.getRoot().getAllChild().entrySet() ) {
            StringBuilder lcp = new StringBuilder();
            lcp.append(entry.getKey());
            MyTri.Node curr = entry.getValue();

            // loop until we find a leaf node or a node has more than 1 child
            while (curr != null && !curr.isLeaf() && (curr.getAllChild().size() == 1)) {
                for (Map.Entry<Character, MyTri.Node> entry1 : curr.getAllChild().entrySet()) {
                    // append current char to LCP
                    lcp.append(entry1.getKey());

                    // update `curr` pointer to the child node
                    curr = entry1.getValue();
                }
            }
            if(max.length()<lcp.length()){
                max =lcp.toString();
            }
        }
        return max;

    }
}
