package graph.level1;

import graph.level1.model.Edge;

import java.util.ArrayList;

public class Util {

    public static ArrayList<Edge>[] generateUndirectedGraph(int vertices, int[][] edges, boolean isWeighted, boolean isDirected) {
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int nbr = edges[i][1];
            int weight = isWeighted ? edges[i][2] : 1;
            graph[src].add(new Edge(src, nbr, weight));
            if (!isDirected)
                graph[nbr].add(new Edge(nbr, src, weight));
        }
        return graph;
    }


}
