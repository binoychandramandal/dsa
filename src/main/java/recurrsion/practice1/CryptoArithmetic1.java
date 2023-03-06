package recurrsion.practice1;

import java.util.HashMap;
import java.util.Map;

public class CryptoArithmetic1 {
    public static void main(String[] args) {
         print("send", "more", "money");
       // print("abc", "cde", "dfh");
    }

    static String updateMapAndGEtString(String s, Map<Character, Integer> map) {
        String us = "";
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                us += c;
            }
            map.put(c, -1);
        }
        return us;
    }

    static void print(String s1, String s2, String s3) {
        Map<Character, Integer> map = new HashMap<>();
        String unString = updateMapAndGEtString(s1 + s2 + s3, map);
        solution(unString, 0, map, new boolean[10], s1, s2, s3);
    }

    static int getNum(String s, Map<Character, Integer> map) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += map.get(s.charAt(i));
        }
        return sum;
    }

    private static void solution(String unString, int i, Map<Character, Integer> map, boolean[] v, String s1, String s2, String s3) {
        if (unString.length() == i) {
            if (getNum(s1, map) + getNum(s2, map) == getNum(s3, map)) {
                for (int j = 0; j < 26; j++) {
                    char c = (char) ('a' + j);
                    if (map.containsKey(c)) {
                        System.out.print(c + " -> " + map.get(c) + ", ");
                    }
                }
                System.out.println();
            }
            return;
        }
        char c = unString.charAt(i);
        for (int j = 0; j < 10; j++) {
            if (v[j]==false) {
                v[j] = true;
                map.put(c, j);
                solution(unString, i + 1, map, v, s1, s2, s3);
                v[j] = false;
                map.put(c, -1);
            }
        }
    }


}
