package graph.tuf;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInUndirectedGraph {
    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.addUnDirectedEdge(0,1);
        g.addUnDirectedEdge(0,2);
        g.addUnDirectedEdge(0,3);
        g.addUnDirectedEdge(1,4);
        g.addUnDirectedEdge(1,5);
        g.addUnDirectedEdge(5,0);

        g.display();
        System.out.println(Arrays.toString(findAllShortestPath(g.getGraph(), 0)));
    }


    static int[] findAllShortestPath(List<Edge>[] g, int src) {
        int[] dist = new int[g.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        while (!q.isEmpty()) {
            Integer curNode = q.poll();
            for (Edge nbr : g[curNode]) {
                if (dist[curNode] + 1 < dist[nbr.v]) {
                    dist[nbr.v] = dist[curNode] + 1;
                    q.offer(nbr.v);
                }
            }
        }
        return dist;
    }


}
