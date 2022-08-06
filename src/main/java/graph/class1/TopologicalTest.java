package graph.class1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalTest {
    public static void main(String[] args) {

        int[][] edges = {
                {2, 1},
                {2, 3},
                {2, 7},
                {2, 8},
                {3, 4},
                {3, 5},
                {3, 7},
                {7, 5},
                {7, 6},
                {9, 1},
                {10,3}};
        topologicalSort(10, edges);
        int[][] edges1 = {
                {3, 1},
                {3,4},
                {1,2},
                {2,6},
                {2,5},
                {6,4},
                {4,1}};
        System.out.println(isCyclePresent(6,edges1));

        int[][] edge2 = {
                {1,2},
                {1,3},
                {1,4},
                {4,5},
                {5,5}
               };
        System.out.println(isCyclePresent(6,edge2));
    }

    static void topologicalSort(int vertices, int[][] edges) {
        List<Edge>[] g = new List[vertices + 1];
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>(0);
        }
        int[] inDegreeCount = new int[vertices + 1];
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            inDegreeCount[v]++;
            g[u].add(new Edge(u, v));
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= vertices; i++) {
            if (inDegreeCount[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.println(u);
            for (int i = 0; i < g[u].size(); i++) {
                int v = g[u].get(i).nbr;
                inDegreeCount[v]--;
                if (inDegreeCount[v] == 0) {
                    q.offer(v);
                }
            }
        }
    }

    static boolean isCyclePresent(int vertices, int[][] edges) {
        List<Edge>[] g = new List[vertices + 1];
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>(0);
        }
        int[] inDegreeCount = new int[vertices + 1];
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            inDegreeCount[v]++;
            g[u].add(new Edge(u, v));
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= vertices; i++) {
            if (inDegreeCount[i] == 0) {
                q.offer(i);
            }
        }
        int verticesProcessed =0;
        while (!q.isEmpty()) {
            int u = q.poll();
            verticesProcessed++;
            for (int i = 0; i < g[u].size(); i++) {
                int v = g[u].get(i).nbr;
                inDegreeCount[v]--;
                if (inDegreeCount[v] == 0) {
                    q.offer(v);
                }
            }
        }
        return vertices!=verticesProcessed?true:false;
    }
}
