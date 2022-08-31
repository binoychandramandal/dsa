package recurrsion.practise;

public class Permutation {

    public static void main(String[] args) {
        //printPermutation("abc","");
        permutations(new int[3], 1);
        //permutations( 1, 5,new int[3],0,3,"");
    }


    static void printPermutation(String ques, String asf) {
        if (ques.isEmpty()) {
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < ques.length(); i++) {
            char ch = ques.charAt(i);
            String qlpart = ques.substring(0, i);
            String qrpart = ques.substring(i + 1);
            String roq = qlpart + qrpart;
            printPermutation(roq, asf + ch);
        }
    }


    static void permutations(int[] boxes, int ci) {
        if (ci > boxes.length) {
            StringBuilder sb =new StringBuilder();
            for (int i = 0; i < boxes.length; i++) {
                if(boxes[i]!=0)
                sb.append(boxes[i]);
            }
            System.out.println(sb.toString());
            return;
        }

        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] == 0) {
                boxes[i] = ci;
                permutations(boxes, ci + 1);
                boxes[i] = 0;
            }
        }
    }

    static void permutations(int cb, int tb, int[] items, int ssf, int ts, String asf) {
        if (cb > tb) {
            if (ssf == ts)
                System.out.println(asf);
            return;
        }

        for (int i = 0; i < ts; i++) {
            if (items[i] == 0) {
                items[i] = 1;
                permutations(cb + 1, tb, items, ssf + 1, ts, asf + (i + 1));
                items[i] = 0;
            }
        }
        permutations(cb + 1, tb, items, ssf, ts, asf + 0);
    }


}
