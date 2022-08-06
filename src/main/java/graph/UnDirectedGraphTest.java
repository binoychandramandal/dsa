package graph;

import graph.implmentation.Graph;
import graph.implmentation.UnDirected;
import graph.model.Vertex;

public class UnDirectedGraphTest {
    public static void main(String[] args) {
        UnDirected graph=new UnDirected();
        graph.addVertex(new Vertex(1));
        graph.addVertex(new Vertex(2));
        graph.addVertex(new Vertex(3));
        graph.addVertex(new Vertex(4));

        graph.addEdge(new Vertex(1),new Vertex(2));
        graph.addEdge(new Vertex(1),new Vertex(3));
        graph.addEdge(new Vertex(3),new Vertex(4));
        graph.addEdge(new Vertex(3),new Vertex(5));
        graph.addEdge(new Vertex(2),new Vertex(4));
        graph.addEdge(new Vertex(4),new Vertex(5));
        graph.addEdge(new Vertex(4),new Vertex(6));
        graph.bfs(new Vertex(1));
    }
}
