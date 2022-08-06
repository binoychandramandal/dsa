package binary;

public class Sqrt {
    public static void main(String[] args) {
        System.out.println(sqrt(Integer.MAX_VALUE));
        System.out.println(46340*46340);
    }


    static int sqrt(int n) {
        int s = 0;
        int e = n;
        int ans = 0;
        while (s <= e) {
            long mid = s + (e - s) / 2;
            if (mid * mid == n) {
                return (int)mid;
            } else if (mid * mid < n) {
                s = (int)mid + 1;
                ans = (int)mid;
            } else {
                e = (int)mid - 1;
            }
        }
        return ans;
    }
}
