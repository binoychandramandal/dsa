package recurrsion.practise;

import java.util.HashMap;

public class CryptoAirthmetic {
    public static void main(String[] args) {
        solve("send","more","money");
    }

    static void solve(String s1, String s2, String s3) {
        HashMap<Character, Integer> charInMap = new HashMap<>();
        String unique = "";
        for (int i = 0; i < s1.length(); i++) {
            if (!charInMap.containsKey(s1.charAt(i))) {
                charInMap.put(s1.charAt(i), -1);
                unique += s1.charAt(i);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (!charInMap.containsKey(s2.charAt(i))) {
                charInMap.put(s2.charAt(i), -1);
                unique += s2.charAt(i);
            }
        }
        for (int i = 0; i < s3.length(); i++) {
            if (!charInMap.containsKey(s3.charAt(i))) {
                charInMap.put(s3.charAt(i), -1);
                unique += s3.charAt(i);
            }
        }
        boolean[] usedNumbers = new boolean[10];
        solution(unique, 0, charInMap, usedNumbers, s1, s2, s3);
    }

    static void solution(String unique, int idx, HashMap<Character, Integer> charInMap, boolean[] usedNumbers, String s1, String s2, String s3) {
        if (idx == unique.length()) {
            int num1 = getNum(s1, charInMap);
            int num2 = getNum(s2, charInMap);
            int num3 = getNum(s3, charInMap);
            if (num1 + num2 == num3) {
                for (int i = 0; i < 26; i++) {
                    char ch = (char) ('a' + i);
                    if (charInMap.containsKey(ch)) {
                        System.out.print(ch + "-" + charInMap.get(ch) + " ");
                    }
                }
                System.out.println();
            }
            return;
        }
        char ch = unique.charAt(idx);
        for (int num = 0; num <= 9; num++) {
            if (usedNumbers[num] == false) {
                charInMap.put(ch, num);
                usedNumbers[num] = true;
                solution(unique, idx + 1, charInMap, usedNumbers, s1, s2, s3);
                usedNumbers[num] = false;
                charInMap.put(ch, -1);
            }
        }
    }

    private static int getNum(String s, HashMap<Character, Integer> charInMap) {
        String num = "";
        for (int i = 0; i < s.length(); i++) {
            num += charInMap.get(s.charAt(i));
        }
        return Integer.valueOf(num);
    }
}
