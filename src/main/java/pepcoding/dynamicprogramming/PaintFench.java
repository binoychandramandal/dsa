package pepcoding.dynamicprogramming;

public class PaintFench {
    public static void main(String[] args) {
        System.out.println(getFenceCount(8,3));
    }

    static long getFenceCount(int fenceCount, int k) {
        long same = k * 1;
        long diff = k * (k - 1);
        long total = same + diff;
        for (int i = 3; i <= fenceCount; i++) {
            same = diff * 1;
            diff = total * (k - 1);
            total = same + diff;
        }
        return total;
    }

}
