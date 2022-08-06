package graph.pepcoding;

import graph.tuf.Edge;
import graph.tuf.Graph;

import java.util.ArrayList;
import java.util.List;

public class CountIsland {
    public static void main(String[] args) {
        int[][] a=new int[][]{
                {0,0,1,1,1,1,1,1},
                {0,0,1,1,1,1,1,1},
                {1,1,1,1,0,1,1,0},
                {1,1,0,0,0,1,1,0},
                {1,1,1,1,0,1,1,0},
                {1,1,1,1,0,1,1,0},
                {1,1,1,1,1,1,1,0},
                {1,1,1,1,1,1,1,0},
        };

        System.out.println(countIsland(a));

        a=new int[][]{
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,0,1,1,0,1,1,0},
                {1,1,0,0,0,1,1,0},
                {1,1,1,1,0,1,1,0},
                {1,1,1,1,0,1,1,0},
                {1,1,1,1,1,1,1,0},
                {0,1,1,1,1,1,1,0},
        };

        System.out.println(countIsland(a));

    }


    static int countIsland(int[][] g) {
        boolean[][] v = new boolean[g.length][g[0].length];
        int count=0;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                if (v[i][j] == false && g[i][j] == 0) {
                    drawTree(g, i, j, v);
                    count++;
                }
            }
        }
        return count;
    }

    static void drawTree(int[][] g, int i, int j, boolean[][] v) {
        if (i < 0 || j < 0 || i >= g.length || j >= g[i].length || g[i][j] == 1 || v[i][j] == true) {
            return;
        }
        v[i][j] = true;
        drawTree(g, i - 1, j, v);
        drawTree(g, i, j + 1, v);
        drawTree(g, i + 1, j, v);
        drawTree(g, i, j - 1, v);
    }
}
