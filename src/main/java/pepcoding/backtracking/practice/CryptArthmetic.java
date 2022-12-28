package pepcoding.backtracking.practice;

import java.util.HashMap;
import java.util.Map;

public class CryptArthmetic {
    public static void main(String[] args) {

        String s1 = "send";
        String s2 = "more";
        String s3 = "money";
        printMapping(s1, s2, s3);

    }

    private static void printMapping(String s1, String s2, String s3) {
        Map<Character, Integer> map = new HashMap<>();
        String uniqueString = uniqueCHar(map, s1);
        uniqueString += uniqueCHar(map, s2);
        uniqueString += uniqueCHar(map, s3);
        System.out.println(uniqueString);
        printDifferentMapping(uniqueString,0,map,new boolean[10],s1,s2,s3);
    }

    static String getNum(String s,Map<Character, Integer> map){
        String result ="";
        for (int i = 0; i < s.length(); i++) {
            result+=map.get(s.charAt(i));
        }
        return result;
    }

    static void printDifferentMapping(String input,int index,Map<Character, Integer> map,boolean[] usedNumber,String s1, String s2, String s3){
        if(index==input.length()){
            String num1 =getNum(s1,map);
            String num2 =getNum(s2,map);
            String num3 =getNum(s3,map);
            if(Integer.parseInt(num1)+Integer.parseInt(num2)==Integer.parseInt(num3)){
                for (int i = 0; i < 26; i++) {
                 char ch =(char)('a'+i);
                 if(map.containsKey(ch))
                    System.out.print(ch+"-> "+map.get(ch)+" ");
                }
                System.out.println();
            }

            return;
        }

        char c =input.charAt(index);
        for (int i = 0; i <= 9; i++) {
            if(!usedNumber[i]){
                map.put(c,i);
                usedNumber[i]=true;
                printDifferentMapping(input,index+1,map,usedNumber,s1,s2,s3);
                usedNumber[i]=false;
                map.put(c,-1);
            }
        }

    }


    static String uniqueCHar(Map<Character, Integer> map, String input) {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            if (!map.containsKey(input.charAt(i))) {
                map.put(input.charAt(i), -1);
                result += input.charAt(i);
            }
        }
        return result;
    }
}
