package graph.implmentation;

import graph.model.Edge;
import graph.model.Vertex;

import java.util.Objects;
import java.util.Set;

public class UnDirected extends Graph<Vertex, Edge> {

    @Override
    public Vertex getSourceVertex(Edge edge) {
        return new Vertex(edge.source);
    }

    @Override
    public Vertex getNeighborVertex(Edge edge) {
        return new Vertex(edge.neighbor);
    }

    @Override
    public void unlink(Vertex sourceVertex, Vertex neighborVertex) {
        getEdges(sourceVertex).remove(new Edge(sourceVertex.vertex, neighborVertex.vertex));
    }

    @Override
    public void addEdge(Vertex sourceVertex, Vertex neighborVertex) {
        Set<Edge> sourceEdges = getEdges(sourceVertex);
        if (Objects.isNull(sourceEdges) || sourceEdges.size() < 1) {
            addVertex(sourceVertex);
        }
        Set<Edge> neighborEdges = getEdges(neighborVertex);
        if (Objects.isNull(neighborEdges) || neighborEdges.size() < 1) {
            addVertex(neighborVertex);
        }
        getEdges(sourceVertex).add(new Edge(sourceVertex.vertex, neighborVertex.vertex));
        getEdges(sourceVertex).add(new Edge(sourceVertex.vertex, neighborVertex.vertex));
    }

    @Override
    public void addEdge(Vertex sourceVertex, Vertex neighborVertex, int weight) {

    }

}
