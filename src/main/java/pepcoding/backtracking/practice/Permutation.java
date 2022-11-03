package pepcoding.backtracking.practice;

public class Permutation {
    public static void main(String[] args) {
        //permutation(1,2,new int[4]);
       // permute(1,2,new int[4]);
        permuteLetter(new String[]{"A"},0,new String[3]);
    }
    
    static void permutation(int it,int ti,int[] boxes){
        if(it>ti){
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
                boxes[i]=it;
                permutation(it+1,ti,boxes);
                boxes[i]=0;
            }
        }
    }


    static void permute(int ci,int ti,int[] boxes){
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
                boxes[i]=ci;
                permute(ci+1,ti,boxes);
                boxes[i]=0;
            }
        }
    }

    static void permuteLetter(String[] items,int in,String [] boxes){
        if(in>=items.length){
            for (int i = 0; i < boxes.length; i++) {
                if(boxes[i]==null){
                    System.out.print("-");
                }else{
                    System.out.print(boxes[i]);
                }
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < boxes.length; i++) {
            if(boxes[i]==null){
                boxes[i]=items[in];
                permuteLetter(items,in+1,boxes);
                boxes[i]=null;
            }
        }
    }
}
