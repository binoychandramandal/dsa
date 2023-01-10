package recurrsion.practice;

import java.util.ArrayList;
import java.util.List;

public class KeyPadCombination {

    static String[] codes = {".;", "abc", "def", "ghi"};

    public static void main(String[] args) {
        System.out.println(generateWords("12"));
        printWords("12","");
    }

    static List<String> generateWords(String s) {

        if (s == null || s.isEmpty()) {
            List<String> w = new ArrayList<>();
            w.add("");
            return w;
        }
        char c = s.charAt(0);
        String rop = s.substring(1);
        List<String> r = generateWords(rop);
        List<String > result =new ArrayList<>();
        String word =codes[c-'0'];
        for(String w:r){
         for(char e: word.toCharArray())
            result.add(e+w);
        }
       return result;
    }

    static void printWords(String s,String ans) {
        if (s == null || s.isEmpty()) {
            System.out.print(ans+" ");
            return ;
        }
        char c = s.charAt(0);
        String rop = s.substring(1);
        String word =codes[c-'0'];
        for(char w:word.toCharArray()){
                printWords(rop,ans+w);
        }
    }


}
