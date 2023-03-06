package recurrsion.practice1;

import java.util.HashMap;
import java.util.Map;

public class PaindromePartition {
    public static void main(String[] args) {
        printPermutation("aba","");
    }

    static boolean isPalindrome(String s){
        if(s==null || s.isEmpty()){
            return false;
        }
        if(s.length()==1){
            return true;
        }
        int l=0,r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r))
                return false;
            l++;
            r--;
        }
          return true;
    }

    static void printPermutation(String s,String asf) {
       if(s==null || s.isEmpty()){
           System.out.println(asf);
           return;
       }
        for (int i = 0; i < s.length(); i++) {
            String left =s.substring(0,i+1);
            String right =s.substring(i+1);
            if(isPalindrome(left)){
                printPermutation(right,asf+"->" +left);
            }
        }
    }
}
