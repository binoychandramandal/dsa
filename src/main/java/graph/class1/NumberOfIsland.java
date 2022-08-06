package graph.class1;

public class NumberOfIsland {
    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1, 1, 0, 0, 1},
                {0, 1, 0, 1, 0},
                {1, 0, 0, 1, 1},
                {1, 1, 0, 0, 0},
                {1, 0, 1, 1, 1}
        };
       // System.out.println(countIsland4Way(mat));
        System.out.println(countIsland8Way(mat));
    }

    static int countIsland4Way(int[][] mat) {
        int countOfIsland = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    dfs(mat, i, j);
                    countOfIsland++;
                }
            }
        }
        return countOfIsland;
    }

    static void dfs(int[][] mat, int i, int j) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] == 0) {
            return;
        }
        mat[i][j] = 0;
        dfs(mat, i - 1, j);
        dfs(mat, i, j + 1);
        dfs(mat, i + 1, j);
        dfs(mat, i, j - 1);
    }

    static int countIsland8Way(int[][] mat) {
        int countOfIsland = 0;
        int[] x=new int[]{-1,-1,0,1,1,1,0,-1};
        int[] y=new int[]{0,1,1,1,0,-1,-1,-1};
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] ==1) {
                    dfs(mat, i, j,x,y);
                    countOfIsland++;
                }
            }
        }
        return countOfIsland;
    }

    static void dfs(int[][] mat, int i, int j,int[]x,int[] y) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] == 0) {
            return;
        }
        mat[i][j] = 0;
        for (int k = 0; k < x.length; k++) {
            dfs(mat,i+x[k],j+y[k],x,y);
        }
    }
}
