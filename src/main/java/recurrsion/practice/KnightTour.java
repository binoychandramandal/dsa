package recurrsion.practice;

public class KnightTour {
    public static void main(String[] args) {
      //tour(new int[8][8],0,0,1);
      tour(new int[4][4],0,0,1);
       // printKnight(new int[4][4],0,0,1);
    }

    static void tour(int[][] chess, int r, int c, int move) {
        if (r < 0 || c < 0 || r >= chess.length || c >= chess[0].length || chess[r][c] > 0) {
            return;
        } else if (move == chess.length * chess.length) {
            chess[r][c] = move;
            System.out.println("---------------------------------------------");
            display(chess);
            chess[r][c] = 0;
            return;
        }
        chess[r][c] = move;
        tour(chess, r - 2, c + 1, move + 1);
        tour(chess, r - 1, c + 2, move + 1);
        tour(chess, r + 1, c + 2, move + 1);
        tour(chess, r + 2, c + 1, move + 1);
        tour(chess, r + 2, c - 1, move + 1);
        tour(chess, r + 1, c - 2, move + 1);
        tour(chess, r - 1, c - 2, move + 1);
        tour(chess, r - 2, c - 1, move + 1);
        chess[r][c] = 0;
    }


    static void printKnight(int[][] chess, int r, int c, int move) {
        if (r < 0 || c < 0 || r >= chess.length || c >= chess[0].length || chess[r][c] > 0) {
            return;
        }
        if (move == chess.length * chess.length) {
            chess[r][c] = move;
            System.out.println("-----------------------");
            display(chess);
            chess[r][c] = 0;
            return;
        }
        chess[r][c] = move;
        printKnight(chess, r - 2, c + 1, move + 1);
        printKnight(chess, r - 1, c + 2, move + 1);
        printKnight(chess, r + 1, c + 2, move + 1);
        printKnight(chess, r + 2, c + 1, move + 1);
        printKnight(chess, r + 2, c - 1, move + 1);
        printKnight(chess, r + 1, c - 2, move + 1);
        printKnight(chess, r - 1, c - 2, move + 1);
        printKnight(chess, r - 2, c - 1, move + 1);
        chess[r][c] = 0;

    }




    static void display(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                if(chess[i][j]== chess.length* chess.length)
                System.out.print("["+chess[i][j] + "]  ");
                else
                    System.out.print(chess[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
