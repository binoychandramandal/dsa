package practise.practice;

public class Combination {
    public static void main(String[] args) {
        //combination(1, 4, 0, 2, "");
        combination1(1, 4, new int[2],0, 2, "");
    }

    static void combination(int cb, int tb, int ssf, int ts, String ans) {
        if (cb > tb) {
            if (ssf == ts)
                System.out.println(ans);
            return;
        }
        combination(cb + 1, tb, ssf + 1, ts, ans + "i");
        combination(cb + 1, tb, ssf, ts, ans + "0");
    }


    static void combination1(int cb, int tb, int item[], int ssf, int ts, String ans) {
        if (cb > tb) {
            if (ssf == ts)
                System.out.println(ans);
            return;
        }
        for (int i = 0; i < item.length; i++) {
            if (item[i] == 0) {
                item[i] = i + 1;
                combination1(cb + 1, tb, item, ssf + 1, ts, ans + (i + 1));
                item[i] = 0;
            }
        }
        combination1(cb + 1, tb, item, ssf, ts, ans + "0");
    }


}
