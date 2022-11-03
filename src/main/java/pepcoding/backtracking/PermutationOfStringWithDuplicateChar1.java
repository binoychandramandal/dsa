package pepcoding.backtracking;

import java.util.HashMap;
import java.util.Map;

public class PermutationOfStringWithDuplicateChar1 {
    public static void main(String[] args) {
        String str = "aabb";
        Map<Character, Integer> fmap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            fmap.put(str.charAt(i),-1);
        }
        generateWord(0, str,new Character[str.length()], fmap);
    }

    static void generateWord(int cc, String str, Character[] spots, Map<Character, Integer> lasOccurance) {
        if (cc == str.length()) {
            for (int i = 0; i < spots.length; i++) {
                System.out.print(spots[i]);
            }
            System.out.println();
            return;
        }
        char ch = str.charAt(cc);
        int lo = lasOccurance.get(ch);
        for (int i = lo + 1; i < spots.length; i++) {
            if (spots[i] == null) {
                spots[i] = ch;
                lasOccurance.put(ch, i);
                generateWord(cc + 1, str, spots, lasOccurance);
                lasOccurance.put(ch, -1);
                spots[i] = null;
            }
        }
    }
}
