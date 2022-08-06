package graph.tuf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DirectedWeightedBellmanFord {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addDirectedEdge(3, 2, 6);
        g.addDirectedEdge(5, 3, 1);
        g.addDirectedEdge(0, 1, 5);
        g.addDirectedEdge(1, 5, -3);
        g.addDirectedEdge(1, 2, -2);
        g.addDirectedEdge(3, 4, -2);
        g.addDirectedEdge(2, 4, 3);
        g.display();
        System.out.println(g.getEdges().size());
        bellmanFord(g.getEdges(),6,0);

    }

    /**
     * Bellman ford Algorithm
     *
     * @param g
     */
    public static void bellmanFord(List<Edge> g,int N,int src) {
        int[] dist = new int[N];
        Arrays.fill(dist,10000000);
        dist[src]=0;

        for (int i = 1; i <= N-1; i++) {
           for(Edge edge:g){
               if(dist[edge.src]+edge.w<dist[edge.v]){
                   dist[edge.v]=dist[edge.src]+edge.w;
               }
           }
        }
        boolean isNegative =false;

        for(Edge edge:g){
            if(dist[edge.src]+edge.w<dist[edge.v]){
                isNegative=true;
                System.out.println("Negative Cycle Detected");
                break;
            }
        }
        if(!isNegative) {
            for (int i = 0; i < N; i++) {
                System.out.println(i+" "+dist[i]);
            }
        }
        System.out.println(Arrays.toString(dist));

    }
}
