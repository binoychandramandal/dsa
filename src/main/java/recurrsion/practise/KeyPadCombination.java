package recurrsion.practise;

import java.util.ArrayList;
import java.util.List;

public class KeyPadCombination {
    static String code[] = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static void main(String[] args) {

        List<String> allCombination = getKeyPad("12");
        System.out.println(allCombination);
        printKeyPad("12","");
    }

    static List<String> getKeyPad(String s) {
        if (s.length() == 1) {
            List<String> l = new ArrayList<>();
            int index = s.charAt(0) - '0';
            String t = code[index];
            for (int i = 0; i < t.length(); i++) {
                l.add(t.charAt(i) + "");
            }
            return l;
        }
        char c = s.charAt(0);
        List<String> r = getKeyPad(s.substring(1));
        String c1 = code[c - '0'];
        List<String> res = new ArrayList<>();
        for (int i = 0; i < c1.length(); i++) {
            for (String iner : r) {
                res.add(c1.charAt(i) + iner);
            }
        }

        return res;

    }

    static void printKeyPad(String ques, String ans) {

        if (ques.length() == 0) {
            System.out.print(ans + " ");
            return;
        }
        char ch = ques.charAt(0);
        String ros = ques.substring(1);
        String codeforch = code[ch - '0'];
        for (int i = 0; i < codeforch.length(); i++) {
            char cho = codeforch.charAt(i);
            printKeyPad(ros, ans + cho);
        }
    }


}
