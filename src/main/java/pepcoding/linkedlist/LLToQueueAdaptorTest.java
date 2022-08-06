package pepcoding.linkedlist;

public class LLToQueueAdaptorTest {

    public static void main(String[] args) {
        LLToQueueAdaptor q=new LLToQueueAdaptor();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        while (!q.isEmpty()){
            System.out.println(q.poll());
        }
    }
}
