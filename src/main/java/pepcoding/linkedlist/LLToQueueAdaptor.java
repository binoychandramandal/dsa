package pepcoding.linkedlist;

public class LLToQueueAdaptor {

    private final LinkedList list = new LinkedList();

    public int size() {
        return list.size();
    }

    public void offer(int data) {
        list.addLast(data);
    }

    public int peek() {
        if(list.size()==0){
            System.out.println("Underflow");
            return  -1;
        }
        return list.getFirst();
    }

    public int poll() {
        if(list.size()==0){
            System.out.println("Underflow");
            return  -1;
        }
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
