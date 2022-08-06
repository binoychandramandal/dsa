package graph.level1.practice;

public class GraphTest1 {
    public static void main(String[] args) {
        Graph graph=new Graph(7);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,0);
        graph.addEdge(1,2);
        graph.addEdge(2,1);
        graph.addEdge(2,3);
        graph.addEdge(3,0);
        graph.addEdge(3,2);
        graph.addEdge(3,4);
        graph.addEdge(4,3);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(5,4);
        graph.addEdge(5,6);
        graph.addEdge(6,4);
        graph.addEdge(6,5);
//        graph.dfs();
        // graph.dfs();
       graph.bfs(1);
//        System.out.println(graph.hasPath(0,6));
//        System.out.println(graph.getPath(0,6));
        System.out.println(graph.myBfs(1));
        System.out.println(graph.getAllPaths(4,6));
        graph.printAllPaths(4,6);

    }
}
