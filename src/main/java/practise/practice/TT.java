package practise.practice;

public class TT {

    public static void main(String[] args) {
        printPItemOnLevel(1,2,new int[4]);
        printCItemOnLevel(1,2,new int[4],-1);
    }


    static void printPItemOnLevel(int ci, int ti, int[] box) {
        if (ci > ti) {
            for (int i = 0; i < box.length; i++) {
                if (box[i] == 0) {
                    System.out.print("-");
                } else {
                    System.out.print(box[i]);
                }
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < box.length; i++) {
            if (box[i] == 0) {
                box[i] = ci;
                printPItemOnLevel(ci + 1, ti, box);
                box[i] = 0;
            }
        }
    }


    static void printCItemOnLevel(int ci, int ti, int[] box,int ll) {
        if (ci > ti) {
            for (int i = 0; i < box.length; i++) {
                if (box[i] == 0) {
                    System.out.print("-");
                } else {
                    System.out.print("i");
                }
            }
            System.out.println();
            return;
        }

        for (int i = ll+1; i < box.length; i++) {
            if (box[i] == 0) {
                box[i] = ci;
                printCItemOnLevel(ci + 1, ti, box,i);
                box[i] = 0;
            }
        }
    }



}
