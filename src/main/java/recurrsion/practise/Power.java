package recurrsion.practise;

public class Power {
    public static void main(String[] args) {
        System.out.println(pow(10, 3));
        System.out.println(powHead(10, 3));
        System.out.println(pow(2, 3));
        System.out.println(powHead(2, 3));
        System.out.println(powerLogarithm(2, 3));
        System.out.println(powerLogarithm(10, 3));
        System.out.println(powerLogarithm(10, 7));
    }

    /**
     * Tail recursion
     *
     * @param x
     * @param y
     * @return
     */
    static int pow(int x, int y) {
        if (y == 0) {
            return 1;
        }
        return x * pow(x, y - 1);
    }

    static int powHead(int x, int y) {
        if (y == 0) {
            return 1;
        }
        return powHead(x, y - 1) * x;
    }

    /**
     * Power using logarithm
     * @param x
     * @param y
     * @return
     */
    static int powerLogarithm(int x, int y) {
        if (y == 0) {
            return 1;
        }
        int p = powerLogarithm(x, y / 2);
        if (y % 2 == 0) {
            return p * p;
        } else {
            return p * p * x;
        }
    }

}
