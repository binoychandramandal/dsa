package trie.tuf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumXOROfQueries {

    public static void main(String[] args) {
        System.out.println(1<<3);
        MaximumXOROfQueries m = new MaximumXOROfQueries();
        int[] max = m.queryResultForXor(new int[]{9, 8, 7, 5, 4}, new int[][]{{8, 10}, {4, 4}});
        System.out.println(Arrays.toString(max));
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

    int[] queryResultForXor(int[] a, int[][] queries) {
        Arrays.sort(a);
        List<List<Integer>> q = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            q.add(Arrays.asList(queries[i][1], queries[i][0], i));
        }
        Collections.sort(q, (x, y) -> x.get(0).compareTo(y.get(0)));
        int ind = 0;
        int n = a.length;
        int m=queries.length;
        int[] result = new int[queries.length];
        for (int i = 0; i < m; i++) {
            while (ind < n && a[ind] < q.get(i).get(0)) {
                insert(a[ind]);
                ind++;
            }
            int queryIndex = q.get(i).get(2);
            if (ind != 0)
                result[queryIndex] = getMaxXor(q.get(i).get(1));
            else result[queryIndex] = -1;
        }
        return result;

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
