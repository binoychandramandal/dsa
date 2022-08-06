package array.subset;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Day1 {

    public static void main(String[] args) {
        System.out.println(new Day1().solve("GUGPUAGAFQBMPYAGGAAOALAELGGGAOGLGEGZ"));
        System.out.println(new Day1().solve1(new int[]{7, 18, 48}, 31));
        System.out.println(new Day1().solve2("nfqhtxeqoa"));

        System.out.println(Arrays.toString(new Day1().plusOne(new int[]{0, 3, 7, 6, 4, 0, 5, 5, 5})));
        System.out.println(Arrays.toString(new Day1().plusOne(new int[]{9, 9})));
        System.out.println(Math.max(-1, -2));
        System.out.println(new Day1().solve(new int[]{1, 2, 3, 4, 5},2));

    }

    public static int solve(int[] A, int B) {
        PriorityQueue<Integer> min=new PriorityQueue<>();
        PriorityQueue<Integer> max=new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i <A.length; i++) {
            min.offer(A[i]);
            max.offer(A[i]);
            if(min.size()>B){
                min.poll();
            }
            if(max.size()>B){
                max.poll();
            }
        }
        int bThmax =max.peek();
        int bThmin  = min.peek();
        return bThmin-bThmax;
    }

    public int[] plusOne(int[] A) {
        int[] res = new int[A.length];
        int i = A.length - 1;
        int sum = 0;
        res[i] = (A[i] + 1) % 10;
        int carry = (A[i] + 1) / 10;
        i--;
        while (i >= 0) {
            sum = A[i] + carry;
            carry = sum / 10;
            res[i] = sum % 10;
            i--;
        }
        if (carry >= 1) {
            int[] r = new int[res.length + 1];
            r[0] = carry;
            for (int l = 0; l < res.length; l++) {
                r[l + 1] = res[l];
            }
            res = r;
        }
        int count = 0;
        for (int a = 0; a < res.length; a++) {
            if (res[a] == 0) {
                count++;
            } else {
                break;
            }
        }
        if (count >= 1) {
            int[] r = new int[res.length - count];
            int c = 0;
            for (int l = count; l < res.length; l++) {
                r[c++] = res[l];
            }
            res = r;
        }
        return res;
    }

    public String solve2(String A) {

        String result = "";
        int max = Integer.MAX_VALUE;

        for (int i = 0; i < A.length(); i++) {
            for (int j = i + 1; j < A.length(); j++) {
                int distance = A.charAt(i) - A.charAt(j);
                if (distance <= max && distance >= 2) {
                    max = distance;
                    result = "" + A.charAt(i) + A.charAt(j);
                }
            }
        }

        return result;
    }

    public int solve1(int[] A, int B) {
        int i = 0;
        int j = 0;
        int sum = 0;
        while (j < A.length) {
            sum += A[j];
            if (sum < B) {
                j++;
            } else if (sum == B) {
                return 1;
            } else {
                while (sum > B && sum >= 0 && i <= j) {
                    sum -= A[i++];
                }
                if (sum == B) {
                    return 1;
                }
            }
        }

        return 0;

    }

    public int solve(String A) {

        int count = 0;
        int ans = 0;
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (c == 'A') {
                count++;
            }
            if (c == 'G') {
                ans += count;
            }
        }

        return count;

    }
}
