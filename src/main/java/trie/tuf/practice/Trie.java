package trie.tuf.practice;

import java.util.List;

public class Trie {
    private TN root = new TN();

    public void add(String word) {
        if (word != null && !word.isEmpty()) {
            TN cur = root;
            for (char c : word.toCharArray()) {
                TN tmp = cur.getChildren(c);
                if (tmp == null) {
                    cur.addChildren(c);
                }
                cur = cur.getChildren(c);
                cur.incPrefixCount();
            }
            cur.incWordEndCount();
        }
    }

    public void addAll(List<String> words){
        if(words!=null && !words.isEmpty()){
            words.forEach(x->add(x));
        }
    }

    public void displayAllWord(){

    }

    private void search(TN node,String prefix,List<String> ans){
        if(node==null)
            return;
        //if(node.wo)
    }

    public boolean existsWord(String word) {
        if (word != null && !word.isEmpty()) {
            TN cur = root;
            for (char c : word.toCharArray()) {
                TN tmp = cur.getChildren(c);
                if (tmp == null) {
                    return false;
                }
                cur = cur.getChildren(c);
            }
            return cur.getWordEndCount() > 0;
        } else {
            return false;
        }
    }

    public boolean existsPrefix(String prefix) {
        if (prefix != null && !prefix.isEmpty()) {
            TN cur = root;
            for (char c : prefix.toCharArray()) {
                TN tmp = cur.getChildren(c);
                if (tmp == null) {
                    return false;
                }
                cur = cur.getChildren(c);
                if(cur.getPrefixCount()<=0){
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean erase(String word) {
        if (word != null && !word.isEmpty() && existsWord(word)) {
            TN cur = root;
            for (char c : word.toCharArray()) {
                cur = cur.getChildren(c);
                cur.decPrefixCount();
            }
            cur.decWordEndCount();
            return true;
        } else {
            return false;
        }
    }


}
