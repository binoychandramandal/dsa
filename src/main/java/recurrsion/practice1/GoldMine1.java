package recurrsion.practice1;

import java.util.ArrayList;
import java.util.List;

public class GoldMine1 {
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

        System.out.println(maxGold(a));
        System.out.println(maxGold(b));
    }

    static int maxGold(int[][] a){
        int max= Integer.MIN_VALUE;
        boolean[][] v=new boolean[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if(a[i][j]!=0 && v[i][j]==false){
                    List<Integer> bag=new ArrayList<>();
                    solution(a,i,j,bag,v);
                    int sum=bag.stream().mapToInt(x->x).sum();
                    if(sum>max)
                        max=sum;
                }
            }
        }
        return max;
    }

    private static void solution(int[][] a, int i, int j, List<Integer> bag, boolean[][] v) {
        if(i<0 || j<0 || i>=a.length || j>=a[i].length || a[i][j]==0 || v[i][j]==true){
            return;
        }
        bag.add(a[i][j]);
        v[i][j]=true;
        solution(a, i-1, j, bag, v);
        solution(a, i+1, j, bag, v);
        solution(a, i, j-1, bag, v);
        solution(a, i, j+1, bag, v);

    }


}
