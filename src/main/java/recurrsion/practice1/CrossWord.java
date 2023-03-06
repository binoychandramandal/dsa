package recurrsion.practice1;

public class CrossWord {
    public static void main(String[] args) {
        char[][] a = {
                {'+', '-', '+'},
                {'-', '-', '-'},
                {'+', '-', '+'},
        };

        printCrossWord(a,new String[]{"AND","ANT"},0);
    }

    static void printCrossWord(char[][] board, String[] words, int index) {
        if (index == words.length) {
            print(board);
            System.out.println("-----------------");
            return;
        }

        String word = words[index];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '-' || board[i][j] == word.charAt(0)) {
                    if (canPlaceHorizontally(board, i, j, word)) {
                        boolean[] wePlaced = placeHorizontally(board, i, j, word);
                        printCrossWord(board, words, index + 1);
                        unPlaceHorizontally(board, i, j, wePlaced);
                    }
                    if (canPlaceVertically(board, i, j, word)) {
                        boolean[] wePlaced = placeVertically(board, i, j, word);
                        printCrossWord(board, words, index + 1);
                        unPlaceVertically(board, i, j, wePlaced);
                    }
                }
            }
        }
    }

    private static void unPlaceHorizontally(char[][] board, int i, int j, boolean[] wePlaced) {
        for (int k = 0; k < wePlaced.length; k++) {
            if(wePlaced[k]==true){
                board[i][j+k] = '-';
            }
        }
    }

    private static void unPlaceVertically(char[][] board, int i, int j, boolean[] wePlaced) {
        for (int k = 0; k < wePlaced.length; k++) {
            if(wePlaced[k]==true){
                board[i+k][j] = '-';
            }
        }
    }

    private static boolean[] placeHorizontally(char[][] board, int i, int j, String word) {
        boolean[] wePlaced = new boolean[word.length()];
        for (int k = 0; k < word.length(); k++) {
            if (board[i][j + k] == '-') {
                board[i][j + k] = word.charAt(k);
                wePlaced[k] = true;
            }
        }
        return wePlaced;
    }

    private static boolean[] placeVertically(char[][] board, int i, int j, String word) {
        boolean[] wePlaced = new boolean[word.length()];
        for (int k = 0; k < word.length(); k++) {
            if (board[i+k][j] == '-') {
                board[i+k][j] = word.charAt(k);
                wePlaced[k] = true;
            }
        }
        return wePlaced;
    }

    private static boolean canPlaceHorizontally(char[][] board, int i, int j, String word) {
        if(j - 1 >= 0 && board[i][j - 1] != '+') return false;
        if (j + word.length() < board[0].length && board[i][j + word.length()] != '+') {
            return false;
        }
        for (int k = 0; k < word.length(); k++) {
            if (j + k >= board[0].length) {
                return false;
            }
            if( board[i][j + k] == '-' || board[i][j + k] == word.charAt(k)){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    private static boolean canPlaceVertically(char[][] board, int i, int j, String word) {
        if(i - 1 >= 0 && board[i - 1][j] != '+'){
            return false;
        }
        if ( i + word.length() < board.length && board[i + word.length()][j] != '+') {
            return false;
        }
        for (int k = 0; k < word.length(); k++) {
            if (i + k >= board.length){
                return false;
            }
            if( board[i + k][j] == '-' || board[i + k][j] == word.charAt(k)) {
               continue;
            }else{
                return false;
            }
        }
        return true;
    }

    static void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
