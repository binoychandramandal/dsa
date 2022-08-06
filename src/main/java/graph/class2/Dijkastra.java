package graph.class2;

import graph.class1.Edge;
import graph.class1.Graph;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkastra {
    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.addEdgeUndirected(1, 4, 8);
        g.addEdgeUndirected(1, 2, 4);
        g.addEdgeUndirected(1, 7, 2);
        g.addEdgeUndirected(2, 3, 5);
        g.addEdgeUndirected(2, 7, 1);
        g.addEdgeUndirected(2, 8, 9);
        g.addEdgeUndirected(3, 8, 1);
        g.addEdgeUndirected(3, 10, 1);
        g.addEdgeUndirected(4, 7, 3);
        g.addEdgeUndirected(7, 8, 4);
        g.addEdgeUndirected(8, 5, 6);
        g.addEdgeUndirected(8, 6, 3);
        g.addEdgeUndirected(6, 9, 2);
        g.addEdgeUndirected(10, 9, 4);
        g.display1();
        System.out.println(dijkastra(g.getGraph(),10,1,8));
        System.out.println(dijkastra(g.getGraph(),10,1,4));
        System.out.println(dijkastra(g.getGraph(),10,1,5));
        System.out.println(dijkastra(g.getGraph(),10,5,1));
        System.out.println(dijkastra(g.getGraph(),10,1,9));
    }

    static class Pair implements Comparable<Pair> {
        int time;
        int vertex;

        public Pair() {
        }

        public Pair(int time, int vertex) {
            this.time = time;
            this.vertex = vertex;
        }

        public int getTime() {
            return time;
        }

        public int getVertex() {
            return vertex;
        }

        @Override
        public int compareTo(Pair o) {
            return this.time - o.time;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "time=" + time +
                    ", vertex=" + vertex +
                    '}';
        }
    }


    static int dijkastra(List<Edge>[] g, int vertices, int s, int d) {
        int[] dist = new int[vertices + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        minHeap.offer(new Pair(0, s));
        while (!minHeap.isEmpty()) {
            Pair x = minHeap.poll();
            int distance = x.time;
            int u = x.vertex;
           // if (distance == dist[u]) {
                for (int i = 0; i < g[u].size(); i++) {
                    Edge e = g[u].get(i);
                    int v = e.getNbr();
                    int w = e.getWeight();
                    if (dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                        minHeap.offer(new Pair(dist[v], v));
                    }
                //}
            }
        }
        return dist[d];
    }

}
