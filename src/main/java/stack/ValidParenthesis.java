package stack;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(solve("{([])}"));
    }
    static public int solve(String A) {
        Stack<Character> s=new Stack<>();
        for(int i=0;i<A.length();i++){
            char c=A.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                s.push(c);
            }else if(c==')' || c=='}' || c==']'){
                if(s.isEmpty()){
                    return 0;
                }else if(closing(c,s.peek())){
                    s.pop();
                }
            }
        }
        return s.isEmpty()?1:0;
    }

  static  public boolean closing(char current,char inStack){
        if(inStack=='(' && current==')'){
            return true;
        }else if(inStack=='{' && current=='}'){
            return true;
        }else if(inStack=='[' && current==']'){
            return true;
        }else{
            return false;
        }
    }

}
