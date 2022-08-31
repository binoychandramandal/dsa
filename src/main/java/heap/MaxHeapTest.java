package heap;

public class MaxHeapTest {

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);
        heap.add(10);
        heap.add(20);
        heap.add(30);
        heap.add(40);
        //System.out.println(heap.peek());
        System.out.println(heap.poll());
        System.out.println(heap.peek());
        System.out.println(heap.poll());
        System.out.println(heap.peek());
        System.out.println(heap.poll());
        System.out.println(heap.peek());
        System.out.println(heap.poll());
        System.out.println(heap.peek());
    }
}
