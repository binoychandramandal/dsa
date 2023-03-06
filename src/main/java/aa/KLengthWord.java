package aa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KLengthWord {
    public static void main(String[] args) {
        //printKLengthWord(0, "abc", 0, new Character[2], 2);
        printKLengthWord(1, 2,new HashSet<>(),"abc", "");
    }

    static void printKLengthWord(int index, String s, int ssf, Character[] items, int ts) {
        if (index == s.length()) {
            if (ssf == ts)
                System.out.println(Arrays.toString(items));
            return;
        }
        char it = s.charAt(index);
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = it;
                printKLengthWord(index + 1, s, ssf + 1, items, ts);
                items[i] = null;
            }
        }
        printKLengthWord(index + 1, s, ssf + 0, items, ts);
    }

    static void printKLengthWord(int index, int totalIndex, Set<Character> used, String s, String asf) {
        if (index > totalIndex) {
            System.out.println(asf);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(!used.contains(c)) {
                used.add(c);
                printKLengthWord(index + 1, totalIndex, used, s, asf + s.charAt(i));
               used.remove(c);
            }
        }
    }


}
