package recurrsion.practice1;

public class CrossWord1 {
    public static void main(String[] args) {
        char[][] a = {
                {'+', '-', '+'},
                {'-', '-', '-'},
                {'+', '-', '+'},
        };
        solve(a,new String[]{"ANT","AND"},0);
    }

    static void solve(char[][] board, String[] words, int index) {
        if (index == words.length) {
            displayBoard(board);
            System.out.println("----------------------");
            return;
        }
        String word = words[index];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
               if(board[i][j]=='-' || board[i][j]==word.charAt(0)){
                   if (canPlaceHorizontally(board, i, j, word)) {
                       boolean[] wePlaced = placeHorizontally(board, i, j, word);
                       solve(board, words, index + 1);
                       unplaceHorizontally(board, i, j, wePlaced);
                   }

                   if (canPlaceVertically(board, i, j, word)) {
                       boolean[] wePlaced = placeVertically(board, i, j, word);
                       solve(board, words, index + 1);
                       unplaceVertically(board, i, j, wePlaced);
                   }
               }
            }
        }
    }

    private static void unplaceVertically(char[][] board, int i, int j, boolean[] wePlaced) {
        for (int k = 0; k < wePlaced.length; k++) {
            if(wePlaced[k]){
                board[i+k][j]='-';
            }
        }
    }

    private static boolean[] placeVertically(char[][] board, int i, int j, String word) {
        boolean[] wePlaced = new boolean[word.length()];
        for (int k = 0; k < word.length(); k++) {
            if (board[i+k][j] == '-') {
                wePlaced[k] = true;
                board[i+k][j ] = word.charAt(k);
            }
        }
        return wePlaced;
    }


    private static void unplaceHorizontally(char[][] board, int i, int j, boolean[] wePlaced) {
        for (int k = 0; k < wePlaced.length; k++) {
            if(wePlaced[k]){
                board[i][j+k]='-';
            }
        }
    }

    private static boolean[] placeHorizontally(char[][] board, int i, int j, String word) {
        boolean[] wePlaced = new boolean[word.length()];
        for (int k = 0; k < word.length(); k++) {
            if (board[i][j + k] == '-') {
                wePlaced[k] = true;
                board[i][j + k] = word.charAt(k);
            }
        }
        return wePlaced;
    }

    private static boolean canPlaceHorizontally(char[][] board, int i, int j, String word) {
        if (j - 1 >= 0 && board[i][j - 1] != '+') {
            return false;
        }
        if (j + word.length() < board[0].length && board[i][j + word.length()] != '+') {
            return false;
        }

        for (int k = 0; k < word.length(); k++) {
            if (j + k >= board[0].length)
                return false;
            if (board[i][j + k] == '-' || board[i][j + k] == word.charAt(k)) {
                continue;
            } else {
                return false;
            }
        }

        return true;

    }
    private static boolean canPlaceVertically(char[][] board, int i, int j, String word) {
        if (i - 1 >= 0 && board[i-1][j] != '+') {
            return false;
        }
        if (i + word.length() < board[0].length && board[i+word.length()][j] != '+') {
            return false;
        }
        for (int k = 0; k < word.length(); k++) {
            if (i + k >= board[0].length)
                return false;
            if (board[i+k][j] == '-' || board[i+k][j] == word.charAt(k)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    static void displayBoard(char[][] c) {
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }

}
