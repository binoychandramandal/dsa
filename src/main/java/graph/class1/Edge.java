package graph.class1;

public class Edge {
    int src;
    int nbr;
    int weight;

    public Edge() {
    }

    public Edge(int src, int nbr) {
        this.src = src;
        this.nbr = nbr;
    }

    public Edge(int src, int nbr, int weight) {
        this.src = src;
        this.nbr = nbr;
        this.weight = weight;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return nbr + "->" + weight;
    }
}
