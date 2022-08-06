package graph.class1;

public class Test1 {
    public static void main(String[] args) {
        Graph g=new Graph(6);
        g.addEdgeUndirected(1,2);
        g.addEdgeUndirected(1,4);
        g.addEdgeUndirected(2,4);
        g.addEdgeUndirected(2,3);
        g.addEdgeUndirected(3,5);
        g.addEdgeUndirected(5,6);
        g.addEdgeUndirected(4,5);
        g.addEdgeUndirected(4,3,10);
        g.display();
        System.out.println(g.isPathPresent(1,6));
        System.out.println(g.minPath(1,6));
        System.out.println(g.dfs(6));
        System.out.println(g.bfs(new int[]{1,5}));
    }
}
