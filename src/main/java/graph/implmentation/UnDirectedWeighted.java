package graph.implmentation;

import graph.model.Edge;
import graph.model.Vertex;
import graph.model.WeightedEdge;

import java.util.*;

public class UnDirectedWeighted extends Graph<Vertex, WeightedEdge> {

    @Override
    public Vertex getSourceVertex(WeightedEdge edge) {
        return new Vertex(edge.source);
    }

    @Override
    public Vertex getNeighborVertex(WeightedEdge edge) {
        return new Vertex(edge.neighbor);
    }

    @Override
    protected void unlink(Vertex sourceVertex, Vertex neighborVertex) {
        getEdges(sourceVertex).remove(new Edge(sourceVertex.vertex, neighborVertex.vertex));
    }

    @Override
    public void addEdge(Vertex sourceVertex, Vertex neighborVertex) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public void addEdge(Vertex sourceVertex, Vertex neighborVertex, int weight) {
        Set<WeightedEdge> sourceEdges = getEdges(sourceVertex);
        if (Objects.isNull(sourceEdges) || sourceEdges.size() < 1) {
            addVertex(sourceVertex);
        }
        Set<WeightedEdge> neighborEdges = getEdges(neighborVertex);
        if (Objects.isNull(neighborEdges) || neighborEdges.size() < 1) {
            addVertex(neighborVertex);
        }
        getEdges(sourceVertex).add(new WeightedEdge(sourceVertex.vertex, neighborVertex.vertex, weight));
        getEdges(sourceVertex).add(new WeightedEdge(sourceVertex.vertex, neighborVertex.vertex, weight));
    }

    @Override
    public void bfs(Vertex vertex) {
        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> q = new LinkedList<>();
        q.offer(vertex);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> l=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Vertex rem = q.poll();
                if(visited.contains(rem.vertex)){
                    continue;
                }
                if (!visited.contains(rem.vertex)) {
                    visited.add(rem);
                   l.add(rem.vertex);
                    for (WeightedEdge edge : getEdges(rem)) {
                        Vertex neighborVertex = getNeighborVertex(edge);
                        if (!visited.contains(neighborVertex.vertex)) {
                            q.offer(neighborVertex);
                        }
                    }
                }
                System.out.println(l);
            }


        }
    }
}
