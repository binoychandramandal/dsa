package graph.practice;

import graph.tuf.Edge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteUisngDFS {
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

    static boolean dfs(List<Edge>[] g) {
        List<Integer> result = new ArrayList<>();
        int[] color = new int[g.length];
        for (int i = 0; i < g.length; i++) {
            if (color[i] == -1) {
                if (!dfsHelper(i, g, color, result)) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean dfsHelper(int src, List<Edge>[] g, int[] color, List<Integer> result) {
        if(color[src]==-1){
            color[src]=1;
        }
        for (Edge nbr : g[src]) {
                if (color[nbr.v] == -1) {
                    color[nbr.v] = 1 - color[src];
                } else if (color[nbr.v] == color[src]) {
                    return false;
                }
        }
        return true;
    }

}
