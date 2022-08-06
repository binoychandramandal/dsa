package graph.tuf;

public class Edge {
    public int src;
    public int v;
    public int w;

    public Edge(int v) {
        this.v = v;
    }

    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }

    public Edge(int src, int v, int w) {
        this.src = src;
        this.v = v;
        this.w = w;
    }

    @Override
    public String toString() {
        return "[" + v + " : " + w + "]";
    }
}

