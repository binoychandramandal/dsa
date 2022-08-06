package graph.model;

import java.util.Objects;

public abstract class BaseVertex {
    public int vertex;

    public BaseVertex(int vertex) {
        this.vertex = vertex;
    }
    public BaseVertex() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseVertex that = (BaseVertex) o;
        return vertex == that.vertex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertex);
    }
}
