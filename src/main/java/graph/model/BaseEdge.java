package graph.model;

import java.util.Objects;

public abstract class BaseEdge{
    public int source;
    public int neighbor;

    public BaseEdge() {
    }

    public BaseEdge(int source, int neighbor) {
        this.source = source;
        this.neighbor = neighbor;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getNeighbor() {
        return neighbor;
    }

    public void setNeighbor(int neighbor) {
        this.neighbor = neighbor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEdge edge = (BaseEdge) o;
        return source == edge.source && neighbor == edge.neighbor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, neighbor);
    }
}
