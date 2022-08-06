package recurrsion.practise;

public class NQueenProblem {

    public static void main(String[] args) {
        int n=4;
        int[][] chess = new int[n][n];
        //printNQueens(chess,"",0);
         n=10;
         boolean[][] board =new boolean[n][n];
         boolean[] cols=new boolean[n];
         boolean[] nDiag=new boolean[2*n-1];
         boolean[] rDiag=new boolean[2*n-1];
        solve(board,0,cols,nDiag,rDiag,"");
    }

    static void printNQueens(int[][] chess,String qsf,int row){
        if(row== chess.length){
            System.out.println(qsf);
            return;
        }
        for(int col=0;col<chess.length;col++){
            if(isSafePlaceForQueen(chess,row,col)) {
                chess[row][col] = 1;
                printNQueens(chess, qsf + row + "-" + col + ",", row + 1);
                chess[row][col] = 0;
            }
        }
    }
    
    static boolean isSafePlaceForQueen(int[][] chess,int row,int col){
        for (int i = row-1, j=col; i>=0; i--) {
            if(chess[i][j]==1){
                return false;
            }
        }

        for (int i = row-1, j=col-1; i>=0 && j>=0; i--,j--) {
            if(chess[i][j]==1){
                return false;
            }
        }

        for (int i = row-1, j=col+1; i>=0 && j< chess.length; i--,j++) {
            if(chess[i][j]==1){
                return false;
            }
        }

        return true;
    }

    static void solve(boolean[][] board,int row,boolean[] cols,boolean[] nDiag,boolean[] rDiag,String asf){
        if(row==board.length){
            System.out.println(asf+".");
            return;
        }
        for (int col = 0; col < board[0].length; col++) {
            if(cols[col]==false && nDiag[row+col]==false && rDiag[row-col+board.length-1]==false){
                board[row][col]=true;
                cols[col]=true;
                nDiag[row+col]=true;
                rDiag[row-col+board.length-1]=true;
                solve(board,row+1,cols,nDiag,rDiag,asf+row+"-"+col+", ");
                board[row][col]=false;
                cols[col]=false;
                nDiag[row+col]=false;
                rDiag[row-col+board.length-1]=false;
            }
        }
    }



}
