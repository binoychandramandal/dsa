package recurrsion.practice1;

public class Sudoku1 {
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
        solve(a,0,0);
    }

    static void solve(int[][] a, int r, int c) {
        if (r == a.length) {
            display(a);
            return;
        }

        int ni = 0;
        int nj = 0;
        if (c == a[0].length - 1) {
            ni = r + 1;
            nj = 0;
        } else {
            ni = r;
            nj = c + 1;
        }

        if (a[r][c] != 0) {
            solve(a, ni, nj);
        } else {
            for (int i = 1; i < 10; i++) {
                if (a[r][c] == 0 && isValid(a, r, c, i)) {
                    a[r][c] = i;
                    solve(a, ni, nj);
                    a[r][c] = 0;
                }
            }
        }
    }

    private static boolean isValid(int[][] a, int r, int c, int val) {

        for (int i = 0; i < a.length; i++) {
            if (a[i][c] == val)
                return false;
        }

        for (int i = 0; i < a[0].length; i++) {
            if (a[r][i] == val)
                return false;
        }

        int smi = (r / 3) * 3;
        int smj = (c / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a[smi + i][smj + j] == val)
                    return false;
            }
        }
        return true;

    }


    static void display(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

}
