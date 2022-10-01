package graph.practice;

import graph.tuf.Edge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleUisngDFS {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(3, 2);
//        g.addEdge(3, 4);
//        g.addEdge(4, 3);
//        g.addEdge(4, 5);
//        g.addEdge(4, 6);
//        g.addEdge(5, 4);
//        g.addEdge(5, 6);
//        g.addEdge(6, 4);
//        g.addEdge(6, 5);
        g.display();
        System.out.println();
        System.out.println(dfs(g.g));
    }

    static boolean dfs(List<Edge>[] g) {
        List<Integer> result = new ArrayList<>();
        boolean[] v = new boolean[g.length];
        for (int i = 0; i < g.length; i++) {
            if (v[i] == false) {
                if (dfsHelper(i, -1, g, v, result)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean dfsHelper(int src,int parent, List<Edge>[] g, boolean[] v, List<Integer> result) {
        v[src] = true;
            for (Edge nbr : g[src]) {
                if (v[nbr.v] == false) {
                    v[nbr.v] = true;
                } else if (nbr.v != parent) {
                    return true;
                }
        }
        return false;
    }

}
