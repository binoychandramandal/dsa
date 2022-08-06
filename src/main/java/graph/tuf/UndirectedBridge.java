package graph.tuf;

import java.util.List;

public class UndirectedBridge {
    public static void main(String[] args) {
        Graph g=new Graph(5);
        g.addUnDirectedEdge(0,1);
        g.addUnDirectedEdge(2,0);
        g.addUnDirectedEdge(1,2);
        g.addUnDirectedEdge(1,3);
        g.addUnDirectedEdge(3,4);
        g.display();;
        findBridges(g.getGraph());

    }

    public static void findBridges(List<Edge>[] g){
        int[] vis =new int[g.length];
        int[] tin =new int[g.length];
        int[] low =new int[g.length];
        int timer =0;
        for (int i = 0; i < g.length; i++) {
            if(vis[i]==0){
                dfs(i,-1,vis,tin,low,g,timer);
            }
        }
    }
    private static void dfs(int node,int parent,int vis[],int[] tin,int[] low,List<Edge>[] adj,int timer){
        vis[node]=1;
        tin[node]=low[node]=timer++;
        for(Edge edge: adj[node]){
            if(edge.v==parent){
                continue;
            }
            if(vis[edge.v]==0){
                dfs(edge.v,node,vis,tin,low,adj,timer);
                low[node] = Math.min(low[node],low[edge.v]);
                if(low[edge.v]>tin[node]){
                    System.out.println(edge.v+" "+node);
                }
            }else{
                low[node] = Math.min(low[node],tin[edge.v]);
            }
        }
    }



}
