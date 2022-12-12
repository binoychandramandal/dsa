package practise.practice;

import java.util.HashMap;
import java.util.Map;

public class Test3 {
    public static void main(String[] args) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('a', 2);
        m.put('b', 2);
       // printP(1, 4, m, "");
        generateWord("aabb");
    }

    static void printP(int ci, int ts, Map<Character, Integer> f, String ans) {
        if (ci > ts) {
            System.out.println(ans);
            return;
        }
        for (Map.Entry<Character, Integer> e : f.entrySet()) {
            if (e.getValue() > 0) {
                f.put(e.getKey(), f.get(e.getKey()) - 1);
                printP(ci + 1, ts, f, ans + e.getKey());
                f.put(e.getKey(), f.get(e.getKey()) + 1);
            }
        }
    }

    static void generateWord(int cc, String str, Character[] spot, Map<Character, Integer> lastOccurance) {
        if (cc >= str.length()) {
            for (int i = 0; i < spot.length; i++) {
                System.out.print(spot[i]);
            }
            System.out.println();
            return;
        }
        char ch = str.charAt(cc);
        int lastOcc = lastOccurance.get(ch);
        for (int i = lastOcc + 1; i < spot.length; i++) {
            if (spot[i] == null) {
                spot[i] = ch;
                lastOccurance.put(ch, i);
                generateWord(cc + 1, str, spot, lastOccurance);
                lastOccurance.put(ch, -1);
                spot[i] = null;
            }
        }
    }

    static void generateWord(String str) {
        Character[] spot = new Character[str.length()];
        Map<Character, Integer> lastOccurance = new HashMap<>();
        for (char ch : str.toCharArray()) {
            lastOccurance.put(ch, -1);
        }
        generateWord(0, str, spot, lastOccurance);

    }
}
