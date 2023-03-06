package aa;

public class Queen {
    public static void main(String[] args) {
        //placeQueen(0,4,0,0,"");
        queenCombination(0,4,new boolean[4][4],0,-1);
    }


    static void queenCombination(int qpsf,int tq,boolean[][] chess,int row,int lc){
             if(qpsf==tq){
                 for (int i = 0; i < chess.length; i++) {
                     for (int j = 0; j < chess[i].length; j++) {
                         if(chess[i][j]){
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

        for (int i = row; i <chess.length ; i++) {
            for (int j = lc+1; j < chess[i].length; j++) {
                if(chess[i][j]==false){
                    chess[i][j]=true;
                    queenCombination(qpsf+1,tq,chess,i,j);
                    chess[i][j]=false;
                }
            }
        }
    }

    static void placeQueen(int qsf,int tq,int row,int col,String ans){
        if(row==tq){
            if(qsf==tq){
                System.out.println(ans);
            }
            return;
        }

        int nr=0;
        int nc=0;
        String yes="";
        String no="";
        if(col==tq-1){
            nr =row+1;
            nc=0;
            yes=ans+"q\n";
            no=ans+"-\n";
        }else{
            nr =row;
            nc=col+1;
            yes=ans+"q";
            no=ans+"-";
        }
        placeQueen(qsf+1,tq,nr,nc,yes);
        placeQueen(qsf,tq,nr,nc,no);


    }
}
