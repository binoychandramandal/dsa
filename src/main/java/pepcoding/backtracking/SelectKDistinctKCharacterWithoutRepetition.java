package pepcoding.backtracking;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SelectKDistinctKCharacterWithoutRepetition {

    public static void main(String[] args) {
        printUniqueChar("abcabc");
        System.out.println("----------------------");
        printUniqueChar1("abcabc");
    }


    static void printUniqueChar(String str){
        String uniqueStr = "";
        Set<Character> u = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if(!u.contains(str.charAt(i))){
                u.add(str.charAt(i));
                uniqueStr+=str.charAt(i);
            }
        }
        generateWord( 0,uniqueStr, 0, 2, "");
    }


    static void printUniqueChar1(String str){
        String uniqueStr = "";
        Set<Character> u = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if(!u.contains(str.charAt(i))){
                u.add(str.charAt(i));
                uniqueStr+=str.charAt(i);
            }
        }
        generateWord1( uniqueStr, 1, 2,-1, "");
    }

    static void  generateWord( int i,String uniqueStr, int ssf, int ts, String ans){
        if(i>=uniqueStr.length()){
            if(ssf==ts){
                System.out.println(ans);
            }
            return;
        }
        generateWord(i+1,uniqueStr,ssf+0,ts,ans+"-");
        generateWord(i+1,uniqueStr,ssf+1,ts,ans+uniqueStr.charAt(i));
    }

    static void  generateWord1(String uniqueStr, int cs, int ts,int lc, String ans){
        if(cs>ts){
                System.out.println(ans);
            return;
        }
        for (int i = lc+1; i <uniqueStr.length() ; i++) {
            generateWord1(uniqueStr,cs+1,ts,i, ans+uniqueStr.charAt(i));
        }

    }

}
