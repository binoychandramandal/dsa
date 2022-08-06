package graph.tuf;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetectionUndirectedBFSAndDFS {
    public static void main(String[] args) {
        Graph g = new Graph(11);
        g.addUnDirectedEdge(1, 2);
        g.addUnDirectedEdge(2, 4);
        g.addUnDirectedEdge(3, 5);
        g.addUnDirectedEdge(5, 6);
        g.addUnDirectedEdge(6, 7);
        //g.addUnDirectedEdge(7, 8);
        g.addUnDirectedEdge(8, 11);
        g.addUnDirectedEdge(5, 10);
        g.addUnDirectedEdge(10, 9);
        g.addUnDirectedEdge(9, 8);
        g.display();
        System.out.println(detectCycleUsingBfs(g.getGraph()));
        System.out.println(detectCycleUsingDfs(g.getGraph()));
    }

    static public boolean detectCycleUsingBfs(List<Edge>[] g) {
        boolean[] visited = new boolean[g.length + 1];
        for (int currentVertx = 1; currentVertx < g.length; currentVertx++) {
            if (visited[currentVertx] == false) {
                if (isCycle(currentVertx, g, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    static public boolean detectCycleUsingDfs(List<Edge>[] g) {
        boolean[] visited = new boolean[g.length + 1];
        for (int currentVertx = 1; currentVertx < g.length; currentVertx++) {
            if (visited[currentVertx] == false) {
                if (isCycleUsingDfs(currentVertx, -1, g, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCycleUsingDfs(int currentVertx, int parentNode, List<Edge>[] g, boolean[] visited) {
        visited[currentVertx] = true;
        for (Edge nbr : g[currentVertx]) {
            if (visited[nbr.v] == false) {
               if(isCycleUsingDfs(nbr.v, currentVertx, g, visited)) return true;
            } else if (nbr.v != parentNode) {
                return true;
            }
        }
        return false;
    }

    static class Pair {
        int node;
        int parentNode;

        public Pair(int node, int parentNode) {
            this.node = node;
            this.parentNode = parentNode;
        }

        @Override
        public String toString() {
            return "node=" + node + ", parentNode=" + parentNode;
        }
    }

    static private boolean isCycle(int currentVertx, List<Edge>[] g, boolean[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(currentVertx, -1));
        visited[currentVertx] = true;
        while (!q.isEmpty()) {
            Pair cNode = q.poll();
            for (Edge nbr : g[cNode.node]) {
                if (visited[nbr.v] == false) {
                    visited[nbr.v] = true;
                    q.offer(new Pair(nbr.v, cNode.node));
                } else if (nbr.v != cNode.parentNode) {
                    return true;
                }
            }
        }
        return false;


    }
}
