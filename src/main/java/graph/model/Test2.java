package graph.model;

import java.util.*;

public class Test2 {

    public static void main(String[] args) {
        Graph g=new Graph();

       int[][] temp= {{1, 2},
            {4, 1},
            {2, 4},
            {3, 4},
            {5, 2},
            {1, 3}};
       ArrayList<ArrayList<Integer>> B=new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {
            ArrayList<Integer> a=new ArrayList<>();
            a.add(temp[i][0]);
            a.add(temp[i][1]);
           B.add(a);
        }

        for(ArrayList<Integer> al:B){
            g.addEdge(al.get(0),al.get(1));
        }
        System.out.println(g.m);

        boolean[] visited=new boolean[g.m.size()+1];
        Queue<Integer> q=new LinkedList<>();
        q.offer(1);
        while(!q.isEmpty()){
            Integer rem=q.poll();
            if(visited[rem]==true){
                continue;
            }
            visited[rem]=true;
            if(rem==g.m.size()){
                System.out.println(1);
                return;
            }
            for(Edge edge: g.m.get(rem)){
                if(visited[edge.nbr]==false){
                    q.offer(edge.nbr);
                }
            }
        }
        System.out.println(0);

    }

    static class Graph {
        Map<Integer, List<Edge>> m = new HashMap<>();

        void addEdge(int src, int nbr) {
            List<Edge> edges = m.get(src);
            if (edges == null) {
                edges = new ArrayList<>();
            }
            edges.add(new Edge(src, nbr));
            m.put(src, edges);
        }
    }

    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }

        public String toString() {
            return "[" + src + "," + nbr + "]";
        }
    }
}
