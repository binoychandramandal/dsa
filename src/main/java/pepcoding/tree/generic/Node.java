package pepcoding.tree.generic;

import java.util.ArrayList;

public class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();

    public Node(int data) {
        this.data = data;
    }

    static class PreAndSuc{
        Node predecessor;
        Node successor;
        int state=0;

        @Override
        public String toString() {
            return "PreAndSuc{" +
                    "predecessor=" + predecessor.data +
                    ", successor=" + successor.data +
                    '}';
        }
    }

    static class FloorAndCeil{
        int floor=Integer.MIN_VALUE; //largest among smaller
        int ceil=Integer.MAX_VALUE;//smallest among larger

        @Override
        public String toString() {
            return "FloorAndCeil{" +
                    "floor=" + floor +
                    ", ceil=" + ceil +
                    '}';
        }
    }

   static class Stats{
        int size=0;
        int sum=0;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int height=0;

        @Override
        public String toString() {
            return "Stats{" +
                    "size=" + size +
                    ", sum=" + sum +
                    ", min=" + min +
                    ", max=" + max +
                    ", height=" + height +
                    '}';
        }
    }
}
