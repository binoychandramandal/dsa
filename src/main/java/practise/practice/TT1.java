package practise.practice;

public class TT1 {

    public static void main(String[] args) {
       // printCombination(1, 4, 0, 2, "");
        printP(1, 4, 0,2,new int[2], "");
    }

    static void printCombination(int ci, int ti, int cs, int ts, String ans) {
        if (ci > ti) {
            if (cs == ts) {
                System.out.println(ans);
            }
            return;
        }
        printCombination(ci + 1, ti, cs + 1, ts, ans + "i");
        printCombination(ci + 1, ti, cs, ts, ans + "-");
    }

    static void printP(int ci, int ti, int cs, int ts, int[] item, String ans) {
        if (ci > ti) {
            if (cs == ts) {
                System.out.println(ans);
            }
            return;
        }
        for (int i = 0; i < item.length; i++) {
            if (item[i] == 0) {
                item[i] = 1;
                printP(ci + 1, ti, cs + 1, ts, item, ans + (1+i));
                item[i] = 0;

            }
        }
        printP(ci + 1, ti, cs, ts, item, ans + "-");
    }

}
