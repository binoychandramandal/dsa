package graph.tuf;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraphUsingBFSAndDFS {
    public static void main(String[] args) {
        Graph notbipartite = new Graph(5);
        notbipartite.addUnDirectedEdge(1, 2);
        notbipartite.addUnDirectedEdge(1, 3);
        notbipartite.addUnDirectedEdge(2, 3);
        notbipartite.addUnDirectedEdge(2, 4);
        notbipartite.addUnDirectedEdge(3, 5);
        notbipartite.display();

        Graph bipartite = new Graph(7);
        bipartite.addUnDirectedEdge(1, 2);
        bipartite.addUnDirectedEdge(1, 3);
        bipartite.addUnDirectedEdge(2, 4);
        bipartite.addUnDirectedEdge(3, 5);
        bipartite.addUnDirectedEdge(4, 6);
        bipartite.addUnDirectedEdge(5, 6);
        bipartite.addUnDirectedEdge(6, 7);
        bipartite.display();
        System.out.println(checkBipartiteUsingBfs(bipartite.getGraph()));
        System.out.println(checkBipartiteUsingBfs(notbipartite.getGraph()));

        System.out.println(checkBipartiteUsingDfs(bipartite.getGraph()));
        System.out.println(checkBipartiteUsingDfs(notbipartite.getGraph()));

    }

    static boolean checkBipartiteUsingBfs(List<Edge>[] g) {
        int[] color = new int[g.length];
        Arrays.fill(color, -1);
        for (int i = 1; i < g.length; i++) {
            if (color[i] == -1) {
                if (!bfsCheck(i, g, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bfsCheck(int node, List<Edge>[] g, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        color[node] = 1;
        while (!q.isEmpty()) {
            Integer nde = q.poll();
            for (Edge nbr : g[nde]) {
                if (color[nbr.v] == -1) {
                    color[nbr.v] = 1 - color[nde];
                    q.offer(nbr.v);
                } else if (color[nbr.v] == color[nde]) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkBipartiteUsingDfs(List<Edge>[] g) {
        int[] color = new int[g.length];
        Arrays.fill(color, -1);
        for (int i = 1; i < g.length; i++) {
            if (color[i] == -1) {
                if (!dfsCheck(i, g, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean dfsCheck(int node, List<Edge>[] g, int[] color) {
        if (color[node] == -1)
            color[node] = 1;
        for (Edge nbr : g[node]) {
            if (color[nbr.v] == -1) {
                color[nbr.v] = 1 - color[node];
                if (!dfsCheck(nbr.v, g, color)) {
                    return false;
                }
            } else if (color[nbr.v] == color[node]) {
                return false;
            }
        }
        return true;
    }

}
