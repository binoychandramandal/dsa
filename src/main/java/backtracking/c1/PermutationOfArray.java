package backtracking.c1;

import java.util.Arrays;

public class PermutationOfArray {
    public static void main(String[] args) {
        printPermutation(new int[]{1,2,3},0);
    }
    static void printPermutation(int[] item,int pos){
        if(pos== item.length){
            System.out.println(Arrays.toString(item));
            return;
        }
        for (int i = pos; i < item.length; i++) {
            swap(item,pos,i);
            printPermutation(item,pos+1);
            swap(item,i,pos);
        }
    }

   private  static void swap(int [] item,int i,int j){
        int tmp =item[i];
        item[i]=item[j];
        item[j]=tmp;
   }
}
