package graph.practice;

import graph.tuf.Edge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFS {
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
        g.addEdge(3, 4);
        g.addEdge(4, 3);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 4);
        g.addEdge(5, 6);
        g.addEdge(6, 4);
        g.addEdge(6, 5);
        g.display();
        System.out.println();
        System.out.println(dfs(g.g));
    }

    static List<Integer> dfs(List<Edge>[] g) {
        List<Integer> result = new ArrayList<>();
        boolean[] v = new boolean[g.length];
        for (int i = 0; i < g.length; i++) {
            if (v[i] == false) {
                dfsHelper(i, g, v, result);
            }
        }
        return result;
    }

    static void dfsHelper(int src, List<Edge>[] g, boolean[] v, List<Integer> result) {
        result.add(src);
        v[src] = true;
        for (Edge nbr : g[src]) {
            if (v[nbr.v] == false) {
                dfsHelper(nbr.v, g, v, result);
            }
        }
    }
}
