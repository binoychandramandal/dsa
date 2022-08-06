package graph.pepcoding;

import graph.tuf.Edge;
import graph.tuf.Graph;

import java.util.List;

public class HasPath {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addUnDirectedEdge(0, 1);
        g.addUnDirectedEdge(0, 3);
        g.addUnDirectedEdge(1, 2);
        g.addUnDirectedEdge(2, 3);
        g.addUnDirectedEdge(3, 4);
        g.addUnDirectedEdge(4, 5);
        g.addUnDirectedEdge(4, 6);
        g.addUnDirectedEdge(5, 6);
        System.out.println( hasPath(g.getGraph(), 0, 6, new boolean[g.getGraph().length]));
    }

    static boolean hasPath(List<Edge>[] g, int src, int dest, boolean[] v) {
        if (src == dest) {
            return true;
        }
        v[src] = true;
        for (Edge edge : g[src]) {
            if (v[edge.v] == false) {
                if(hasPath(g, edge.v, dest, v)){
                    return true;
                }
            }
        }
        return false;
    }
}
