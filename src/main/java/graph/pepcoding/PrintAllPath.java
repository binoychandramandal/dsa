package graph.pepcoding;

import graph.tuf.Edge;
import graph.tuf.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class PrintAllPath {
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
        g.display();
        System.out.println(printAllPath(g.getGraph(), 0, 5));
    }

    static List<List<Integer>> printAllPath(List<Edge>[] g, int src, int dest) {
        Stack<Integer> s = new Stack<>();
        s.push(src);
        boolean[] visited = new boolean[g.length];
        List<List<Integer>> resultPaths = new ArrayList<>();
        printAllPath(g, src, dest, s, visited, resultPaths);
        return resultPaths;
    }

    static void printAllPath(List<Edge>[] g, int src, int dest, Stack<Integer> visitedNode, boolean[] visited, List<List<Integer>> resultPaths) {
        if (src == dest) {
            System.out.println(visitedNode);
            resultPaths.add(visitedNode.stream().collect(Collectors.toList()));
            return;
        }
        visited[src] = true;
        for (Edge nbr : g[src]) {
            if (visited[nbr.v] == false) {
                visitedNode.push(nbr.v);
                printAllPath(g, nbr.v, dest, visitedNode, visited, resultPaths);
                if (!visitedNode.isEmpty()) {
                    visitedNode.pop();
                }
            }
        }
        visited[src] = false;
    }
}
