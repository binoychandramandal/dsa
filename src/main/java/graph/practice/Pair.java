package graph.practice;

public class Pair<T extends Comparable<T>, K extends Comparable<K>> implements Comparable<Pair<T, K>> {
    T first;
    K second;

    public Pair(T first, K second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public K getSecond() {
        return second;
    }

    public void setSecond(K second) {
        this.second = second;
    }

    @Override
    public int compareTo(Pair<T, K> o) {
        if (this.first.compareTo(o.first) == 0) {
            return this.second.compareTo(o.second);
        }
        return this.first.compareTo(o.first);
    }
}
