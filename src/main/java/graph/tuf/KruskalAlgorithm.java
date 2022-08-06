package graph.tuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgorithm {
    public static void main(String[] args) {
        List<Node> edges=new ArrayList<>();
        edges.add(new Node(0,1,1));
        edges.add(new Node(0,4,5));
        edges.add(new Node(1,4,6));
        edges.add(new Node(1,2,2));
        edges.add(new Node(2,4,4));
        edges.add(new Node(2,3,7));
        edges.add(new Node(4,3,8));
        edges.add(new Node(4,3,8));
        kruskalAlgo(edges,100);
    }

    static class Node {
        int u, v, w;

        public Node() {
        }

        public Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void kruskalAlgo(List<Node> edges, int vertices) {
        //sort edge based on weight
        Collections.sort(edges, (o1, o2) -> o1.w - o2.w);
        DisjointSet disjointSet = new DisjointSet(vertices);
        int minCost = 0;
        List<Node> mst = new ArrayList<>();
        int count =0;
        for (Node it : edges) {
            //if two node not in same set already
            if ( disjointSet.findWIthPathCompression(it.u) != disjointSet.findWIthPathCompression(it.v)) {
                minCost += it.w;
                mst.add(it);
                disjointSet.unionByRank(it.u, it.v);
            }
        }
        System.out.println("Min Cost-> "+minCost);
        for (int i = 0; i < mst.size(); i++) {
            System.out.println(mst.get(i).u + " -> " + mst.get(i).v+" -> "+mst.get(i).w);
        }

    }
}
