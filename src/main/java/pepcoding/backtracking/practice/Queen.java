package pepcoding.backtracking.practice;

public class Queen {

    static  int count=0;

    public static void main(String[] args) {
        //printQueenLocation(0, 4, 0, 0, "");
        //printDistinctQueenLocation(0,4,new int[4][4]);
        //printDistinctQueenLocation(0,4,0,0,"",new boolean[4]);
        //printQueenLocation(0,4,new boolean[4][4],-1);
        //printNQueen(0,8,new boolean[8][8],-1);
       // printDNQueen(0,4,new int[4][4]);
        nKnight(0,4,new boolean[4][4],-1);
        System.out.println(count);
    }

    /**
     * Place similar queen in 2d matrix
     * box on level
     */
    static void printQueenLocation(int qsf, int tq, int row, int col, String ans) {
        if (row == tq) {
            if (qsf == tq) {
                System.out.println(ans);
            }
            return;
        }
        int nr = 0;
        int nc = 0;
        String yans = "";
        String nans = "";
        if (col == tq - 1) {
            nr = row + 1;
            nc = 0;
            yans = ans + "q\n";
            nans = ans + "-\n";
        } else {
            nr = row;
            nc = col + 1;
            yans = ans + "q";
            nans = ans + "-";
        }
        printQueenLocation(qsf + 1, tq, nr, nc, yans);
        printQueenLocation(qsf, tq, nr, nc, nans);
    }

    /**
     * Place similar queen in 2d matrix
     * Item on level
     */
    static void printQueenLocation(int qsf, int tq,boolean chess[][], int ll) {
        if (qsf == tq) {
            for (int i = 0; i < chess.length; i++) {
                for (int j = 0; j < chess[i].length; j++) {
                    if(chess[i][j]==true){
                        System.out.print("q\t");
                    }else{
                        System.out.print("-\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int i = ll+1; i < chess.length* chess.length; i++) {
            int row = i/ chess.length;
            int col = i% chess.length;
            if(chess[row][col]==false){
                chess[row][col]=true;
                printQueenLocation(qsf+1,tq,chess,i);
                chess[row][col]=false;
            }
        }
    }



    /**
     * Place similar queen in 2d matrix
     * Item on level and
     */
    static void printNQueen(int qsf, int tq,boolean chess[][], int ll) {
        if (qsf == tq) {
            for (int i = 0; i < chess.length; i++) {
                for (int j = 0; j < chess[i].length; j++) {
                    System.out.print(chess[i][j]?"q\t":"-\t");
                }
                System.out.println();
            }
            System.out.println(count++);
            return;
        }
        for (int i = ll+1; i < chess.length* chess.length; i++) {
            int row = i/ chess.length;
            int col = i% chess.length;
            if(chess[row][col]==false && isQueenSafe(chess,row,col)){
                chess[row][col]=true;
                printNQueen(qsf+1,tq,chess,row* chess.length+col);
                chess[row][col]=false;
            }
        }
    }

    private static boolean isQueenSafe(boolean[][] chess, int row, int col) {
        // vertical
        for (int i = row,j=col; i>=0; i--) {
            if(chess[i][j]){
                return false;
            }
        }

        // Horizontal
        for (int i=row,j = col; j >=0; j--) {
            if(chess[i][j]){
                return false;
            }
        }

        // Diagonal left
        for (int i=row,j = col;  i>=0 &&j >=0 ; j--,i--) {
            if(chess[i][j]){
                return false;
            }
        }



        // Diagonal Right
        for (int i=row,j = col;  i>=0 && j < chess.length;i--,j++) {
            if(chess[i][j]){
                return false;
            }
        }

        return true;
    }

    private static boolean isDQueenSafe(int[][] chess, int row, int col) {
        // vertical up
        for (int i = row,j=col; i>=0; i--) {
            if(chess[i][j]>0){
                return false;
            }
        }

        // vertical down
        for (int i = row,j=col; i< chess.length; i++) {
            if(chess[i][j]>0){
                return false;
            }
        }

        // Horizontal left
        for (int i=row,j = col; j >=0; j--) {
            if(chess[i][j]>0){
                return false;
            }
        }

        // Horizontal right
        for (int i=row,j = col; j< chess.length; j++) {
            if(chess[i][j]>0){
                return false;
            }
        }

        // Diagonal left up
        for (int i=row,j = col;  i>=0 &&j >=0 ; j--,i--) {
            if(chess[i][j]>0){
                return false;
            }
        }

        // Diagonal right up
        for (int i=row,j = col;  i>=0 &&j < chess.length ; j++,i--) {
            if(chess[i][j]>0){
                return false;
            }
        }

        // Diagonal down right
        for (int i=row,j = col;  i< chess.length && j < chess.length;i++,j++) {
            if(chess[i][j]>0){
                return false;
            }
        }

        // Diagonal down left
        for (int i=row,j = col;  i< chess.length && j >=0;i++,j--) {
            if(chess[i][j]>0){
                return false;
            }
        }

        return true;
    }
    static void printDNQueen(int qsf, int tq,int chess[][]) {
        if (qsf == tq) {
            for (int i = 0; i < chess.length; i++) {
                for (int j = 0; j < chess[i].length; j++) {
                    System.out.print(chess[i][j]>0?"q"+chess[i][j]+"\t":"-\t");
                }
                System.out.println();
            }
            System.out.println(count++);
            return;
        }
        for (int i = 0; i < chess.length* chess.length; i++) {
            int row = i/ chess.length;
            int col = i% chess.length;
            if(chess[row][col]==0 && isDQueenSafe(chess,row,col)){
                chess[row][col]=qsf+1;
                printDNQueen(qsf+1,tq,chess);
                chess[row][col]=0;
            }
        }
    }


    /**
     * Place distinct queen in 2d matrix
     */
    static void printDistinctQueenLocation(int qsf, int tq, int[][] chess) {
        if (qsf == tq) {
            System.out.println("---------------------------");
            for (int i = 0; i < chess.length; i++) {
                for (int j = 0; j < chess[i].length; j++) {
                    if (chess[i][j] == 0) {
                        System.out.print("-\t");
                    } else {
                        System.out.print("q" + chess[i][j] + "\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[i].length; j++) {
                if(chess[i][j]==0){
                    chess[i][j]=qsf+1;
                    printDistinctQueenLocation(qsf + 1, tq, chess);
                    chess[i][j]=0;
                }
            }
        }
    }

    /**
     * Place distinct queen in 2d matrix
     */
    static void printDistinctQueenLocation(int qsf, int tq, int row,int col,String ans,boolean[] queen) {
        if (row == tq) {
            if(qsf==tq) {
                System.out.println(ans);
                count++;
            }
           // System.out.println(count++);
            return;
        }
        int nr=0;
        int nc=0;
        char sep = '\0';
        if(col==tq-1){
            nr =row+1;
            nc=0;
            sep = '\n';
        }else{
            nr = row;
            nc= col+1;
            sep = '\t';
        }

        for (int i = 0; i < queen.length; i++) {
                if(queen[i]==false){
                    queen[i]=true;
                    printDistinctQueenLocation(qsf + 1, tq,nr,nc,ans+"q"+(i+1)+sep, queen);
                    queen[i]=false;
                }
        }
        printDistinctQueenLocation(qsf, tq,nr,nc,ans+"-"+sep, queen);
    }


    static void nKnight(int ksf,int tk,boolean[][]chess,int ll){
        if(ksf==tk){
            for (int i = 0; i < chess.length; i++) {
                for (int j = 0; j < chess.length; j++) {
                    System.out.print(chess[i][j]?"q\t":"-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = ll+1; i < chess.length* chess.length; i++) {
            int row =i/ chess.length;
            int col = i% chess.length;
            if(chess[row][col]==false && isKnightSafe(chess,row,col)){
                chess[row][col]=true;
                nKnight(ksf+1,tk,chess,row* chess.length+col);
                chess[row][col]=false;
            }
        }
    }

    static boolean isKnightSafe(boolean[][] chess,int i,int j){
        if(i-1>=0 && j-2>=0 && chess[i-1][j-2]){
            return false;
        }
        if(i-2>=0 && j-1>=0 && chess[i-2][j-1]){
            return false;
        }

        if(i-2>=0 && j+1< chess.length && chess[i-2][j+1]){
            return false;
        }
        if(i-1>=0 && j+2< chess.length && chess[i-1][j+2]){
            return false;
        }
        return true;
    }
}
