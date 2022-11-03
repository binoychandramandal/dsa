package pepcoding.backtracking.practice;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {
    public static void main(String[] args) {
        Map<Character,Integer> fm =new HashMap<>();
        fm.put('a',2);
        fm.put('b',2);

        printPermutation(fm,1,4,"");

    }

    static void printPermutation(Map<Character,Integer> fm,int cb,int tb,String ans){
        if(cb>tb){
            System.out.println(ans);
            return;
        }
        for (Map.Entry<Character,Integer> entry : fm.entrySet()) {
            if(fm.get(entry.getKey())>0){
                fm.put(entry.getKey(),fm.get(entry.getKey())-1);
                printPermutation(fm,cb+1,tb,ans+entry.getKey());
                fm.put(entry.getKey(),fm.get(entry.getKey())+1);
            }
        }

    }
}
