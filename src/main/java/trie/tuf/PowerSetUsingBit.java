package trie.tuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSetUsingBit {

    public static void main(String[] args) {
        System.out.println(new PowerSetUsingBit().powerSet("abc"));
        System.out.println(new PowerSetUsingBit().powerSetUsingRecursion("abc"));
    }

    List<String> powerSet(String s) {
        int n = s.length();
        List<String> res = new ArrayList<>();
        for (int num = 0; num < (1 << n); num++) {
            String a = "";
            for (int i = 0; i < n; i++) {
                if ((num & (1 << i)) != 0) {
                    a += s.charAt(i);
                }
            }
            res.add(a);
        }
        Collections.sort(res);
        return res;
    }

    List<String> powerSetUsingRecursion(String s) {
        List<String> ps = new ArrayList<>();
        powerSetUsingRecursion(s, 0, "", ps);
        Collections.sort(ps);
        return ps;
    }

    private void powerSetUsingRecursion(String s, int index, String asf, List<String> res) {
        if (s == null || s.isEmpty() || index > s.length()) {
            return;
        }
        if (index == s.length()) {
            res.add(asf);
            return;
        }
        powerSetUsingRecursion(s, index + 1, asf + s.charAt(index), res);
        powerSetUsingRecursion(s, index+1, asf, res);
    }

}
