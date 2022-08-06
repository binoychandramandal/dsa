package recurrsion.practise;

import java.util.HashMap;

public class PalindromicPermutation {
    public static void main(String[] args) {
        generatepw("aaabb");
    }


    static void generatepw(String str) {
        //frequency map creation
        HashMap<Character, Integer> fmap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (fmap.containsKey(ch)) {
                int of = fmap.get(ch);
                fmap.put(ch, of + 1);
            } else {
                fmap.put(ch, 1);
            }
        }
        //
        Character odd = null;
        int odds = 0;
        int len = 0;
        for (char ch : fmap.keySet()) {
            int freq = fmap.get(ch);
            if (freq % 2 == 1) {
                odd = ch;
                odds++;
            }
            fmap.put(ch, freq / 2);
            len += freq / 2;
        }
        if (odds > 1) {
            System.out.println("-1");
            return;
        }
        solution(1, len, fmap, odd, "");
    }

    /**
     * @param cs   current spot
     * @param ts   target spot it will be till n
     * @param fmap frequency map
     * @param oddc odd count
     * @param asf  answer so far
     */
    static void solution(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {
        if (cs > ts) {
            String rev = "";
            for (int i = asf.length() - 1; i >= 0; i--) {
                rev += asf.charAt(i);
            }
            String res = asf;
            if (oddc != null) {
                res += oddc;
            }
            res += rev;
            System.out.println(res);
            return;
        }
        for (char ch : fmap.keySet()) {
            int freq = fmap.get(ch);
            if (freq > 0) {
                fmap.put(ch, freq - 1);
                solution(cs + 1, ts, fmap, oddc, asf + ch);
                fmap.put(ch, freq);
            }
        }
    }
}
