package practise.recurssion;

import java.util.ArrayList;
import java.util.List;

public class KeyPad {
    public static void main(String[] args) {

        String[] keys = {".;", "abc", "def", "ghi", "jki", "mno", "pqrs", "tu", "vwx", "yz"};
        System.out.println(getAllWord("123", keys));
        printAllWord("123",keys,"");
    }

    static List<String> getAllWord(String str, String[] keys) {
        if (str.isEmpty()) {
            List<String> l = new ArrayList<>();
            l.add("");
            return l;
        }
        char c = str.charAt(0);
        List<String> in = getAllWord(str.substring(1), keys);
        String code = keys[c - '0'];
        List<String> result = new ArrayList<>();
        for (char k : code.toCharArray()) {
            for (String p : in) {
                result.add(k + p);
            }
        }
        return result;
    }


    static void printAllWord(String str,String[] keys,String ans){
        if(str.isEmpty()){
            System.out.print(ans+" ");
            return;
        }
        char c = str.charAt(0);
        String rs = str.substring(1);
        String code =  keys[c-'0'];
        for (char k: code.toCharArray()){
            printAllWord(rs,keys,ans+k);
        }
    }

}
