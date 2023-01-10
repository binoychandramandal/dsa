package recurrsion.practice;

public class NQueen {
    public static void main(String[] args) {
        nQueen(new int[4][4],0,"");
    }
    static void nQueen(int[][] chess,int r,String psf){
        if(r==chess.length){
            System.out.println(psf);
            return;
        }
        for (int i = 0; i < chess[0].length; i++) {
           if(isSafePlace(chess,r,i)){
               chess[r][i]=1;
               nQueen(chess,r+1,psf+r+"-"+i+" , ");
               chess[r][i]=0;
           }
        }
    }

    private static boolean isSafePlace(int[][] chess, int r, int i) {
        //top vertical
        int row =r;
        int col =i;
       while (row>=0 ){
           if(chess[row][col]==1){
               return false;
           }
           row--;
       }

         row =r;
         col =i;
        //left diagonal
        while (row>=0 && col>=0){
            if(chess[row][col]==1){
                return false;
            }
            row--;
            col--;
        }
        row =r;
        col =i;
        //right diagonal
        while (row>=0 && col<chess[0].length){
            if(chess[row][col]==1){
                return false;
            }
            row--;
            col++;
        }
        return true;
    }
}
