package tree.practice.generictree;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int data;
    private List<Node> child = new ArrayList<>(0);

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public List<Node> getChild() {
        return child;
    }

    public void setChild(List<Node> childs) {
        this.child = childs;
    }
}
