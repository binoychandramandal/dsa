package trie.tuf;

public class MaximumXOROfTwoArray {

    public static void main(String[] args) {
        MaximumXOROfTwoArray m = new MaximumXOROfTwoArray();

        int max = m.maxXor(new int[]{9, 8, 7, 5, 4}, new int[]{8});
        System.out.println(max);
    }

    BN root = new BN();

    void insert(int num) {
        BN node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new BN());
            }
            node = node.get(bit);
        }
    }

    int maxXor(int[] a, int[] b) {
        for (int e : a) {
            insert(e);
        }
        int max = 0;
        for (int e : b) {
            max = Math.max(getMaxXor(e), max);
        }
        return max;

    }

    int getMaxXor(int num) {
        BN node = root;
        int max = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.containsKey(1 - bit)) {
                max |= (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }
        return max;
    }

    static class BN {
        BN[] child = new BN[2];

        public void put(int bit, BN node) {
            child[bit] = node;
        }

        public BN get(int bit) {
            return child[bit];
        }

        public boolean containsKey(int bit) {
            return child[bit] != null;
        }

    }
}
