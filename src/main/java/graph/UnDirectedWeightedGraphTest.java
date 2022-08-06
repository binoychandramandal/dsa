package graph;

import graph.implmentation.UnDirected;
import graph.implmentation.UnDirectedWeighted;
import graph.model.Vertex;

public class UnDirectedWeightedGraphTest {
    public static void main(String[] args) {
        UnDirectedWeighted graph=new UnDirectedWeighted();
        graph.addVertex(new Vertex(1));
        graph.addVertex(new Vertex(2));
        graph.addVertex(new Vertex(3));
        graph.addVertex(new Vertex(4));

        graph.addEdge(new Vertex(1),new Vertex(2),10);
        graph.addEdge(new Vertex(1),new Vertex(3),20);
        graph.addEdge(new Vertex(3),new Vertex(4),30);
        graph.addEdge(new Vertex(3),new Vertex(5),40);
        graph.addEdge(new Vertex(2),new Vertex(4),50);
        graph.addEdge(new Vertex(4),new Vertex(5),60);
        graph.addEdge(new Vertex(4),new Vertex(6),70);
        graph.bfs(new Vertex(1));
    }
}
