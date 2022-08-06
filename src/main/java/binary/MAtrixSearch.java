package binary;

public class MAtrixSearch {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][] {
                {3},
                {29},
        {36},
    {63},
        {67},
        {72},
        {74},
        {78},
        {85}
        },41));
    }
    static public int searchMatrix(int[][] A, int B) {

        int i=0;
        int j=A[0].length-1;
        while(i<A.length && j>=0){
            if(A[i][j]==B){
                return 1;
            }else if(A[i][j]<B){
                i++;
            }else{
                j--;
            }
        }
        return -1;
    }
}
