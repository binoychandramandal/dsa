package graph.model;

import java.util.Objects;

public class WeightedEdge extends BaseEdge implements Comparable<WeightedEdge> {
    private int weight;

    public WeightedEdge() {
    }

    public WeightedEdge(int source, int neighbor, int weight) {
        super(source, neighbor);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(WeightedEdge o) {
        return this.weight - o.weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeightedEdge edge = (WeightedEdge) o;
        return source == edge.source && neighbor == edge.neighbor && this.weight == edge.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, neighbor);
    }
}
