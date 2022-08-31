package heap;

import java.util.PriorityQueue;

public class MinHeapTest {
    public static void main(String[] args) {
        MinHeap minHeap =new MinHeap(10);
        minHeap.add(40);
        minHeap.add(30);
        minHeap.add(20);
        minHeap.add(10);
        System.out.println(minHeap.peek());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.peek());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.peek());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.peek());
        System.out.println(minHeap.poll());
    }
}
