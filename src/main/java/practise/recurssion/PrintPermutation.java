package practise.recurssion;

import java.util.ArrayList;
import java.util.List;

public class PrintPermutation {
    public static void main(String[] args) {
        printPermutation("abc","");
        System.out.println();
        System.out.println(printPermutation("abc",0));
    }

    static void printPermutation(String str, String asf) {
        if (str.isEmpty()) {
            System.out.print(asf + " ");
            return;
        }
        for (int i=0;i<str.length();i++){
            char c = str.charAt(i);
            String lp = str.substring(0,i);
            String rp =str.substring(i+1);
            String ros = lp+rp;
            printPermutation(ros,asf+c);
        }
    }

    static List<String> printPermutation(String str,int index) {
        if (index==str.length()) {
            List<String> l=new ArrayList<>();
            l.add("");
            return l;
        }
        char c = str.charAt(0);
           List<String> in= printPermutation(str,index+1);
           List<String> result =new ArrayList<>();
           for(String s: in){
               result.add(c+s);
           }

        for(String s: in){
            result.add(s+c);
        }
           return result;
    }
}
