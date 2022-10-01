package graph.practice;

import graph.tuf.Edge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    List<Edge>[] g;

    public Graph(int capacity) {
        this.g = new ArrayList[capacity + 1];
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }
    }

    public void addEdge(int src, int dest) {
        g[dest].add(new Edge(src));
    }

    public void display() {
        boolean[] v = new boolean[g.length];
        for (int i = 1; i < g.length; i++) {
            if (v[i] == false) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                v[i] = true;
                while (!q.isEmpty()) {
                    Integer currentVertex = q.poll();
                    System.out.print(currentVertex + " ");
                    for (Edge nbr : g[currentVertex]) {
                        if (v[nbr.v] == false) {
                            q.offer(nbr.v);
                            v[nbr.v] = true;
                        }
                    }
                }
            }
        }
    }
}
