package graph.pepcoding;

import graph.tuf.Edge;
import graph.tuf.Graph;

import java.util.HashSet;
import java.util.List;

public class HamiltonianPathAndCycle {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addUnDirectedEdge(0, 1);
        g.addUnDirectedEdge(0, 3);
        g.addUnDirectedEdge(1, 2);
        g.addUnDirectedEdge(2, 3);
        g.addUnDirectedEdge(2, 5);
        g.addUnDirectedEdge(3, 4);
        g.addUnDirectedEdge(4, 5);
        g.addUnDirectedEdge(4, 6);
        g.addUnDirectedEdge(5, 6);
        g.display();
        HashSet<Integer> visited = new HashSet<>();
        hamiltonianPath(g.getGraph(), 0, 0, visited, 0 + "", g.getVertices());
    }

    static void hamiltonianPath(List<Edge>[] g, int src, int startNode, HashSet<Integer> visited, String psf, int vertices) {
        if (visited.size() == vertices - 1) {
            boolean isCycle = false;
            for (Edge edge : g[src]) {
                if (edge.v == startNode) {
                    isCycle = true;
                    break;
                }
            }
            if (isCycle) {
                System.out.println(psf + " -> Hamiltonian cycle");
            } else {
                System.out.println(psf + " -> Hamiltonian Path");
            }
            return;
        }
        visited.add(src);
        for (Edge nbr : g[src]) {
            if (visited.contains(nbr.v) == false) {
                hamiltonianPath(g, nbr.v, startNode, visited, psf + nbr.v, vertices);
            }
        }
        visited.remove(src);
    }
}
