package pepcoding.backtracking.practice;

public class PalindromicPartitioning {
    public static void main(String[] args) {
        solution("abaaba","");
    }

    static boolean isPalindrome(String s){
        int li=0;
        int ri =s.length()-1;
        while (li<ri){
            if(s.charAt(li++)!=s.charAt(ri--)){
                return false;
            }
        }
        return true;
    }
    private static void solution(String s, String asf) {
        if(s.isEmpty()){
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String prefix = s.substring(0,i+1);
            String ros = s.substring(i+1);
            if(isPalindrome(prefix)){
                solution(ros,asf+"("+prefix+") ");
            }
        }
    }
}
