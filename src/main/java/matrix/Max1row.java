package matrix;

public class Max1row {
    public static void main(String[] args) {
        int a[][] = new int[][]{
                {0, 0, 1, 1},
                {0, 0, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1}
        };

        System.out.println(solve(a));

    }

    static public int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int i = 0;
        int j = m - 1;
        int max = 0;
        int row = 0;
        while (i < m && j >= 0) {
            if (A[i][j] == 1) {
                j--;
            } else {
                int c = m - j - 1;
                if (max < c) {
                    row = i;
                    max = c;
                }
                i++;
            }
        }
        if(A[A.length-1][0]==1){
            int c = m - j;
            if (max < c) {
                row = i;
                max = c;
            }
        }
        return row;
    }
}
