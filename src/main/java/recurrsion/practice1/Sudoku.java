package recurrsion.practice1;

public class Sudoku {
    public static void main(String[] args) {
        int[][] a = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        sudoku(a);
    }

    static void sudoku(int[][] a) {
        solution(a, 0, 0);
    }

    static void solution(int[][] a, int i, int j) {
        if (i == a.length) {
            print(a);
            return;
        }

        int nextI = 0;
        int nextJ = 0;
        if (j == a[0].length-1) {
            nextI = i + 1;
            nextJ = 0;
        } else {
            nextI = i;
            nextJ = j + 1;
        }
        if (a[i][j] != 0) {
            solution(a, nextI, nextJ);
        } else {
            for (int k = 1; k <=9; k++) {
                if (isValid(a, i, j, k)) {
                    a[i][j] = k;
                    solution(a, nextI, nextJ);
                    a[i][j] = 0;
                }
            }
        }
    }

    private static boolean isValid(int[][] a, int nextI, int nextJ, int k) {
        // row
        for (int i = 0; i < a[0].length; i++) {
            if (a[nextI][i] == k) {
                return false;
            }
        }
        // col
        for (int i = 0; i < a[0].length; i++) {
            if (a[i][nextJ] == k) {
                return false;
            }
        }

        int smi = 3 * (nextI / 3);
        int smj = 3 * (nextJ / 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a[smi + i][smj + j] == k) {
                    return false;
                }
            }
        }

        return true;
    }

    static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
