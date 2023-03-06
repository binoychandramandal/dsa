package aa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PermutationWithDuplicate {
    public static void main(String[] args) {
        permuteString("aabb");
    }

    static void permuteString(String str){
        Map<Character,Integer> items=new HashMap<>();
        String uStr="";
        for(Character c1: str.toCharArray()){
           if(! items.containsKey(c1)){
               uStr +=c1;
            }
           items.put(c1,items.getOrDefault(c1,0)+1);
        }
        printPer(0,str,items,"");

    }

    static void printPer(int i, String s, Map<Character,Integer> items,String asf){
        if(i==s.length()){
            System.out.println(asf);
            return;
        }
        for (Character c:items.keySet()) {
            if(items.get(c)>0){
                items.put(c,items.get(c)-1);
                printPer(i+1,s,items,asf+c);
                items.put(c,items.get(c)+1);
            }
        }
    }

}
