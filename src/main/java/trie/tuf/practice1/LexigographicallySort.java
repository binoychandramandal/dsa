package trie.tuf.practice1;

public class LexigographicallySort {
    public static void main(String[] args) {
        String s = "lexicographic sorting of a set of keys can be accomplished with " +
                "a simple trie based algorithm we insert all keys in a trie output " +
                "all keys in the trie by means of preorder traversal which results " +
                "in output that is in lexicographically increasing order preorder " +
                "traversal is a kind of depth first traversal";

        String[] words = s.split(" ");

        LexigographicallySort l = new LexigographicallySort();
        for (String word : words) {
            l.insert(word);
        }

        l.preoder(l.root);


    }

    private Node root = new Node();

    public void preoder(Node head){
        if(head==null)
            return;
        for (int i = 0; i < 26; i++) {
          if(head.getChild(i)!=null){
              System.out.println(((char)'a'+i));
          }
            preoder(head.getChild(i));
        }
    }

    public void insert(String word) {
        if (word != null && word.length() != 0) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                if (!cur.exists(c)) {
                    cur.addChild(c);
                }
                cur = cur.getChildWithChar(c);
            }
            //cur.setLeaf(true);
        }
    }


    static class Node {
        private String key;
        private Node[] child = new Node[26];

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public boolean exists(Character c) {
            return child[c - 'a'] != null;
        }

        public Node getChildWithChar(Character c) {
            return child[c - 'a'];
        }
        public Node getChild(int index) {
            return child[index];
        }

        public void addChild(Character c) {
            child[c - 'a'] = new Node();
        }
    }
}
