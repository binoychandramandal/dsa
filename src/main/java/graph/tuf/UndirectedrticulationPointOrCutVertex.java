package graph.tuf;

import java.util.List;

public class UndirectedrticulationPointOrCutVertex {
    public static void main(String[] args) {
        Graph g=new Graph(5);
        g.addUnDirectedEdge(0,1);
        g.addUnDirectedEdge(2,0);
        g.addUnDirectedEdge(1,2);
        g.addUnDirectedEdge(1,3);
        g.addUnDirectedEdge(3,4);
        findArticulationPoint(g.getGraph());
        System.out.println("Second graph");
        g=new Graph(13);
        g.addUnDirectedEdge(1,2);
        g.addUnDirectedEdge(1,4);
        g.addUnDirectedEdge(2,3);
        g.addUnDirectedEdge(3,4);
        g.addUnDirectedEdge(4,5);
        g.addUnDirectedEdge(5,6);
        g.addUnDirectedEdge(6,9);
        g.addUnDirectedEdge(6,7);
        g.addUnDirectedEdge(7,8);
        g.addUnDirectedEdge(9,8);
        g.addUnDirectedEdge(8,10);
        g.addUnDirectedEdge(10,11);
        g.addUnDirectedEdge(10,12);
        g.addUnDirectedEdge(11,12);
        findArticulationPoint(g.getGraph());

    }

    public static void findArticulationPoint(List<Edge>[] g){
        int[] vis =new int[g.length];
        int[] tin =new int[g.length];
        int[] low =new int[g.length];
        int[] isArticulation=new int[g.length];
        int timer =0;
        for (int i = 0; i < g.length; i++) {
            if(vis[i]==0){
                dfs(i,-1,vis,tin,low,g,timer,isArticulation);
            }
        }
        for (int i = 0; i < g.length; i++) {
            if(isArticulation[i]==1){
                System.out.println(i);
            }
        }
    }

    private static void dfs(int node, int parent, int vis[], int[] tin, int[] low, List<Edge>[] adj, int timer, int[] isArticulation) {
        vis[node] = 1;
        tin[node] = low[node] = timer++;
        int child = 0;
        for (Edge edge : adj[node]) {
            if (edge.v == parent) {
                continue;
            }
            if (vis[edge.v] == 0) {
                dfs(edge.v, node, vis, tin, low, adj, timer, isArticulation);
                low[node] = Math.min(low[node], low[edge.v]);
                if (low[edge.v] >= tin[node] && parent != -1) {
                    isArticulation[node] = 1;
                }
                child++;
            } else {
                low[node] = Math.min(low[node], tin[edge.v]);
            }
        }
        if (parent == -1 && child > 1) {
            isArticulation[node] = 1;
        }
    }



}
