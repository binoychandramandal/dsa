package graph.pepcoding;

import java.util.HashSet;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(isCommon("hello","io"));
    }
    static boolean isCommon(String s1,String s2){
        HashSet<Character> s=new HashSet<>();
        for (char c:s1.toCharArray()) {
            s.add(c);
        }
        for(char c:s2.toCharArray()){
           if(s.contains(c)){
               return true;
           }
        }
        return false;
    }
}
