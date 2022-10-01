package tuf.array;

public class NextLexigographicallyGreater {
    public static void main(String[] args) {
        int[][] m = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        print(m);
        rotate(m);
        System.out.println();
        print(m);

    }

    static void print(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void rotate(int[][] m) {
        int r = m.length;
        int c = m[0].length;
        //transpose
        for (int i = 0; i < r; i++) {
            for (int j = 0; j <= i; j++) {
                swap(m, i, j, j, i);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < r / 2; j++) {
                swap(m, i, j, i,r-j-1);
            }
        }
    }

    static void swap(int[][] m, int r, int c, int r1, int c1) {
        int temp = m[r][c];
        m[r][c] = m[r1][c1];
        m[r1][c1] = temp;
    }
}
