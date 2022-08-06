package graph.class1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

    private List<Edge>[] graph;

    public Graph(int vertices) {
        this.graph = new List[vertices + 1];
        for (int i = 0; i <= vertices; i++) {
            graph[i] = new ArrayList<>(0);
        }
    }

    public List<Edge>[] getGraph() {
        return graph;
    }

    private boolean isValidVertex(int vertex) {
        return (vertex <= 0 || vertex >= graph.length) ? false : true;
    }

    public void addEdgeUndirected(int src, int nbr) {
        addEdgeUndirected(src, nbr, 1);
    }

    public void addEdgeDirected(int src, int nbr) {
        addEdgeDirected(src, nbr, 1);
    }

    public void addEdgeDirected(int src, int nbr, int weight) {
        if (!isValidVertex(src) || !isValidVertex(nbr)) {
            System.out.println("Vertex invalid");
            return;
        }
        graph[src].add(new Edge(src, nbr, weight));
    }

    public void addEdgeUndirected(int src, int nbr, int weight) {
        if (!isValidVertex(src) || !isValidVertex(nbr)) {
            System.out.println("Vertex invalid");
            return;
        }
        graph[src].add(new Edge(src, nbr, weight));
        graph[nbr].add(new Edge(nbr, src, weight));
    }


    public boolean isPathPresent(int src, int nbr) {
        if (!isValidVertex(src) || !isValidVertex(nbr)) {
            System.out.println("Invalid vertex");
            return false;
        }
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited[src] = true;
        while (!q.isEmpty()) {
            Integer v = q.poll();
            for (Edge edge : graph[v]) {
                if (visited[edge.nbr] == false) {
                    q.offer(edge.getNbr());
                    visited[edge.getNbr()] = true;
                }
            }
        }
        return visited[nbr];
    }

    public int minPath(int src, int nbr) {
        if (!isValidVertex(src) || !isValidVertex(nbr)) {
            System.out.println("Invalid vertex");
            return -1;
        }
        boolean[] visited = new boolean[graph.length];
        int[] dis = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited[src] = true;
        while (!q.isEmpty()) {
            Integer u = q.poll();
            for (Edge edge : graph[u]) {
                Integer v=edge.nbr;
                if (visited[edge.nbr] == false) {
                    dis[v]=dis[u]+1;
                    q.offer(edge.getNbr());
                    visited[edge.getNbr()] = true;
                }
            }
        }
        return dis[nbr];
    }

    public int minPath(int[] src, int nbr) {
        if ( !isValidVertex(nbr)) {
            System.out.println("Invalid vertex");
            return -1;
        }
        boolean[] visited = new boolean[graph.length];
        int[] dis = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < src.length; i++) {
            q.offer(src[i]);
            visited[src[i]] = true;
        }
        while (!q.isEmpty()) {
            Integer u = q.poll();
            for (Edge edge : graph[u]) {
                Integer v=edge.nbr;
                if (visited[edge.nbr] == false) {
                    dis[v]=dis[u]+1;
                    q.offer(edge.getNbr());
                    visited[edge.getNbr()] = true;
                }
            }
        }
        return dis[nbr];
    }

    public List<Integer> dfs(int src){
        ArrayList<Integer> result=new ArrayList<>();
        boolean[] visited= new boolean[graph.length];
        dfsHelper(graph,visited,src,result);
        return result;
    }

    private void  dfsHelper(List<Edge>[] graph,boolean [] visited,int src,List<Integer> path){
        if(visited[src]==true){
            return;
        }
        visited[src]=true;
        path.add(src);
        for (Edge edge : graph[src]) {
            if(visited[edge.nbr]==false){
                dfsHelper(graph,visited,edge.nbr,path);
            }
        }
    }
    public int getConnectedComponent(){
        int count=0;
        boolean[] visited =new boolean[graph.length];
        for (int i = 1; i < graph.length ; i++) {
            if(visited[i]==false){
                dfsHelper(graph,visited,i,new ArrayList<>());
                count++;
            }
        }
        return count;
    }

    public boolean detectCycle(int nodeCount,int edgeCount){
        int count=getConnectedComponent();
        return (nodeCount-count)==edgeCount?false:true;
    }


    public int getEdgeCount(){
        int count=0;
        for (int j = 1; j < graph.length; j++) {
            List<Edge> edges = graph[j];
            for (Edge e : edges) {
                count++;
            }
        }
        return count/2;
    }

    List<Integer> bfs(int[] src){
        List<Integer> result =new ArrayList<>();
        boolean[] visited =new boolean[graph.length];
        Queue<Integer> q=new LinkedList<>();
        for (Integer i :src) {
            q.offer(i);
            visited[i]=true;
        }
        while (q.size()>0){
            Integer u =q.poll();
            result.add(u);
            for (Edge e : graph[u]) {
                Integer v=e.nbr;
                if(visited[v]==false){
                    q.offer(v);
                    visited[v]=true;
                }
            }
        }
        return result;
    }

    public void display() {
        for (int j = 1; j < graph.length; j++) {
            List<Edge> edges = graph[j];
            String edge = "";
            for (Edge e : edges) {
                edge += e.nbr + (e.weight > 1 ? " : " + e.weight : " ");
            }
            System.out.println(j + " -> " + "{ " + edge + "}");
        }
    }
    public void display1() {
        for (int j = 1; j < graph.length; j++) {
            List<Edge> edges = graph[j];
            System.out.println(j+" : "+edges);
        }
    }
}
