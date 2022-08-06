package pepcoding.tree.binary;

public class Pair<K, V> {
    private K left;
    private V right;

    private Pair(K left, V right) {
        this.left = left;
        this.right = right;
    }

    private Pair() {
    }

    public K getLeft() {
        return left;
    }

    public void setLeft(K left) {
        this.left = left;
    }

    public V getRight() {
        return right;
    }

    public void setRight(V right) {
        this.right = right;
    }

    public static <K, V> Pair<K, V> of(K key, V value) {
        return new Pair<>(key, value);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
