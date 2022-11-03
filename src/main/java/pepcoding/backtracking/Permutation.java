package pepcoding.backtracking;

public class Permutation {
    public static void main(String[] args) {
        printPermutation(new int[4],1,2);
    }

    static void printPermutation(int[] boxies,int ci,int ti){
        if(ci>ti){
            for (int i = 0; i < boxies.length; i++) {
                System.out.print(boxies[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < boxies.length; i++) {
            if(boxies[i]==0){
                boxies[i]=ci;
                printPermutation(boxies,ci+1,ti);
                boxies[i]=0;
            }
        }
    }
}
