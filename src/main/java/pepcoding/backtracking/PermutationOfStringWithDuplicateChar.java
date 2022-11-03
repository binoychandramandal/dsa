package pepcoding.backtracking;

import java.util.HashMap;
import java.util.Map;

public class PermutationOfStringWithDuplicateChar {
    public static void main(String[] args) {
        String str = "aabb";
        Map<Character,Integer> fmap =new HashMap<>();
        fmap.put('a',2);
        fmap.put('b',2);
        printPermutation(1,str.length(),fmap,"");
    }

    static void printPermutation(int cs, int ts, Map<Character,Integer> fmap,String asf){
        if(cs>ts){
            System.out.println(asf);
            return;
        }

        for(char c: fmap.keySet()){
            if(fmap.get(c)>0){
                fmap.put(c,fmap.get(c)-1);
                printPermutation(cs+1,ts,fmap,asf+c);
                fmap.put(c,fmap.get(c)+1);
            }
        }
    }
}
