package interview;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * Example:
 * <p>
 * "A man, a plan, a canal: Panama" is a palindrome.
 * <p>
 * "race a car" is not a palindrome.
 * <p>
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class PalindromeTest {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(""));
    }

    public static int isPalindrome(String A) {
        if (A == null) {
            return 1;
        }
        A = A.toLowerCase();
        int i = 0;
        int j = A.length() - 1;
        while (i < j) {
            Character c1 = A.charAt(i);
            Character c2 = A.charAt(j);
            if (Character.isLetterOrDigit(c1) && Character.isLetterOrDigit(c2)) {
                if (c1 != c2) {
                    return 0;
                }
                i++;
                j--;
            } else if (!Character.isLetterOrDigit(c1)) {
                i++;
            } else if (!Character.isLetterOrDigit(c2)) {
                j--;
            }
        }
        return 1;
    }

}
