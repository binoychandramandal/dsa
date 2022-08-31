package heap;

public class MinHeap {

    private int[] store;
    private int size;

    public MinHeap(int initialCapacity) {
        this.store = new int[initialCapacity];
    }

    public int peek() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return store[0];
    }

    public void add(int data) {
        if (isFull()) {
            System.out.println("Storage is full");
            return;
        }
        store[size] = data;
        int i = size;
        while (i >= 1) {
            if (store[getParent(i)] > store[i]) {
                int parentValue = store[getParent(i)];
                store[getParent(i)] = store[i];
                store[i] = parentValue;
                i = getParent(i);
            }else {
                break;
            }

        }
        size++;
    }

    public void heapify(int index) {
        int left = getLeft(index);
        int right = getRight(index);
        int largest = index;
        if (left < size && store[largest] > store[left]) {
            largest = left;
        }
        if (right < size && store[largest] > store[right]) {
            largest = right;
        }
        if (largest != index) {
            int parentValue = store[largest];
            store[largest] = store[index];
            store[index] = parentValue;
            heapify(largest);
        }
    }

    public int poll() {
        if (isEmpty()) {
            System.out.println("Storage is full");
            return Integer.MIN_VALUE;
        }
        int res = store[0];
        store[0] = store[size - 1];
        size--;
        heapify(0);
        return res;
    }

    private boolean hasLeft(int index) {
        return index < 0 || getLeft(index) >= size ? false : true;
    }

    private boolean hasRight(int index) {
        return index < 0 || getRight(index) >= size ? false : true;
    }

    private boolean isFull() {
        return size == store.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getCapacity() {
        return store.length;
    }

    private int getParent(int index) {
        return (index-1) / 2;
    }

    private int getLeft(int index) {
        return index * 2 + 1;
    }

    private int getRight(int index) {
        return index * 2 + 2;
    }
}
