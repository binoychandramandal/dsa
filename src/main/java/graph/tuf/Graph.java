package graph.tuf;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Edge>[] g;
    private int edgeCount;
    private List<Edge> edges = new ArrayList<>(0);
    private int vertices;

    public Graph(int v) {
        vertices = v + 1;
        g = new ArrayList[v + 1];
        for (int i = 0; i <= v; i++) {
            g[i] = new ArrayList<>(0);
        }
    }

    public int getVertices() {
        return vertices;
    }

    public int edgeCount() {
        return edgeCount;
    }

    private boolean isValidVertex(int s) {
        return s < 0 || s > g.length ? false : true;
    }

    public void addUnDirectedEdge(int u, int v, int w) {
        if (isValidVertex(u) && isValidVertex(v)) {
            edges.add(new Edge(u, v, w));
            g[u].add(new Edge(v, w));
            g[v].add(new Edge(u, w));
            edgeCount += 2;
        }
    }

    public void addUnDirectedEdge(int u, int v) {
        addUnDirectedEdge(u, v, 1);
    }

    public void addDirectedEdge(int u, int v, int w) {
        if (isValidVertex(u) && isValidVertex(v)) {
            edges.add(new Edge(u, v, w));
            g[u].add(new Edge(v, w));
            edgeCount++;
        }
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addDirectedEdge(int u, int v) {
        addDirectedEdge(u, v, 1);
    }

    public List<Edge>[] getGraph() {
        return g;
    }

    public void display() {
        for (int i = 0; i < g.length; i++) {
            System.out.println(i + " -> " + g[i]);
        }
    }
}
