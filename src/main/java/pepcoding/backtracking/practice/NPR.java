package pepcoding.backtracking.practice;

public class NPR {
    public static void main(String[] args) {
        perm(1,2,new int[4]);
        System.out.println("second");
        perm(1,2,new int[3],-1);
    }

   static void perm(int ci,int ti,int[] boxes){
        if(ci>ti){
            for (int i = 0; i < boxes.length; i++) {
                if(boxes[i]==0){
                    System.out.print("-");
                }else{
                    System.out.print(boxes[i]);
                }
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < boxes.length; i++) {
            if(boxes[i]==0){
                boxes[i] = ci;
                perm(ci+1,ti,boxes);
                boxes[i] =0;
            }
        }
    }

    static void perm(int ci,int ti,int[] boxes, int llp){
        if(ci>ti){
            for (int i = 0; i < boxes.length; i++) {
                if(boxes[i]==0){
                    System.out.print("-");
                }else{
                    System.out.print(boxes[i]);
                }
            }
            System.out.println();
            return;
        }

        for (int i = llp+1; i < boxes.length; i++) {
            if(boxes[i]==0){
                boxes[i] = ci;
                perm(ci+1,ti,boxes,i);
                boxes[i] =0;
            }
        }
    }
}
