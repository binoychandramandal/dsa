package aa;

import java.util.Arrays;

public class NPR {
    public static void main(String[] args) {
        //npr(new int[3], 1, 2);
       // npr1(new int[3], 1, 2, -1);
       // ncr(1,3, 0, 2, "");
        ncr1(1,3,0,2,new int[2],"");
    }


    static void ncr(int cb, int tb, int ssf, int ts, String ans) {
        if (cb > tb) {
            if (ssf == ts) {
                System.out.println(ans);
            }
            return;
        }
        ncr(cb+1, tb, ssf, ts, ans+"-");
        ncr(cb+1, tb, ssf+1, ts, ans+"i");
    }

    static void ncr1(int cb, int tb, int ssf, int ts, int[] spot,String ans) {
        if (cb > tb) {
            if (ssf == ts) {
                System.out.println(ans);
            }
            return;
        }
        for (int i = 0; i < spot.length; i++) {
            if(spot[i]==0) {
                spot[i] = i+1;
                ncr1(cb + 1, tb, ssf + 1, ts, spot,ans + (i+1));
                spot[i]=0;
            }
        }
        ncr1(cb+1, tb, ssf, ts, spot,ans+"-");

    }


    static void npr(int[] boxes, int ci, int ti) {
        System.out.println(Arrays.toString(boxes));
        if (ci > ti) {
            for (int i = 0; i < boxes.length; i++) {
                if (boxes[i] != 0) {
                    // System.out.print(boxes[i]);
                } else {
                    //System.out.print("-");
                }
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] == 0) {
                boxes[i] = ci;
                npr(boxes, ci + 1, ti);
                boxes[i] = 0;
            }
        }
    }

    static void npr1(int[] boxes, int ci, int ti, int lc) {
        if (ci > ti) {
            for (int i = 0; i < boxes.length; i++) {
                if (boxes[i] != 0) {
                    System.out.print(boxes[i]);
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
            return;
        }
        for (int i = lc + 1; i < boxes.length; i++) {
            if (boxes[i] == 0) {
                boxes[i] = ci;
                npr1(boxes, ci + 1, ti, i);
                boxes[i] = 0;
            }
        }
    }
}
