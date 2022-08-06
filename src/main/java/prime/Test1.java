package prime;

import java.util.Stack;

public class Test1 {
    public static void main(String[] args) {
        System.out.println( toBinary(100));
    }

    static String  toBinary(int n){
       String res="";
        while(n>0){
            res=(n%2)+res;
            n=n/2;
        }
        return res;
    }
}
