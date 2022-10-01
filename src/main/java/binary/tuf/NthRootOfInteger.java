package binary.tuf;

public class NthRootOfInteger {
    public static void main(String[] args) {
        System.out.println(findNthRoot(3,30));
        System.out.println(Math.pow(30,-3));
    }

    static double multiply(double m, int n) {
        double ans = 1.0;
        for (int i = 1; i <= n; i++) {
            ans *= m;
        }
        return ans;
    }

    static double findNthRoot(int n, int m) {
        double low = 1;
        double high = m;
        double eps = 1e-6;
        double ans = 0.0;
        while ((high - low )> eps) {
            System.out.println(high - low );
            double mid = (high + low) / 2;
            if (multiply(mid, n) < m) {
                low = mid;
            } else {
                high = mid;
            }
        }
        System.out.println((high - low ));
        return high;
    }
}
