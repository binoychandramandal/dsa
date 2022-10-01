package string.practice;

import java.util.Arrays;

public class PatternMatching {
    public static void main(String[] args) {
        String text = "abxabc";
        String pattern = "abca";
        // System.out.println(isContains(text, pattern));

       // System.out.println(Arrays.toString(createPrefixAndSuffixArray("abcdabeabf")));
       // System.out.println(KMP("abcdabeabf", "abf"));
        //System.out.println(KMP("abcabcabcbc", "abc"));
        System.out.println(found("abcabcabcbc", "zbcbc"));


       // System.out.println(Arrays.toString(createPrefixSuffix("abcdabeabf")));
    }


    static int[] lps(String s){
        int[] r =new int[s.length()];
        int i=0;
        int j=1;
        while (j<s.length()){
            if(s.charAt(i)==s.charAt(j)){
                r[j] =i+1;
                i++;
                j++;
            }else{
                if(i!=0){
                    i =r[i-1];
                }else{
                    r[j] =0;
                    j++;
                }
            }
        }
        return r;
    }

    static boolean found(String s,String p){
        int[] lps = lps(p);
        int i=0;
        int j=0;
        while (i<s.length()){
            if(s.charAt(i)==p.charAt(j)){
                i++;
                j++;
                if(j==p.length()){
                    return true;
                }
            }else{
                if(j!=0){
                    j =lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return false;
    }



    static int[] createPrefixSuffix(String s) {
        int[] r = new int[s.length()];
        int i = 0;
        int j = 1;
        while (j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                r[j] = i + 1;
                i++;
                j++;
            } else {
                if (i != 0) {
                    i = r[i - 1];
                } else {
                    r[j] = 0;
                    j++;
                }
            }
        }
        return r;
    }

    static boolean isContains(String text, String pattern) {
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            int j = 0;
            int index = i;
            while (j < pattern.length()) {
                if (text.charAt(index) == pattern.charAt(j)) {
                    index++;
                    j++;
                } else {
                    break;
                }
            }
            if (j == pattern.length()) {
                return true;
            }
        }
        return false;
    }


    static int[] createPrefixAndSuffixArray(String s) {
        int i = 0;
        int j = 1;
        int[] lps = new int[s.length()];
        while (j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                lps[j] = i + 1;
                i++;
                j++;
            } else {
                if (i != 0) {
                    i = lps[i - 1];
                } else {
                    lps[j] = 0;
                    j++;
                }
            }
        }
        return lps;
    }


    public static boolean KMP(String text, String pattern) {
        int lps[] = createPrefixAndSuffixArray(pattern);
        int i = 0;
        int j = 0;
        while (i < text.length() && j < pattern.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;

                if (j == pattern.length()) {
                    System.out.println(i-pattern.length());
                    j=0;
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        if (j == pattern.length()) {
            return true;
        }
        return false;
    }

}
