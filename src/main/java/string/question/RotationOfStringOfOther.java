package string.question;

public class RotationOfStringOfOther {
    public static void main(String[] args) {
        System.out.println(isRotationOfOtherString("ABACD","CDABA"));
    }

    static boolean isRotationOfOtherString(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        String temp = s1 + s1;
        return temp.contains(s2);
    }
}
