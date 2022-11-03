package pepcoding.backtracking;

import java.util.HashSet;
import java.util.Set;

public class KLengthWordOfDistinctCharacter {
    public static void main(String[] args) {
        generateKLengthWordOfDistinctChar("abcabc", 3);
        System.out.println("--------------------------");
        generateKLengthWordOfDistinctChar1("abcabc",3);
    }

    //spot or item in option and character in level
    static void generateKLengthWordOfDistinctChar(String str, int itemCharCount) {
        String uniqueStr = "";
        Set<Character> s = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (!s.contains(str.charAt(i))) {
                uniqueStr += str.charAt(i);
                s.add(str.charAt(i));
            }
        }
        gWord(0, uniqueStr, 0, itemCharCount, new Character[itemCharCount]);
    }

    static void gWord(int cc, String str, int ssf, int ts, Character[] spots) {
        if (cc == str.length()) {
            if (ssf == ts) {
                for (int i = 0; i < spots.length; i++) {
                    System.out.print(spots[i]);
                }
                System.out.println();
            }
            return;
        }
        char ch = str.charAt(cc);
        for (int i = 0; i < spots.length; i++) {
            if (spots[i] == null) {
                spots[i] = ch;
                gWord(cc + 1, str, ssf + 1, ts, spots);
                spots[i] = null;
            }
        }
        gWord(cc + 1, str, ssf, ts, spots);
    }

    //spot or item in level and character in option
    static void generateKLengthWordOfDistinctChar1(String str, int itemCharCount) {
        String uniqueStr = "";
        Set<Character> s = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (!s.contains(str.charAt(i))) {
                uniqueStr += str.charAt(i);
                s.add(str.charAt(i));
            }
        }
        gWord1(1, itemCharCount, uniqueStr,new HashSet<>(),"");
    }

    static void gWord1(int cs, int ts, String str, Set<Character> used, String ans) {
        if (cs > ts) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!used.contains(ch)) {
                used.add(ch);
                gWord1(cs + 1, ts, str, used, ans + ch);
                used.remove(ch);
            }
        }
    }
}
