package pepcoding.linkedlist;

public class LLToStackAdaptor {

    private final LinkedList list = new LinkedList();

    public int size() {
        return list.size();
    }

    public void push(int data) {
        list.addFirst(data);
    }

    public int peek() {
        if(list.size()==0){
            System.out.println("Underflow");
            return  -1;
        }
        return list.getFirst();
    }

    public int pop() {
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
