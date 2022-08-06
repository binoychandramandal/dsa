package graph.pepcoding;

import graph.tuf.Edge;
import graph.tuf.Graph;

import java.util.ArrayList;
import java.util.List;

public class IsConnectedComponent {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addUnDirectedEdge(0, 1);
        g.addUnDirectedEdge(2, 3);
        g.addUnDirectedEdge(4, 5);
        g.addUnDirectedEdge(4, 6);
        g.addUnDirectedEdge(5, 6);
        System.out.println(isGraphConnected(g));

        g = new Graph(6);
        g.addUnDirectedEdge(0, 1, 10);
        g.addUnDirectedEdge(0, 3, 40);
        g.addUnDirectedEdge(1, 2, 10);
        g.addUnDirectedEdge(2, 3, 10);
        g.addUnDirectedEdge(3, 4, 2);
        g.addUnDirectedEdge(4, 5, 3);
        g.addUnDirectedEdge(4, 6, 8);
        g.addUnDirectedEdge(5, 6, 3);
        System.out.println(isGraphConnected(g));
    }


    static boolean isGraphConnected(Graph g) {
        ArrayList<List<Integer>> comp = new ArrayList<>();
        boolean[] v = new boolean[g.getVertices()];
        for (int i = 0; i < g.getVertices(); i++) {
            if (v[i] == false) {
                List<Integer> com = new ArrayList<>();
                drawTree(g.getGraph(), i, v, com);
                comp.add(com);
                return com.size()==g.getVertices();
            }
        }
        return false;
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
