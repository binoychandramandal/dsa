package recurrsion.practice1;

import java.util.ArrayList;
import java.util.List;

public class GoldMine {
    public static void main(String[] args) {
        int[][] a = {
                {10, 0, 100, 200, 0, 8, 0},
                {20, 0, 0, 0, 0, 6, 0},
                {30, 0, 0, 9, 12, 3, 4},
                {40, 0, 2, 5, 8, 3, 11},
                {0, 0, 0, 0, 0, 9, 0},
                {5, 6, 7, 0, 7, 4, 2},
                {8, 9, 10, 0, 1, 10, 8},
        };

        int[][] b ={
                {0,6,0},
                {5,8,7},
                {0,9,0},
        };

        System.out.println(goldMine(a));
        System.out.println(goldMine(b));
    }

    static int goldMine(int[][] a) {
        boolean[][] v = new boolean[a.length][a[0].length];
        Integer max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != 0 && v[i][j] == false) {
                    List<Integer> bag = new ArrayList<>();
                    travelAndCollect(i, j, a, v, bag);
                    int sum = bag.stream().mapToInt(x -> x).sum();
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
        }
        return max;
    }

    private static void travelAndCollect(int i, int j, int[][] a, boolean[][] v, List<Integer> bag) {
        if (i < 0 || j < 0 || i >= a.length || j >= a[0].length || v[i][j] || a[i][j] == 0) {
            return;
        }
        v[i][j] = true;
        bag.add(a[i][j]);
        travelAndCollect(i - 1, j, a, v, bag);
        travelAndCollect(i + 1, j, a, v, bag);
        travelAndCollect(i, j - 1, a, v, bag);
        travelAndCollect(i, j + 1, a, v, bag);
    }
}
