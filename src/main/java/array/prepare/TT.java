package array.prepare;

public class TT {
    public static void main(String[] args) {
        System.out.println(reverseString("abc"));
    }

    private static String reverseString(String s) {
        if(s.isEmpty()){
            return "";
        }
        char c= s.charAt(0);
        String res = reverseString(s.substring(1));
        return res+c;
    }

}
