package recurrsion.practise1;

import java.util.Stack;

public class MiddleOfStackDeletion {
    public static void main(String[] args) {
        Stack<Integer> s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s);
        //deleteKthElement(s,3);
        reverse(s);
        System.out.println("Size-> "+s);
    }

    static void reverse(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int temp = s.pop();
        reverse(s);
        insert(s,temp);
    }

    static void insert(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int temp = s.pop();
        insert(s,data);
        s.push(temp);
    }

    static void deleteKthElement(Stack<Integer> s,int k){
        if(s.isEmpty() ){
            return;
        }
        if(k==1){
            s.pop();
        }
        int temp=s.pop();
        deleteKthElement(s,k-1);
        s.push(temp);
    }
}
