package graph.tuf;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathDirected {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addDirectedEdge(0, 1, 2);
        g.addDirectedEdge(0, 4, 1);
        g.addDirectedEdge(1, 2, 3);
        g.addDirectedEdge(2, 3, 6);
        g.addDirectedEdge(4, 2, 2);
        g.addDirectedEdge(4, 5, 4);
        g.addDirectedEdge(5, 3, 1);
        g.display();
        System.out.println(findShortestPath(g.getGraph(),0,5));
        System.out.println(findShortestPath(g.getGraph(),0,3));
        System.out.println(findShortestPath(g.getGraph(),3,0));
        System.out.println(findShortestPath(g.getGraph(),0,2));
    }

    static int findShortestPath(List<Edge>[] g, int src,int dest) {
        Stack<Integer> s = new Stack<>();
        boolean[] v = new boolean[g.length];
        int[] dist = new int[g.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i < g.length; i++) {
            if (v[i] == false)
                dfs(i, s, g, v);
        }
        while (!s.isEmpty()){
           int node= s.pop();
            if(dist[node]!=Integer.MAX_VALUE){
               for(Edge edge:g[node]){
                   if(dist[node]+edge.w<dist[edge.v]){
                       dist[edge.v] =  dist[node]+edge.w;
                   }
               }
            }
        }
        return dist[dest];
    }

    private static void dfs(int i, Stack<Integer> s, List<Edge>[] g, boolean[] v) {
        v[i] = true;
        for (Edge edge : g[i]) {
            if (v[edge.v] == false) {
                dfs(edge.v, s, g, v);
            }
        }
        s.push(i);
    }
}
