package pepcoding.backtracking.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class WordPatternMatching {
    public static void main(String[] args) {
        printMapping("mzaddytzaddy","abcb",new HashMap<>(),"abcb");
        printMapping("graphtreesgraph","pep",new HashMap<>(),"pep");

    }

    static void printMapping(String str, String pattern, Map<Character, String> map, String originalPattern) {
        if(pattern.isEmpty()){
            if(str.isEmpty()){
                HashSet<Character> alreadyPrinted =new HashSet<>();
                for(Character c:originalPattern.toCharArray()){
                    if(!alreadyPrinted.contains(c)){
                        System.out.print(c+"-> "+map.get(c)+", ");
                        alreadyPrinted.add(c);
                    }
                }
                System.out.println();
            }
            return;
        }
        char ch = pattern.charAt(0);
        String rop = pattern.substring(1);
        if (map.containsKey(ch)) {
           String previousMapping =map.get(ch);
           if(str.length()>=previousMapping.length()) {
               String left = str.substring(0, previousMapping.length());
               String right = str.substring(previousMapping.length());
               if (previousMapping.equals(left)) {
                   printMapping(right, rop, map, originalPattern);
               }
           }
        } else {
            for (int i = 0; i < str.length(); i++) {
                String left = str.substring(0, i+1);
                String right = str.substring(i+1);
                map.put(ch,left);
                printMapping(right, rop, map, originalPattern);
                map.remove(ch);
            }
        }
    }
}
