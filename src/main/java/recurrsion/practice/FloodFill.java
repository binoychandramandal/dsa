package recurrsion.practice;

public class FloodFill {
    public static void main(String[] args) {
        int[][]  maze ={
                {0,0,0,0},
                {1,0,1,0},
                {1,0,0,0},
        };
        floodFill(maze,0,0,new boolean[maze.length][maze[0].length],"");
    }

    static void floodFill(int[][] maze, int r, int c, boolean[][] visited, String ans) {
        if(r<0 || c<0||r>=maze.length || c>=maze[0].length || maze[r][c]==1 || visited[r][c]==true){
            return;
        }
        if(r== maze.length-1 && c==maze[0].length-1){
            System.out.println(ans);
            return;
        }

        visited[r][c] = true;
        floodFill(maze, r - 1, c , visited, ans + "t");
        floodFill(maze, r, c - 1, visited, ans + "l");
        floodFill(maze, r + 1, c, visited, ans + "d");
        floodFill(maze, r, c + 1, visited, ans + "r");
        visited[r][c] = false;
    }
}
