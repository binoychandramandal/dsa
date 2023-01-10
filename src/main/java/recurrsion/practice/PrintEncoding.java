package recurrsion.practice;

public class PrintEncoding {
    public static void main(String[] args) {
       // printEncoding("103","");
        printEncodings("123","");
    }

    static void printEncodings(String s, String ans) {
        if (s == null || s.isEmpty()) {
            System.out.println(ans);
            return;
        } else if (s.length() == 1) {
            char c = s.charAt(0);
            if (c == '0') {
                return;
            } else {
                char code =(char)('a'+c-'0'-1);
                System.out.println(ans + code);
                return;
            }
        } else {
            char c = s.charAt(0);
            if (c == '0') {
                return;
            } else {
                char code=(char)('a' + c-'0' - 1);
                printEncodings(s.substring(1), ans + code);
            }
            if (Integer.parseInt(s.substring(0, 2)) <= 26) {
                char code=(char)('a' + Integer.parseInt(s.substring(0, 2)) - 1);
                printEncodings(s.substring(2), ans +code);
            }

        }
    }

    static void printEncoding(String s, String ans) {
        if (s == null || s.isEmpty()) {
            System.out.println(ans);
            return;
        } else if (s.length() == 1) {
            int l = s.charAt(0) - '0';
            if (l == 0) {
                return;
            } else {
                System.out.println(ans + ((char) ('a' + l - 1)));
            }
        } else {
            int l = s.charAt(0) - '0';
            if (l == 0) {
                return;
            } else {
                printEncoding(s.substring(1), ans + ((char) ('a' + l - 1)));
            }

            String ch2 = s.substring(0, 2);
            String rem = s.substring(2);
            Integer in = Integer.parseInt(ch2);
            if (in <= 26) {
                printEncoding(rem, ans + ((char) ('a' + in - 1)));
            }
        }


    }
}
