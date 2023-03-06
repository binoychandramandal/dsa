package recurrsion.practice1;

import java.util.HashMap;
import java.util.Map;

public class CryptoArithmetic {
    public static void main(String[] args) {
       // print("send", "more", "money");
        print("abc", "cde", "dfh");
    }

    static String updateMap(String s1, Map<Character, Integer> uniqueChar) {
        String un = "";
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (!uniqueChar.containsKey(c)) {
                un += c;
            }
            uniqueChar.put(s1.charAt(i), -1);
        }
        return un;
    }

    static Integer getNum(String s, Map<Character, Integer> map) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += map.get(s.charAt(i));
        }
        return sum;
    }

    static void print(String s1, String s2, String s3) {
        Map<Character, Integer> uniqueChar = new HashMap<>();
        String un = updateMap(s1 + s2 + s3, uniqueChar);
        solution(un, 0, new boolean[10], uniqueChar, s1, s2, s3);
    }

    static void solution(String s, int index, boolean[] v, Map<Character, Integer> um, String s1, String s2, String s3) {
        if (index == s.length()) {
            if (getNum(s1, um) + getNum(s2, um) == getNum(s3, um)) {
                for (int i = 0; i < 26; i++) {
                    char c = (char) ('a' + i);
                    if (um.containsKey(c)) {
                        System.out.print(c + " -> " + um.get(c) + ", ");
                    }
                }
                System.out.println();
            }
            return;
        }

        char c = s.charAt(index);
        for (int i = 0; i < 10; i++) {
            if (v[i] == false) {
                v[i] = true;
                um.put(c, i);
                solution(s, index + 1, v, um, s1, s2, s3);
                um.put(c, -1);
                v[i] = false;
            }
        }
    }
}
