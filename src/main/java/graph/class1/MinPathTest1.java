package graph.class1;

import java.util.List;

public class MinPathTest1 {
    public static void main(String[] args) {
        Graph g=new Graph(6);
        g.addEdgeUndirected(1,2);
        g.addEdgeUndirected(1,3);
        g.addEdgeUndirected(1,4);
        g.addEdgeUndirected(3,5);
        g.addEdgeUndirected(5,6);
        g.display();

        System.out.println(g.minPath(1,5));
        System.out.println(g.minPath(1,6));
        System.out.println(g.minPath(new int[]{1,6},2));

    }


}
