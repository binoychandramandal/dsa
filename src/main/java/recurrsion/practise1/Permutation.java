package recurrsion.practise1;

public class Permutation {
    public static void main(String[] args) {
        String str="a";
        System.out.println(str.substring(0,0));

        //printPermutation("abc", "");
    }

    static void printPermutation(String str, String asf) {
        if (str.isEmpty()) {
            System.out.println(asf);
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(0);
            String lPart = str.substring(0, i);
            String rPart = str.substring(i + 1);
            String ros = lPart + rPart;
            printPermutation(ros, asf + c);
        }
    }

}
