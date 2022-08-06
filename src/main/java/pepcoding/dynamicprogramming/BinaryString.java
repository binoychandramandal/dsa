package pepcoding.dynamicprogramming;

public class BinaryString {
    public static void main(String[] args) {
        System.out.println(countBinaryString(6));
        System.out.println(countBinaryStringOtherWay(6));
    }


    static int countBinaryString(int n) {
        int[] dp0 = new int[n + 1];
        int[] dp1 = new int[n + 1];
        dp0[1] = 1;
        dp1[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp1[i] = dp1[i-1]+dp0[i-1];
            dp0[i] = dp1[i-1];
        }
        return dp0[n] + dp1[n];
    }

    static int countBinaryStringOtherWay(int n) {

       int oldZeroCount=1;
       int oldOneCount=1;
        for (int i = 2; i <= n; i++) {
            int nwZeroCount =oldOneCount;
            int nwOneCount =oldZeroCount+oldOneCount;
            oldOneCount=nwOneCount;
            oldZeroCount=nwZeroCount;
        }
        return oldOneCount+oldZeroCount;
    }
}
