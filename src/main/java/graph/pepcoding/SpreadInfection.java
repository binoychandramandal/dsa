package graph.pepcoding;

import graph.tuf.Edge;
import graph.tuf.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class SpreadInfection {
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
        System.out.println(spreadInfection(g.getGraph(),4,3));
        System.out.println(spreadInfection1(g.getGraph(),4,3));
    }

    static class Pair {
        int v;
        int time;

        public Pair(int v, int time) {
            this.v = v;
            this.time = time;
        }
    }

    static int spreadInfection(List<Edge>[] g, int src,int maxTime) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src, 1));
        int[] v = new int[g.length];
        int count=0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if(v[p.v]>0){
                continue;
            }
            v[p.v]=p.time;
            if(p.time>maxTime){
                break;
            }
            count++;
            for (Edge edge : g[p.v]) {
                if (v[edge.v] == 0) {
                    q.offer(new Pair(edge.v, p.time+1));
                }
            }
        }
        return count;
    }


    static int spreadInfection1(List<Edge>[] g, int src,int maxTime) {
        boolean[] v = new boolean[g.length];
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src, 1));
        int count=0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if(p.time>maxTime){
                break;
            }
            if(v[p.v]==true){
                continue;
            }
            v[p.v]=true;
            count++;
            System.out.println(p.v+" -> "+p.time);
            for (Edge edge : g[p.v]) {
                if (v[edge.v] == false) {
                    q.offer(new Pair(edge.v, p.time+1));
                }
            }
        }
        return count;
    }
}
