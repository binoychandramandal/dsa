package disjointset;

import java.util.Arrays;

public class DisjointSet {
    public static void main(String[] args) {
        DisjointSet s = new DisjointSet(10);
//        System.out.println(s.find(1));
//        System.out.println(s.find(2));
//        System.out.println(s.find(3));
//        System.out.println(s.find(4));
//        System.out.println(Arrays.toString(s.parent));
//        System.out.println(s.union(0, 1));
//        System.out.println(s.union(1, 2));
//        System.out.println(s.union(3, 4));
//        System.out.println(s.union(2, 3));
//        System.out.println(s.union(4, 5));
//        System.out.println(s.union(5, 6));
//        System.out.println(s.union(6, 7));
//        System.out.println(s.union(7, 8));
//        System.out.println(s.union(8, 9));
//        System.out.println(s.isSameSet(2, 3));
//        System.out.println(s.isSameSet(8, 9));
//        System.out.println(s.isSameSet(1, 3));
//        System.out.println(s.isSameSet(0, 1));
//        System.out.println(Arrays.toString(s.parent));
//        s.find(4);



        System.out.println(s.union(8, 9));
        System.out.println(s.union(5, 4));
        System.out.println(s.isSameSet(2, 3));
        System.out.println(s.isSameSet(8, 9));
        System.out.println(s.isSameSet(1, 3));
        System.out.println(s.isSameSet(0, 1));
        System.out.println(Arrays.toString(s.parent));
        s.find(4);
    }

    private int parent[];
    private int[] rank;

    public DisjointSet(int capacity) {
        parent = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            parent[i] = i;
        }
        rank = new int[capacity];
    }

    public int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    public boolean isSameSet(int x, int y) {
        int xRepresentative = find(x);
        int yRepresentative = find(y);
        return xRepresentative == yRepresentative ? true : false;
    }

    public boolean union(int x, int y) {
        int xRepresentative = find(x);
        int yRepresentative = find(y);
        if (xRepresentative != yRepresentative) {
            if (rank[xRepresentative] < rank[yRepresentative]) {
                parent[xRepresentative] = yRepresentative;
            } else if (rank[yRepresentative] > rank[xRepresentative]) {
                parent[yRepresentative] = xRepresentative;
            } else {
                parent[yRepresentative] = xRepresentative;
                rank[xRepresentative]++;
            }
            return true;
        }
        return false;
    }

}
