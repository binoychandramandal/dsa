package aa;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintCombination {
    public static void main(String[] args) {
       // print(5, "");

        //System.out.println(howMany("How many eggs are in a half-dozen, 13?"));
        //System.out.println(howMany("he is a good programmer, he won 865 competitions, but sometimes he dont. What do you think? All test-cases should pass. Done-done?"));
        System.out.println(howMany("jds dsaf lkdf kdsa fkldsf, adsbf ldka ads? asd bfdal ds bf[l. akf dhj ds 878  dwa WE DE 7475 dsfh ds  RAMU 748 dj."));
        //
        // System.out.println(howMany("jds dsaf lkdf kdsa fkldsf, adsbf ldka ads? asd bfdal ds bf[l. akf dhj ds 878  dwa WE DE 7475 dsfh ds  RAMU 748 dj."));

      //  System.out.println(count_substrings("1102021222",2));
       // System.out.println(countProperFractions(8));

       // int n = 1000000, k = 2;
       // sumPalindrome(n, k);

       // System.out.println(sum(5,2));
    }

    // generates even and odd palindromes
    static int makePalindrome(int n, boolean odd) {
        int res = n;
        if (odd) {
            n = n / 10;
        }
        while (n > 0) {
            res = 10 * res + n % 10;
            n /= 10;
        }
        return res;
    }

    // Check if a number is palindrome
// in base k
    static boolean isPalindrome(int n, int base) {
        int reversed = 0;
        int temp = n;
        while (temp > 0) {
            reversed = reversed * base
                    + temp % base;
            temp /= base;
        }
        return reversed == n;
    }

    // function to print sum of Palindromes
    static void sumPalindrome(int n, int k) {

        int sum = 0, i = 1;

        int p = makePalindrome(i, true);

        // loop for odd generation of
        // odd palindromes
        while (p < n) {
            if (isPalindrome(p, k)) {
                sum += p;
            }
            i++;

            // cout << p << " ";
            p = makePalindrome(i, true);
        }

        i = 1;

        // loop for generation of
        // even palindromes
        p = makePalindrome(i, false);
        while (p < n) {
            if (isPalindrome(p, k)) {
                sum += p;
            }
            i++;
            p = makePalindrome(i, false);
        }

        // result of all palindromes in
        // both bases.
        System.out.println("Total sum is " + sum);
    }

    private static int sum(int N,int K){
        int sum = 0;
        for(int x = 1; x <= N; x++) {
            if(isPalidrome(numTostr(x, 10)) &&
                    isPalidrome(numTostr(x, K))) {
                sum += x;
            }
        }
        return sum;
    }

    private static String numTostr(int x, int base) {
        String result = "";
        while(x > 0) {
            int digit = x % base;
            x /= base;
            result = (char) (digit + '0') + result;
        }
        return result;
    }

    private static boolean isPalidrome(String s) {
        String other = "";
        for(char c : s.toCharArray()) {
            other = c + other;
        }
        return other.equals(s);
    }

    // Function to print all
// proper fractions
    static int countProperFractions(int n)
    {
        Integer result =0;
        for(int i = 1; i < n; i++)
        {
            for(int j = i + 1; j <= n; j++)
            {

                // If the numerator and the
                // denominator are coprime
                if (__gcd(i, j) == 1)
                {
                    String a = String.valueOf(i);
                    String b = String.valueOf(j);
                    result++;
                    System.out.print(a + "/" +
                            b + ", ");
                }
            }
        }
        return result;
    }

    static int __gcd(int a, int b)
    {
        return b == 0 ? a : __gcd(b, a % b);
    }


    static boolean have_same_frequency(int[] freq, int k)
    {
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0 && freq[i] != k) {
                return false;
            }
        }
        return true;
    }
    static int count_substrings(String s, int k)
    {
        int count = 0;
        int distinct = 0;
        boolean[] have = new boolean[11];
        Arrays.fill(have, false);
        for (int i = 0; i < s.length(); i++) {
            have[((int)(s.charAt(i) - '0'))] = true;
        }
        for (int i = 0; i < 11; i++) {
            if (have[i]) {
                distinct++;
            }
        }

        for (int length = 1; length <= distinct; length++) {
            int window_length = length * k;
            int[] freq = new int[26];
            Arrays.fill(freq, 0);
            int window_start = 0;
            int window_end
                    = window_start + window_length - 1;
            for (int i = window_start;
                 i <= Math.min(window_end, s.length() - 1);
                 i++) {
                freq[((int)(s.charAt(i) - '0'))]++;
            }
            while (window_end < s.length()) {
                if (have_same_frequency(freq, k)) {
                    count++;
                }
                freq[(
                        (int)(s.charAt(window_start) - '0'))]--;
                window_start++;
                window_end++;
                if (window_end < s.length()) {
                    freq[((int)(s.charAt(window_end)
                            - '0'))]++;
                }
            }
        }
        return count;
    }

    static int howMany(String sentence){
        if(sentence==null || sentence.length()==0){
            return 0;
        }
        String[] w=sentence.split(" ");
        System.out.println(Arrays.toString(w));
        List<String> l= Arrays.stream(w).map(x->x.replaceAll("[^a-zA-Z-]", "")).map(x->x.trim()).filter(x->!x.isEmpty()).collect(Collectors.toList());
        System.out.println(l);
        return l.size();
    }

    static void print(int n,String asf){
        if(n==0){
            System.out.println(asf);
            return;
        }
        for (int i = 1; i <=n ; i++) {
                print(n - i,  asf + "-" + i);
            }
        }
}
