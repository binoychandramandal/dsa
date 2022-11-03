package pepcoding.backtracking;

public class Combination1 {
    public static void main(String[] args) {

        combination(new boolean[5],1,3,-1);

    }

    static void combination(boolean[] boxes, int ci, int ti, int llb) {
        if (ci > ti) {
            for (int i = 0; i < boxes.length; i++) {
                if(boxes[i]){
                    System.out.print("i");
                }else{
                    System.out.print("-");
                }
            }
            System.out.println();
            return;
        }
        for (int i = llb+1; i <boxes.length ; i++) {
            if(boxes[i]==false) {
                boxes[i] = true;
                combination(boxes, ci + 1, ti, i);
                boxes[i] = false;
            }
        }

    }
}
