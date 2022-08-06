package graph.tuf;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DirectedStronglyConnectedComponent {
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addDirectedEdge(0, 1);
        g.addDirectedEdge(1, 2);
        g.addDirectedEdge(2, 0);
        g.addDirectedEdge(1, 3);
        g.addDirectedEdge(3, 4);
        g.display();
        stronglyConnectedComponent(g.getGraph());

    }

    /**
     * kosaraju algorithm
     * @param g
     */
    public static void stronglyConnectedComponent(List<Edge>[] g) {
        int[] vis = new int[g.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < g.length; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, g, s);
            }
        }
        List<Edge>[] transposeGraph = new ArrayList[g.length];
        for (int i = 0; i < g.length; i++) {
            transposeGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < g.length; i++) {
            vis[i]=0;
            for(Edge edge:g[i]){
                transposeGraph[edge.v].add(new Edge(i));
            }
        }
        while (!s.isEmpty()) {
            int node=s.pop();
            if(vis[node]==0){
                System.out.print("SCC: ");
                reverseDfs(node,vis,transposeGraph);
                System.out.println();
            }
        }

    }

    private static void dfs(int node, int vis[], List<Edge>[] adj,Stack<Integer> s) {
        vis[node] = 1;
        for (Edge edge : adj[node]) {
            if (vis[edge.v] == 0) {
                dfs(edge.v, vis, adj,s);
            }
        }
        s.push(node);
    }

    private static void reverseDfs(int node, int vis[], List<Edge>[] transpose) {
        vis[node] = 1;
        System.out.print(node + " ");
        for (Edge edge : transpose[node]) {
            if (vis[edge.v] == 0) {
                reverseDfs(edge.v, vis, transpose);
            }
        }
    }


}
