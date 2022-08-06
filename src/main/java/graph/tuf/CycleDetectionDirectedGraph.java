package graph.tuf;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetectionDirectedGraph {
    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.addDirectedEdge(1,2);
        g.addDirectedEdge(2,3);
        g.addDirectedEdge(3,5);
        g.addDirectedEdge(3,4);
        g.addDirectedEdge(4,6);
        g.addDirectedEdge(5,7);
        g.addDirectedEdge(7,6);
        g.addDirectedEdge(5,8);
        g.addDirectedEdge(8,9);
        g.addDirectedEdge(9,10);
        g.addDirectedEdge(10,5);
        g.display();
        System.out.println(isCycle(g.getGraph()));
    }

    static public  boolean isCycle(List<Edge>[] g){
        boolean[] v =new boolean[g.length];
        boolean[] dfsV =new boolean[g.length];
        for (int i = 0; i < g.length; i++) {
            if(v[i]==false){
                if(isCycle(i,g,v,dfsV)){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isCycle(int currentVertx, List<Edge>[] g, boolean[] visited,boolean[] dfsV) {
        visited[currentVertx] = true;
        dfsV[currentVertx]=true;
        for (Edge nbr : g[currentVertx]) {
            if (visited[nbr.v] == false) {
                if (isCycle(nbr.v, g, visited,dfsV)) return true;
            } else if (dfsV[nbr.v]) {
                return true;
            }
        }
        dfsV[currentVertx]=false;
        return false;
    }


}
