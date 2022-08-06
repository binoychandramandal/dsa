package graph.pepcoding;

import java.util.HashSet;

public class KnightTour {
    public static void main(String[] args) {
        int n = 5;
        int[][] chess = new int[n][n];
        int[] xMoves = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMoves = {1, 2, 2, 1, -1, -2, -2, -1};
       // printKnightTour(chess, 0, 0, 1);

        //solveKnightTourAll(chess,0,0,1,xMoves,yMoves);

        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                printKnightTour(chess, i, j, 1);
//                chess[i][j]=1;
//                System.out.println(i+" :  "+j);
//                if(solveKnightTour(chess,i,j,2,xMoves,yMoves)){
//                    displayBoard(chess);
//                }
//                chess[i][j]=0;
                System.out.println("*************************************");
            }
        }
    }

    static void printKnightTour(int[][] chess, int r, int c, int move) {
        if (!isValidMove(chess, r, c)) {
            return;
        } else if (move == chess.length * chess.length) {
            chess[r][c] = move;
            displayBoard(chess);
            chess[r][c] = 0;
            //System.exit(0);
            System.out.println("---------------------------------------");
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

    static boolean solveKnightTour(int[][] chess, int r, int c, int move, int[] xMoves, int[] yMoves) {
        if (move == chess.length * chess.length) {
            return true;
        }
        for (int i = 0; i < xMoves.length; i++) {
            int nextX = r + xMoves[i];
            int nextY = c + yMoves[i];
            if (isValidMove(chess, nextX, nextY)) {
                chess[nextX][nextY] = move;
                if (solveKnightTour(chess, nextX, nextY, move + 1, xMoves, yMoves)) {
                    return true;
                }
                chess[nextX][nextY] = 0;
            }
        }
        return false;
    }


    static void solveKnightTourAll(int[][] chess, int r, int c, int move, int[] xMoves, int[] yMoves) {
        if (move == chess.length * chess.length) {
            chess[r][c]=move;
            displayBoard(chess);
            chess[r][c]=0;
            System.out.println("----------------------------");
            return;
        }
        for (int i = 0; i < xMoves.length; i++) {
            int nextX = r + xMoves[i];
            int nextY = c + yMoves[i];
            if (isValidMove(chess, nextX, nextY)) {
                chess[nextX][nextY] = move;
                solveKnightTourAll(chess, nextX, nextY, move + 1, xMoves, yMoves);
                chess[nextX][nextY] = 0;
            }
        }
    }

    static boolean isValidMove(int[][] chess, int r, int c) {
        return (r < 0 || r >= chess.length || c < 0 || c >= chess.length || chess[r][c] > 0) ? false : true;
    }

    static void displayBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
