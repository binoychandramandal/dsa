package bit.manipulation;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TwoUniqueElement {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getUniqueElement(new int[]{1,1,2,2,3,4})));
    }

    /**
     * Find two unique element from array which other all element repeats twice except this two
     *
     * @param a which contains duplicates as well as unique element
     * @return two element which present once
     */
    public static int[] getUniqueElement(int[] a) {
        int xor = 0;
        for (int i : a) {
            xor ^= i;
        }
        //int pos = BitPosition.countFirstLSB(xor);
        int pos=xor&-xor;
        int set = 0;
        int unset = 0;
        for (int i : a) {
            if (BitPosition.isSet(i, pos)) {
                set ^= i;
            } else {
                unset ^= i;
            }
        }
        return new int[]{set, unset};
    }
}
