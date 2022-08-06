package graph.implmentation;

import graph.model.BaseEdge;
import graph.model.BaseVertex;

import java.util.*;

public abstract class Graph<V extends BaseVertex, E extends BaseEdge> {
    protected final Map<V, Set<E>> store = new HashMap<>();

    public Set<E> getEdges(V vertex) {
        return store.get(vertex);
    }

    public void addVertex(V vertex) {
        this.store.put(vertex, new HashSet<>());
    }

    public abstract V getSourceVertex(E edge);

    public abstract V getNeighborVertex(E edge);

    protected abstract void unlink(V sourceVertex, V neighborVertex);

    public boolean removeVertex(V vertex) {
        Set<E> edges = getEdges(vertex);
        if (edges == null) {
            return false;
        }
        for (E edge : edges) {
            unlink(getNeighborVertex(edge), getSourceVertex(edge));
        }
        this.store.remove(vertex);
        return true;
    }

    public void bfs() {

    }

    public void bfs(V vertex) {
        Set<V> visited = new HashSet<>();
        Queue<V> q = new LinkedList<>();
        q.offer(vertex);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                V rem = q.poll();
                if(visited.contains(rem.vertex)){
                    continue;
                }
                if (!visited.contains(rem.vertex)) {
                    visited.add(rem);
                    System.out.print(rem.vertex+" -> ");
                    for (E edge : getEdges(rem)) {
                        V neighborVertex = getNeighborVertex(edge);
                        if (!visited.contains(neighborVertex.vertex)) {
                            q.offer(neighborVertex);
                        }
                    }
                }
            }
            System.out.println();

        }
    }

    public void dfs() {

    }

    public abstract void addEdge(V sourceVertex, V neighborVertex);
    public abstract void addEdge(V sourceVertex, V neighborVertex,int weight);

    public int vertexCount() {
        return store.size();
    }

    public Set<V> getAllVertices() {
        return store.keySet();
    }

    public boolean isEmpty() {
        return store.isEmpty();
    }
}
