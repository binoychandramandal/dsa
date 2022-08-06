package graph.class1;

public class Test2 {
    public static void main(String[] args) {
        Graph g=new Graph(15);
        g.addEdgeUndirected(1,3);
        g.addEdgeUndirected(1,2);
        g.addEdgeUndirected(1,6);
        g.addEdgeUndirected(3,4);
       // g.addEdgeUndirected(2,3);
        //g.addEdgeUndirected(6,4);

        g.addEdgeUndirected(5,9);
       // g.addEdgeUndirected(5,7);
        g.addEdgeUndirected(9,8);
        g.addEdgeUndirected(7,8);

        g.addEdgeUndirected(10,11);
        g.addEdgeUndirected(10,14);
        g.addEdgeUndirected(11,12);
       // g.addEdgeUndirected(11,14);
        g.addEdgeUndirected(14,12);

        g.addEdgeUndirected(13,15);


        g.display();
        System.out.println(g.isPathPresent(1,6));
        System.out.println(g.minPath(1,6));
        System.out.println(g.dfs(6));
        System.out.println(g.getConnectedComponent());
        System.out.println(g.getEdgeCount());
        System.out.println(g.detectCycle(15,g.getEdgeCount()));
        System.out.println(g.bfs(new int[]{1,6}));

    }
}
