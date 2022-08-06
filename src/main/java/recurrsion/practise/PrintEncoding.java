package recurrsion.practise;

public class PrintEncoding {
    public static void main(String[] args) {

        printEncoding("123", "");

    }

    static void printEncoding(String ques, String asf) {
        if (ques.isEmpty()) {
            System.out.print(asf + " ");
            return;
        } else if (ques.length() == 1) {
            char ch = ques.charAt(0);
            if (ch == '0') {
                return;
            } else {
                int chv = ch - '0';
                char code = (char) ('a' + chv - 1);
                asf = asf + code;
                System.out.print(asf + " ");
            }
        } else {
            char ch = ques.charAt(0);
            String roq = ques.substring(1);
            if (ch == '0') {
                return;
            } else {

                if (ch == '0') {
                    return;
                } else {
                    int chv = ch - '0';
                    char code = (char) ('a' + chv - 1);
                    printEncoding(roq, asf + code);
                }
                String ch2 = ques.substring(0, 2);
                String roq2 = ques.substring(2);
                int ch2v = Integer.parseInt(ch2);
                if (ch2v <= 26) {
                    char code = (char) ('a' + ch2v - 1);
                    printEncoding(roq2, asf + code);
                }

            }
        }
    }
}
