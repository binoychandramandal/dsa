package stack.practice;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(7);
        s.push(6);
        s.push(8);
        s.push(2);
        s.push(1);
        s.push(10);

        System.out.println(s);
        sort(s);
        System.out.println(s);
    }

    public static void sort(Stack<Integer> st) {
        if (st == null || st.isEmpty()) {
            return;
        }
        int t1 = st.pop();
        sort(st);
        insert(st, t1);
    }

    private static void insert(Stack<Integer> st, int t1) {
        if (st.isEmpty() || st.peek() > t1) {
            st.push(t1);
            return;
        }
        int t = st.pop();
        insert(st, t1);
        st.push(t);
    }
}
