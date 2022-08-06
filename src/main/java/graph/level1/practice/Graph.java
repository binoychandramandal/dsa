package graph.level1.practice;

import graph.level1.model.Edge;

import java.util.*;

public class Graph {
    private LinkedList<Edge>[] graph;

    public Graph(int vertices) {
        graph = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new LinkedList<>();
        }
    }

    public boolean isValidVertices(int src) {
        return src < 0 || src >= graph.length ? false : true;
    }

    public void addEdge(int src, int dest, int weight) {
        if (!isValidVertices(src) || !isValidVertices(dest)) {
            System.out.println("Invalid vertices -> " + src + " ->  " + dest);
            return;
        }
        graph[src].add(new Edge(src, dest, weight));
        //graph[dest].add(new Edge(dest, src, weight));
    }

    public void addEdge(int src, int dest) {
        addEdge(src, dest, 0);
    }

    public void dfs() {
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++)
            if (!visited[i]) dfs(i, visited);
        System.out.println();
    }

    private void dfs(int src, boolean[] visited) {
        System.out.print(src + " ");
        visited[src] = true;
        for (Edge edge : graph[src]) {
            if (visited[edge.getNbr()] == false)
                dfs(edge.getNbr(), visited);
        }
    }

    public void bfs(int src) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(src);
        while (!q.isEmpty()) {
            int count =q.size();
            for (int i = 0; i < count; i++) {
                Integer tmp = q.poll();
                if(visited[tmp]==true){
                    continue;
                }
                visited[tmp] = true;
                System.out.print(tmp + " ");
                for (Edge edge : graph[tmp]) {
                    if (visited[edge.getNbr()] == false)
                        q.offer(edge.getNbr());
                }
            }
            System.out.println();
        }

    }

    public boolean hasPath(int src, int dest) {
        boolean[] visited = new boolean[graph.length];
        return hasPath(graph, src, dest, visited);
    }

    public ArrayList<Integer> getPath(int src, int dest) {
        boolean[] visited = new boolean[graph.length];
        ArrayList<Integer> path = new ArrayList<>();
        hasPath(graph, src, dest, visited, path);
        return path;
    }

    public ArrayList<ArrayList<Integer>> getAllPaths(int src, int dest) {
        boolean[] visited = new boolean[graph.length];
        ArrayList<ArrayList<Integer> >paths = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        path.add(src);
        getAllPath(graph, src, dest, visited,paths, path);
        return paths;
    }

    public void printAllPaths(int src, int dest) {
        boolean[] visited = new boolean[graph.length];
        printAllPath(graph, src, dest, visited,src+"");
    }

    private boolean hasPath(LinkedList<Edge>[] graph, int src, int dest, boolean[] visited) {
        if (src == dest) {
            return true;
        }
        visited[src] = true;
        for (Edge edge : graph[src]) {
            if (visited[edge.getNbr()] == false) {
                boolean isPathExist = hasPath(graph, edge.getNbr(), dest, visited);
                if (isPathExist)
                    return true;

            }
        }
        return false;
    }

    private boolean hasPath(LinkedList<Edge>[] graph, int src, int dest, boolean[] visited, ArrayList<Integer> path) {
        if (src == dest) {
            path.add(src);
            return true;
        }
        visited[src] = true;
        for (Edge edge : graph[src]) {
            if (visited[edge.getNbr()] == false) {
                boolean isPathExist = hasPath(graph, edge.getNbr(), dest, visited, path);
                if (isPathExist) {
                    path.add(src);
                    return true;
                }
                visited[src] = false;
            }
        }
        return false;
    }

    private void getAllPath(LinkedList<Edge>[] graph, int src, int dest, boolean[] visited,ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path) {
        if (src == dest) {
            paths.add(path);
            return;
        }
        visited[src] = true;
        for (Edge edge : graph[src]) {
            if (visited[edge.getNbr()] == false) {
               ArrayList<Integer> p=new ArrayList<>(path);
               p.add(edge.getNbr());
                getAllPath(graph, edge.getNbr(), dest, visited, paths,p);
            }
        }
        visited[src]=false;
    }

    private void printAllPath(LinkedList<Edge>[] graph, int src, int dest, boolean[] visited,String psf) {
        if (src == dest) {
            System.out.println(psf);
            return;
        }
        visited[src] = true;
        for (Edge edge : graph[src]) {
            if (visited[edge.getNbr()] == false) {
                printAllPath(graph, edge.getNbr(), dest, visited, psf+"->"+edge.getNbr());
            }
        }
        visited[src]=false;
    }


    public void display() {
        for (int i = 0; i < graph.length; i++) {
            System.out.println(i + " -> " + graph[i]);
        }
    }

    public List<Integer> myBfs(int src){
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited =new boolean[graph.length];
        result.addAll(doBfs(src, visited));
        for (int i = 0; i < graph.length; i++) if (!visited[i]) result.addAll(doBfs(i, visited));
       return result;
    }

    private List<Integer> doBfs(int src,boolean[] visited){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q =new LinkedList<>();
        q.offer(src);
        visited[src] = true;
        while (!q.isEmpty()){
            Integer s =q.poll();
            result.add(s);
            for(Edge edge: graph[src]){
                if(visited[edge.getNbr()]==false){
                    visited[edge.getNbr()]=true;
                    q.offer(edge.getNbr());
                }
            }
        }
        return result;
    }



}
