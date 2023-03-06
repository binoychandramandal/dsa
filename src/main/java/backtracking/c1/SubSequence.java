package backtracking.c1;

import java.util.ArrayList;
import java.util.List;

public class SubSequence {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(generateSubsequence(s, 0));
        print(0,s,"");
    }

    static List<String> generateSubsequence(String s, int i) {
        if (i == s.length()) {
            List<String> l = new ArrayList<>();
            l.add("");
            return l;
        }
        char c = s.charAt(i);
        List<String> rem = generateSubsequence(s, i + 1);
        List<String> ans = new ArrayList<>();
        for (int j = 0; j < rem.size(); j++) {
            ans.add(c + rem.get(j));
        }
        for (int j = 0; j < rem.size(); j++) {
            ans.add(rem.get(j));
        }
        return ans;
    }

    static void print(int i, String s, String asf) {
        if (i == s.length()) {
            System.out.println(asf);
            return;
        }
        print(i + 1, s, asf + s.charAt(i));
        print(i + 1, s, asf);
    }


}
