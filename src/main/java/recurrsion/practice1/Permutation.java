package recurrsion.practice1;

public class Permutation {
    public static void main(String[] args) {

        //  printPermutation(2,1,new int[3]);
        //printCombination(1, 3, 0, 0, "");
       // printCombination1(1, 3, 2, 0,new int[2], "");
        printPermutationC(2,1,-1,new int[3]);
    }

    static void printCombination(int cc, int tc, int ts, int ssf, String ans) {
        if (cc > tc) {
            if (ts == ssf)
                System.out.println(ans);
            return;
        }

        printCombination(cc + 1, tc, ts, ssf, ans + "-");
        printCombination(cc + 1, tc, ts, ssf + 1, ans + "i");

    }


    static void printCombination1(int cc, int tc, int ts, int ssf, int[] spot, String ans) {
        if (cc > tc) {
            if (ts == ssf)
                System.out.println(ans);
            return;
        }
        for (int i = 0; i < spot.length; i++) {
            if (spot[i] == 0) {
                spot[i] = i + 1;
                printCombination1(cc + 1, tc, ts, ssf + 1, spot, ans + (i+1));
                spot[i] = 0;
            }
        }
        printCombination1(cc + 1, tc, ts, ssf, spot, ans + "-");
    }

    static void printPermutation(int n, int currentElement, int[] boxes) {
        if (currentElement > n) {
            for (int i = 0; i < boxes.length; i++) {
                if (boxes[i] == 0) {
                    System.out.print("-");
                } else {
                    System.out.print(boxes[i]);
                }
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] == 0) {
                boxes[i] = currentElement;
                printPermutation(n, currentElement + 1, boxes);
                boxes[i] = 0;
            }
        }
    }

    static void printPermutationC(int n, int currentElement, int lc,int[] boxes) {
        if (currentElement > n) {
            for (int i = 0; i < boxes.length; i++) {
                if (boxes[i] == 0) {
                    System.out.print("-");
                } else {
                    System.out.print(boxes[i]);
                }
            }
            System.out.println();
            return;
        }

        for (int i = lc+1; i < boxes.length; i++) {
            if (boxes[i] == 0) {
                boxes[i] = currentElement;
                printPermutationC(n, currentElement + 1,i, boxes);
                boxes[i] = 0;
            }
        }
    }


}
