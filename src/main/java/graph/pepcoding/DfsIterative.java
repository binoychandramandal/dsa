package graph.pepcoding;

import graph.tuf.Edge;
import graph.tuf.Graph;

import java.util.List;
import java.util.Stack;

public class DfsIterative {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addUnDirectedEdge(0, 1);
        g.addUnDirectedEdge(0, 3);
        g.addUnDirectedEdge(1, 2);
        g.addUnDirectedEdge(2, 3);
        g.addUnDirectedEdge(3, 4);
        g.addUnDirectedEdge(4, 5);
        g.addUnDirectedEdge(4, 6);
        g.addUnDirectedEdge(5, 6);
        System.out.println(dfs(g.getGraph(), 0, 6, new boolean[g.getGraph().length]));
        System.out.println(dfs(g.getGraph(), 0, 0, new boolean[g.getGraph().length]));
        System.out.println(dfs(g.getGraph(), 0, 1, new boolean[g.getGraph().length]));
        System.out.println(dfs(g.getGraph(), 0, 2, new boolean[g.getGraph().length]));
        System.out.println(dfs(g.getGraph(), 0, 3, new boolean[g.getGraph().length]));
        System.out.println(dfs(g.getGraph(), 0, 4, new boolean[g.getGraph().length]));
        System.out.println(dfs(g.getGraph(), 0, 5, new boolean[g.getGraph().length]));
        System.out.println(dfs(g.getGraph(), 0, 6, new boolean[g.getGraph().length]));
        System.out.println(dfs(g.getGraph(), 0, 7, new boolean[g.getGraph().length]));
    }

    static class Pair {
        int v;
        String psf;

        public Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
        }
    }

    static boolean dfs(List<Edge>[] g, int src, int dest, boolean[] v) {
        Stack<Pair> s = new Stack<>();
        s.push(new Pair(src, src + ""));
        v[src] = true;
        while (!s.isEmpty()) {
            Pair p = s.pop();
            if (p.v == dest) {
                System.out.println(p.psf);
                return true;
            }
            for (Edge edge : g[p.v]) {
                if (v[edge.v] == false) {
                    v[edge.v] = true;
                    s.push(new Pair(edge.v, p.psf + "," + edge.v));
                }
            }
            v[src]=false;
        }
        return false;
    }
}
