package pepcoding.backtracking.practice;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveInvalidParenthesis {

    public static void main(String[] args) {
        String str ="()())()";
        int mra =getMinParenthesisRemoveCount(str);
        solution(str,mra,new HashSet<>());
    }

    static void solution(String str, int mra, Set<String> ans){
        if(mra==0){
            int nowMinRemoAllowed =getMinParenthesisRemoveCount(str);
            if(nowMinRemoAllowed==0){
                if(!ans.contains(str)){
                    ans.add(str);
                    System.out.println(str);
                }
            }
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String left =str.substring(0,i);
            String right =str.substring(i+1);
            solution(left+right,mra-1,ans);
        }
    }

    static int getMinParenthesisRemoveCount(String str){
        Stack<Character> stack =new Stack<>();
        for (int i = 0; i < str.length(); i++) {
             char c =str.charAt(i);
             if(c=='('){
                 stack.push(c);
             }else if(c==')'){
                 if(stack.isEmpty() || stack.peek()==')'){
                     stack.push(c);
                 }else if(stack.peek()=='('){
                     stack.pop();
                 }
             }
        }
        return stack.size();
    }

    static boolean isValidExpression(String str){
        return getMinParenthesisRemoveCount(str)==0;
    }

}
