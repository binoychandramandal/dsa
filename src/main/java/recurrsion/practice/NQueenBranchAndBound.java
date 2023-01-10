package recurrsion.practice;

public class NQueenBranchAndBound {
    public static void main(String[] args) {
        print(new boolean[4][4],0,"",new boolean[4],new boolean[7],new boolean[7]);
    }


    static void print(boolean[][] board,int row,String asf,boolean[] cols,boolean[] ld,boolean[] rd){

        if(row==board.length){
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if(cols[i]==false && ld[i+row]==false && rd[row-i+board.length-1]==false) {
                cols[i]=true ;
                ld[i+row]=true;
                rd[row-i+board.length-1]=true;
                board[row][i] = true;
                print(board, row + 1, asf + "(" + row + " " + i + ") ",cols,ld,rd);
                board[row][i] = false;
                cols[i]=false ;
                ld[i+row]=false;
                rd[row-i+board.length-1]=false;
            }
        }
    }
}
