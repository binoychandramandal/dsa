package graph.practice;

import graph.tuf.Edge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectedComponentCountUsingBFS {
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
        // g.addEdge(3, 4);
        //g.addEdge(4, 3);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 4);
        g.addEdge(5, 6);
        g.addEdge(6, 4);
        g.addEdge(6, 5);
        g.display();
        System.out.println();
        System.out.println(bfs(g.g));
    }

    static int bfs(List<Edge>[] g) {
        List<Integer> result = new ArrayList<>();
        boolean[] v = new boolean[g.length];
        int count = 0;
        for (int i = 0; i < g.length; i++) {
            if (v[i] == false) {
                bfsHelper(i, g, v, result);
                count++;
            }
        }
        return count;
    }

    static void bfsHelper(int src, List<Edge>[] g, boolean[] v, List<Integer> result) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        v[src] = true;
        while (!q.isEmpty()) {
            Integer currentVertex = q.poll();
            result.add(currentVertex);
            for (Edge nbr : g[currentVertex]) {
                if (v[nbr.v] == false) {
                    q.offer(nbr.v);
                    v[nbr.v] = true;
                }
            }
        }
    }
}
