package pepcoding.backtracking.practice;

public class CrossWord {

    public static void main(String[] args) {

        char[][] board = new char[][]{
                {'+', '-', '+'},
                {'-', '-', '-'},
                {'+', '-', '+'},
        };

        char[][] board_10_by_10 = new char[][]{

               {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},

                {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},

                {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},

                {'+', '-', '-', '-', '-', '-', '+', '+', '+', '+'},
                 {'+', '-', '+', '+', '+', '-', '+', '+', '+', '+'},

                {'+', '-', '+', '+', '+', '-', '+', '+', '+', '+'},

                {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},

                {'+', '+', '-', '-', '-', '-', '-', '-', '+', '+'},

                {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},

               {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},
        };

        // display(board);

       // sol(board, new String[]{"AND", "ANT"}, 0);
        sol(board_10_by_10, new String[]{"DELHI", "ICELAND","ANKARA","LONDON"}, 0);

    }




    static void sol(char[][] board, String[] words, int vidx) {
        if (vidx == words.length) {
            display(board);
            return;
        }
        String word = words[vidx];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '-' || board[i][j] == word.charAt(0)) {
                    if (canPlaceHorizontally(board, i, j, word)) {
                       boolean[] wePlaced =  placeHorizontally(board,i,j,word);
                        sol(board, words, vidx + 1);
                        unPlaceHorizontally(board,i,j,wePlaced);
                    }

                    if (canPlaceVertically(board, i, j, word)) {
                        boolean[] wePlaced=placeVertically(board,i,j,word);
                        sol(board, words, vidx + 1);
                        unPlaceVertically(board,i,j,wePlaced);
                    }
                }
            }
        }
    }

    private static void unPlaceVertically(char[][] board, int i, int j, boolean[] wePlaced) {
        for (int k = 0; k < wePlaced.length; k++) {
            if(wePlaced[k]){
                board[i+k][j]='-';
            }
        }
    }

    private static boolean[] placeVertically(char[][] board, int i, int j, String word) {
        boolean[] wePlaced =new boolean[word.length()];
        for (int k = 0; k < word.length(); k++) {
            if(board[i+k][j]=='-'){
                board[i+k][j]=word.charAt(k);
                wePlaced[k]=true;
            }
        }
        return wePlaced;
    }

    private static void unPlaceHorizontally(char[][] board, int i, int j, boolean[] wePlaced) {
        for (int k = 0; k < wePlaced.length; k++) {
            if(wePlaced[k]){
                board[i][j+k]='-';
            }
        }
    }

    private static boolean[] placeHorizontally(char[][] board, int i, int j, String word) {
        boolean[] wePlaced =new boolean[word.length()];
        for (int k = 0; k < word.length(); k++) {
            if(board[i][j+k]=='-'){
                board[i][j+k]=word.charAt(k);
                wePlaced[k]=true;
            }
        }
        return wePlaced;
    }

    private static boolean canPlaceVertically(char[][] board, int i, int j, String word) {
        //Vertically left side should not be anything if there then it must be +
        if (i - 1 >= 0 && board[i-1][j] != '+') {
            return false;
        } else if (i + word.length() < board.length && board[i+word.length()][j] != '+') { //
            return false;
        }
        for (int k = 0; k < word.length(); k++) {
            if (i + k >= board.length) {
                return false;
            }
            if (board[i+k][j] == '-' || board[i+k][j] == word.charAt(k)) {
                continue;
            } else
                return false;
        }

        return true;
    }

    private static boolean canPlaceHorizontally(char[][] board, int i, int j, String word) {
        //Horizontally left side should not be anything if there then it must be +
        if (j - 1 >= 0 && board[i][j - 1] != '+') {
            return false;
        } else if (j + word.length() < board.length && board[i][j + word.length()] != '+') { //
            return false;
        }
        for (int k = 0; k < word.length(); k++) {
            if (j + k >= board.length) {
                return false;
            }
            if (board[i][j + k] == '-' || board[i][j + k] == word.charAt(k)) {
                continue;
            } else
                return false;
        }

        return true;
    }

    static void display(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
