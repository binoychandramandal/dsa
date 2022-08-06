package graph.tuf;

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addDirectedEdge(5, 0);
        g.addDirectedEdge(5, 2);
        g.addDirectedEdge(4, 0);
        g.addDirectedEdge(4, 1);
        g.addDirectedEdge(2, 3);
        g.addDirectedEdge(2, 5);
        g.addDirectedEdge(3, 1);
        g.display();
        System.out.println(detectCycle(g.getGraph()));
        System.out.println(topoSortDfs(g.getGraph()));
        System.out.println(topoSortBfs(g.getGraph()));

    }


    static boolean detectCycle(List<Edge>[] g) {
        int[] inDegree = new int[g.length];
        for (int i = 0; i < g.length; i++) {
            for (Edge edge : g[i]) {
                inDegree[edge.v]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < g.length; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        int count=0;
        while (!q.isEmpty()) {
            Integer curNode = q.poll();
           count++;
            for (Edge nbr : g[curNode]) {
                inDegree[nbr.v]--;
                if (inDegree[nbr.v] == 0) {
                    q.offer(nbr.v);
                }
            }
        }
        return count==g.length?false:true;
    }

    static List<Integer> topoSortBfs(List<Edge>[] g) {
        int[] inDegree = new int[g.length];
        for (int i = 0; i < g.length; i++) {
            for (Edge edge : g[i]) {
                inDegree[edge.v]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < g.length; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        List<Integer> l = new ArrayList<>();
        while (!q.isEmpty()) {
            Integer curNode = q.poll();
            l.add(curNode);
            for (Edge nbr : g[curNode]) {
                inDegree[nbr.v]--;
                if (inDegree[nbr.v] == 0) {
                    q.offer(nbr.v);
                }
            }
        }
        return l;
    }

    static List<Integer> topoSortDfs(List<Edge>[] g) {
        Stack<Integer> result = new Stack<>();
        boolean[] v = new boolean[g.length];
        for (int i = 0; i < g.length; i++) {
            if (v[i] == false) {
                dfs(i, g, v, result);
            }
        }
        List<Integer> l = new ArrayList<>();
        while (!result.isEmpty()) {
            l.add(result.pop());
        }
        return l;
    }


    private static void dfs(int node, List<Edge>[] g, boolean[] v, Stack<Integer> result) {
        v[node] = true;
        for (Edge nbr : g[node]) {
            if (v[nbr.v] == false) {
                dfs(nbr.v, g, v, result);
            }
        }
        result.push(node);
    }

}
