package graph.tuf;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SpringTree {
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addUnDirectedEdge(0, 1, 2);
        g.addUnDirectedEdge(1, 2, 3);
        g.addUnDirectedEdge(0, 3, 6);
        g.addUnDirectedEdge(1, 3, 8);
        g.addUnDirectedEdge(1, 4, 5);
        g.addUnDirectedEdge(2, 4, 7);
        g.display();

        System.out.println("Prims");
        primsAlgo(g.getGraph());
        System.out.println("\nprims Enhanced");
        primsAlgoEnhanced(g.getGraph());
    }

    public static void primsAlgo(List<Edge>[] g) {
        int[] key = new int[g.length];
        int[] parent = new int[g.length];
        boolean[] mstSet = new boolean[g.length];
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        key[0]=0;
        for (int i = 0; i < g.length-1; i++) {
            int mini =Integer.MAX_VALUE,u =0;
            for (int v = 0; v < g.length; v++) {
                if(mstSet[v]==false && key[v]<mini){
                    mini=key[v];
                    u=v;
                }
            }
            mstSet[u] = true;
            for (Edge edge:g[u]) {
                if(mstSet[edge.v]==false && edge.w<key[edge.v]){
                    parent[edge.v]=u;
                    key[edge.v] = edge.w;
                }
            }
        }

        for (int i = 1; i < g.length; i++) {
            System.out.print(parent[i]+" -> "+i +" - ");
        }
    }

    public static void primsAlgoEnhanced(List<Edge>[] g) {
        int[] key = new int[g.length];
        int[] parent = new int[g.length];
        boolean[] mstSet = new boolean[g.length];
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        key[0]=0;
        PriorityQueue<Edge> pq=new PriorityQueue<>(( o1,o2)->o1.w-o2.w);
        pq.offer(new Edge(0,key[0]));
        for (int i = 0; i < g.length; i++) {
            int u =pq.poll().v;
            mstSet[u] = true;
            for (Edge edge:g[u]) {
                if(mstSet[edge.v]==false && edge.w<key[edge.v]){
                    parent[edge.v]=u;
                    key[edge.v] = edge.w;
                    pq.offer(new Edge(edge.v, edge.w));
                }
            }
        }
        for (int i = 1; i < g.length; i++) {
            System.out.print(parent[i]+" -> "+i +" - ");
        }
    }
}
