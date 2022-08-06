package graph.pepcoding;

import graph.tuf.Edge;
import graph.tuf.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class PerfectFriend {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addUnDirectedEdge(0, 1);
        g.addUnDirectedEdge(2, 3);
        g.addUnDirectedEdge(4, 5);
        g.addUnDirectedEdge(4, 6);
        g.addUnDirectedEdge(5, 6);
        System.out.println( makePerfectPair(g));
    }


    static int makePerfectPair(Graph g) {
        ArrayList<List<Integer>> comp = new ArrayList<>();
        boolean[] v = new boolean[g.getVertices()];
        for (int i = 0; i < g.getVertices(); i++) {
            if (v[i] == false) {
                List<Integer> com = new ArrayList<>();
                drawTree(g.getGraph(), i, v, com);
                comp.add(com);
            }
        }
        int pair =0;
        for (int i = 0; i < comp.size(); i++) {
            for (int j = i+1; j < comp.size(); j++) {
                pair+=(comp.get(i).size()*comp.get(j).size());
            }
        }

       return pair;
    }

    static void drawTree(List<Edge>[] g, int src, boolean[] v, List<Integer> vn) {
        v[src] = true;
        vn.add(src);
        for (Edge edge : g[src]) {
            if (v[edge.v] == false) {
                drawTree(g, edge.v, v, vn);
            }
        }
    }
}
