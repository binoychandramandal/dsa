package sorting;

import java.util.LinkedList;

public class TT {
    public static void main(String[] args) {
        System.out.println(solve1(83557));
    }
        public static int solve(int A) {
            int sum=solve1(A);
            while(sum>=10){
                sum=solve1(sum);
            }
            return sum==1?1:0;
        }

        public static int solve1(int A) {
            if(A==0){
                return 0;
            }
            return (A%10)+solve1(A/10);
        }


    }

