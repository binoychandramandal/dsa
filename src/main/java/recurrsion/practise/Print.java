package recurrsion.practise;

public class Print {
    public static void main(String[] args) {

        print1ToN(5);
        System.out.println();
        print1ToNReverseOrder(5);
        System.out.println();
        System.out.println(sum(5));
        System.out.println(sum(2, 5));
        pintIncreasingDecreasing(5);
    }

    /**
     * print 1 to n using recursion
     *
     * @param n
     */
    static void print1ToN(int n) {
        if (n == 0) {
            return;
        }
        print1ToN(n - 1);

        System.out.print(n + " ");
    }

    /**
     * print 1 to n in reverse order using recursion
     *
     * @param n
     */
    static void print1ToNReverseOrder(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        print1ToNReverseOrder(n - 1);
    }

    /**
     * print sum from 1 to n using recursion
     *
     * @param n
     */
    static int sum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sum(n - 1);
    }

    /**
     * print sum from 1 to n  in range using recursion
     *
     * @param s start
     * @param e end
     */
    static int sum(int s, int e) {
        if (s == e) {
            return s;
        }
        return s + sum(s + 1, e);
    }

    /**
     * Print 1 to N and N to 1 in single recursion
     * @param n
     */

    static void pintIncreasingDecreasing(int n) {
        if (n == 0)
            return;
        System.out.println(n);
        pintIncreasingDecreasing(n - 1);
        if(n>4)
        System.out.println(n);
    }

}
