package stack;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> s =new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s);
        reverse(s);
        System.out.println(s);
        System.out.println(reverseString("abc"));
    }

   static public void reverse(Stack<Integer> s) {
        if(s.empty()){
            return;
        }
        int top=s.pop();
       reverse(s);
       s.push(top);

    }

    static String reverseString(String s){
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
           sb.append(stack.pop());
        }
        return sb.toString();
    }
}
