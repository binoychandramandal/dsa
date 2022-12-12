package practise.practice;

import java.util.HashMap;
import java.util.Map;

public class TT2 {

    public static void main(String[] args) {
        //  permutation("aabb");
        String str = "aabb";
        Map<Character, Integer> lastOccurrence = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            lastOccurrence.put(str.charAt(i), -1);
        }

        printPer(0, str, new Character[str.length()], lastOccurrence);
    }


    static void permutation(String str) {

        Map<Character, Integer> fmap = new HashMap<>();
        for (char c : str.toCharArray()) {
            fmap.put(c, fmap.getOrDefault(c, 0) + 1);
        }
        permutation(1, str.length(), fmap, "");


    }

    private static void permutation(int ci, int ti, Map<Character, Integer> fmap, String ans) {

        if (ci > ti) {
            System.out.println(ans);
            return;
        }

        for (Map.Entry<Character, Integer> entry : fmap.entrySet()) {
            if (entry.getValue() > 0) {
                fmap.put(entry.getKey(), fmap.getOrDefault(entry.getKey(), 0) - 1);
                permutation(ci + 1, ti, fmap, ans + entry.getKey());
                fmap.put(entry.getKey(), fmap.getOrDefault(entry.getKey(), 0) + 1);
            }
        }


    }

    static void printPer(int ci, String str, Character[] spot, Map<Character, Integer> lastOccurrence) {
        if (ci >= str.length()) {
            for (int i = 0; i < spot.length; i++) {
                System.out.print(spot[i]);
            }
            System.out.println();
            return;
        }
        char ch = str.charAt(ci);
        int lastIndex = lastOccurrence.get(ch);
        for (int i = lastIndex + 1; i < spot.length; i++) {
            if (spot[i] == null) {
                spot[i] = ch;
                lastOccurrence.put(ch, i);
                printPer(ci + 1, str, spot, lastOccurrence);
                lastOccurrence.put(ch, -1);
                spot[i] = null;
            }
        }
    }


}
