package pepcoding.dynamicprogramming;

public class MazeMinimumCostPath {
    public static void main(String[] args) {

        int[][] maze = new int[][]{
                {1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 2, 1},
                {0, 1, 1, 1, 2, 1},
                {0, 1, 1, 0, 0, 1}
        };
        int[][] maze1 = new int[][]{
                {0, 0, 0, 0, 0, 1},
                {2, 0, 0, 1, 0, 1},
                {3, 0, 0, 1, 0, 0},
                {4, 0, 0, 10, 20, 0}
        };
        System.out.println(findMinCostPathInMaze(maze));
        System.out.println(findMinCostPathInMaze(maze1));
    }

    /**
     * in one move either go horizontal or vertical onc cell only.
     * Find all the path and return which takes less amount
     *
     * @param maze
     * @return
     */
    static int findMinCostPathInMaze(int[][] maze) {
        int[][] dp = new int[maze.length][maze[0].length];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                //last cell maze[n][m]
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = maze[i][j];
                } else if (i == dp.length - 1) { // last row
                    dp[i][j] = dp[i][j + 1] + maze[i][j];
                } else if (dp[0].length - 1 == j) { //last column
                    dp[i][j] = dp[i + 1][j] + maze[i][j];
                } else { // other row and col
                    dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) + maze[i][j];
                }
            }
        }
        return dp[0][0];
    }

}
