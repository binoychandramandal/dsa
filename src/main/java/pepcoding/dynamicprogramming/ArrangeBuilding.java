package pepcoding.dynamicprogramming;

public class ArrangeBuilding {
    public static void main(String[] args) {
        System.out.println(getCount(45));
        System.out.println(getCount(38));
    }

    static long getCount(long n) {
        long oldBuilding = 1;
        long oldSpace = 1;
        for (int i = 2; i <= n; i++) {
            long nb = oldSpace;
            long ns = oldSpace + oldBuilding;
            oldSpace = ns;
            oldBuilding = nb;
        }
        long total = oldSpace + oldBuilding;
        total = total * total;

        return total;
    }
}
