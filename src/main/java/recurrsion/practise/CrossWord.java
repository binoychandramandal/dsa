package recurrsion.practise;

public class CrossWord {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'+', '+', '+', '+', '+', '+', '+', '+', '+', '-'},
                {'-', '+', '+', '+', '+', '+', '+', '+', '+', '-'},
                {'-', '-', '-', '-', '-', '-', '-', '+', '+', '-'},
                {'-', '+', '+', '+', '+', '+', '+', '+', '+', '-'},
                {'-', '+', '+', '+', '+', '+', '+', '+', '+', '-'},
                {'-', '+', '+', '+', '+', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-', '+', '+', '+', '-'},
                {'-', '+', '+', '+', '+', '+', '+', '+', '+', '-'},
                {'+', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
                {'+', '+', '+', '+', '+', '+', '+', '+', '+', '+'}
        };
        String[] words =new String[]{"PUNJAB","JHARKHAND","MIZORAM","MUMBAI"};
        solution(board,words,0);

    }

    static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void solution(char[][] arr, String[] words, int vidx) {
        if (vidx == arr.length) {
            print(arr);
            return;
        }
        String word = words[vidx];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == '-' || arr[i][i] == word.charAt(0)) {
                    if (canPlaceWordHorizantally(arr, word, i, j)) {
                        boolean[] weplaced = placeWordHorizontally(arr, word, i, j);
                        solution(arr, words, vidx + 1);
                        unplaceWordHorizontally(arr, weplaced, i, j);
                    }
                    if (canPlaceWordVertically(arr, word, i, j)) {
                        boolean[] weplaced = placeWordVertically(arr, word, i, j);
                        solution(arr, words, vidx + 1);
                        unplaceWordVertically(arr, weplaced, i, j);
                    }
                }
            }
        }
    }

    private static void unplaceWordVertically(char[][] arr, boolean[] weplaced, int i, int j) {
        for (int ii = 0; ii < weplaced.length; ii++) {
            if (weplaced[ii] == true) {
                arr[i + ii][j] = '-';
            }
        }
    }

    private static boolean[] placeWordVertically(char[][] arr, String word, int i, int j) {
        boolean[] weplaced = new boolean[word.length()];
        for (int ii = 0; ii < word.length(); ii++) {
            if (arr[i + ii][j] == '-') {
                arr[i + ii][j] = word.charAt(ii);
                weplaced[ii] = true;
            }
        }
        return weplaced;
    }

    private static void unplaceWordHorizontally(char[][] arr, boolean[] weplaced, int i, int j) {
        for (int jj = 0; jj < weplaced.length; jj++) {
            if (weplaced[jj] == true) {
                arr[i][j + jj] = '-';
            }
        }
    }

    private static boolean[] placeWordHorizontally(char[][] arr, String word, int i, int j) {
        boolean[] weplaced = new boolean[word.length()];
        for (int jj = 0; jj < word.length(); jj++) {
            if (arr[i][j + jj] == '-') {
                arr[i][j + jj] = word.charAt(jj);
                weplaced[jj] = true;
            }
        }
        return weplaced;
    }

    private static boolean canPlaceWordHorizantally(char[][] arr, String word, int i, int j) {
        if (j - 1 >= 0 && arr[i][j - 1] != '+') {
            return false;
        } else if (j + word.length() < arr[0].length && arr[i][j + word.length()] != '+') {
            return false;
        }
        for (int jj = 0; jj < word.length(); jj++) {
            if (j + jj >= arr[0].length) {
                return false;
            }
            if (arr[i][j + jj] == '-' || arr[i][j + jj] == word.charAt(jj)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean canPlaceWordVertically(char[][] arr, String word, int i, int j) {
        if (i - 1 >= 0 && arr[i - 1][j] != '+') {
            return false;
        } else if (i + word.length() < arr.length && arr[i + word.length()][j] != '+') {
            return false;
        }
        for (int ii = 0; ii < word.length(); ii++) {
            if (i + ii >= arr.length) {
                return false;
            }
            if (arr[i + ii][j] == '-' || arr[i + ii][j] == word.charAt(ii)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
