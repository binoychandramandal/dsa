package string.practice;

public class LPS {
    public static void main(String[] args) {
        System.out.println(lps("abacaba"));
    }

    static int lps(String str) {
        int max = 1;
        for (int i = 1; i < str.length(); i++) {
            int l = i - 1;
            int r = i + 1;
            while (l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
                l--;
                r++;
            }
            max = Math.max(max, r - l - 1);
        }
        max=Math.max(max,str.length()%2==0 && isPalindrome(str)?str.length():max);
        return max;
    }

    static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (l >= 0 && r < s.length() && s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
