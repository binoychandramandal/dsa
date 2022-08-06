package recurrsion.practise;

public class Sudoku {
    public static void main(String[] args) {
        int n = 9;
        int[][] board = new int[][]{{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        solveSudoku(board, 0, 0);

    }

    static void solveSudoku(int[][] board, int i, int j) {
        if(i==board.length){
            display(board);
            return;
        }
        int nextI = 0;
        int nextJ = 0;
        if (j == board[0].length - 1) {
            nextI = i + 1;
            nextJ = 0;
        } else {
            nextI = i;
            nextJ = j + 1;
        }

        if (board[i][j] != 0) {
            solveSudoku(board, nextI, nextJ);
        } else {
            for (int po = 1; po <= 9; po++) {
                if (isValid(board, i, j, po) == true) {
                    board[i][j] = po;
                    solveSudoku(board, nextI, nextJ);
                    board[i][j] = 0;
                }
            }
        }

    }

    private static boolean isValid(int[][] board, int row, int col, int val) {
        //row check
        for (int j = 0; j < board[0].length; j++) {
            if (board[row][j] == val) {
                return false;
            }
        }
        //column check
        for (int i = 0; i < board[0].length; i++) {
            if (board[i][col] == val) {
                return false;
            }
        }

        //sub matrix starting corner
        int smi = row/3*3;
        int smj = col/3*3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[smi+i][smj+j] == val) {
                    return false;
                }
            }
        }


        return true;
    }


    static void display(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


}
