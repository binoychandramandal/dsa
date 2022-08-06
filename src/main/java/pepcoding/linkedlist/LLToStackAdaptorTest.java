package pepcoding.linkedlist;

public class LLToStackAdaptorTest {
    public static void main(String[] args) {
        LLToStackAdaptor stack =new LLToStackAdaptor();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
