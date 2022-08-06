package modulaer;

import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        System.out.println(5^3);
        //System.out.println(new Solution().solve(new int[]{1,2,3,4,5},2));
        //System.out.println(new Solution().solve(new int[]{93, 9, 46, 79, 56, 24, 10, 26, 9, 93, 31, 93, 75, 7, 4, 80, 19, 67, 49, 84, 62, 100, 17, 40, 35, 84, 14, 81, 99, 31, 100, 66, 70, 2, 11, 84, 60, 89, 13, 57, 47, 60, 59, 60, 42, 67, 89, 29, 85, 83, 42, 47, 66, 80, 88, 85, 83, 82, 16, 23, 21, 55, 26, 2, 21, 92, 85, 26, 46, 3, 7, 95, 50, 22, 84, 52, 57, 44, 4, 23, 25, 55, 41, 49},37));
    }

    public int solve(int[] A, int B) {
        int modular = (int) Math.pow(10, 9) + 7;
        int[] a = new int[B];
        for (int i = 0; i < A.length; i++) {
            a[A[i] % B]++;
            //m.put(A[i],m.getOrDefault(A[i],0)+1);
        }
        int res = combination(a[0]) % modular;
        int i = 1;
        int j = B - 1;
        while (i < j) {
            res += (a[i] * a[j]) % modular;
            i++;
            j--;
        }
        if (B==2 || B % 2 != 0) {
            res += (combination(a[B / 2]) % modular);
        }
        return res;
    }

    private int combination(int n) {
        return (n * (n - 1))/2;
    }
}
