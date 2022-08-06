package recurrsion.practise;

public class KnightsTour {

    public static void main(String[] args) {
        int n = 8;
        int[][] chess = new int[n][n];
        printKnightTour(chess, 0, 0, 1);
    }

    static void printKnightTour(int[][] chess, int r, int c, int move) {

        if (r < 0 || c < 0 || r >= chess.length || c >= chess.length || chess[r][c] > 0) {
            return;
        } else if (move == chess.length * chess.length) {
            chess[r][c] = move;
            System.out.println("Printing");
            displayBoard(chess);
            chess[r][c] = 0;
            return;
        }
        chess[r][c] = move;
        printKnightTour(chess, r - 2, c + 1, move + 1);
        printKnightTour(chess, r - 1, c + 2, move + 1);
        printKnightTour(chess, r + 1, c + 2, move + 1);
        printKnightTour(chess, r + 2, c + 1, move + 1);
        printKnightTour(chess, r + 2, c - 1, move + 1);
        printKnightTour(chess, r + 1, c - 2, move + 1);
        printKnightTour(chess, r - 1, c - 2, move + 1);
        printKnightTour(chess, r - 2, c - 1, move + 1);
        chess[r][c] = 0;
    }

    static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[i].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
