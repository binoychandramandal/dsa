package graph.model;

import java.util.Objects;

public class Edge extends BaseEdge implements Comparable<Edge> {

    public Edge() {
    }

    public Edge(int source, int neighbor) {
        super(source, neighbor);
    }

    @Override
    public int compareTo(Edge o) {
        return this.source - o.source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return source == edge.source && neighbor == edge.neighbor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, neighbor);
    }
}
