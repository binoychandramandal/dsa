package bit.manipulation;

public class BitPosition {
    public static void main(String[] args) {
        System.out.println(isSet(10, 1));
        System.out.println(isSetLeftShift(10, 1));
        System.out.println(countSetBit(11));
        System.out.println(countSetBitUsingBitPositionCount(11));
        System.out.println(countFirstLSB(10));
    }

    /**
     * Check specified position is set or not using right shift
     * This one is better because overflow will not happened
     *
     * @param n        integer number
     * @param position bit position
     * @return true if specified bit is set
     */
    public static boolean isSet(int n, int position) {
        return ((n >> position - 1) & 1) == 1 ? true : false;
    }

    /**
     * Check specified position is set or not using left shift
     *
     * @param n        integer number
     * @param position bit position
     * @return true if specified bit is set
     */
    public static boolean isSetLeftShift(int n, int position) {
        return ((1 << position - 1) & n) == 0 ? false : true;
    }

    /**
     * Count all set bit in specified integer number
     *
     * @param n integer number
     * @return count of set bit
     */
    public static int countSetBit(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    /**
     * Count all set bit in specified integer number
     * This is using bit position coint.
     *
     * @param n integer number
     * @return count of set bit
     */
    public static int countSetBitUsingBitPositionCount(int n) {
        int count = 0;
        for (int i = 0; i < 30; i++) {
            if (isSet(n, i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Get first set LBS bit.
     *
     * @param n integer number
     * @return count of set bit
     */
    public static int countFirstLSB(int n) {
        int count = -1;
        while (n > 0) {
            count++;
            if ((n & 1) == 1) {
                return count;
            }
            n = n >> 1;
        }
        return count;
    }


}
