package pepcoding.backtracking.practice;

public class Combination1 {
    public static void main(String[] args) {
        combination(new boolean[3],1,2,-1);
    }
    static void combination(boolean[] boxes,int ci,int ti,int lb){
        if(ci>ti){
            for (int i = 0; i < boxes.length; i++) {
                if(boxes[i]==true){
                    System.out.print("i");
                }else{
                    System.out.print("-");
                }
            }
            System.out.println();
            return;
        }

        for (int i = lb+1; i < boxes.length; i++) {
            if(boxes[i]==false) {
                boxes[i]=true;
                combination(boxes, ci + 1, ti, i);
                boxes[i]=false;
            }
        }
    }
}
