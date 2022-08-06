package bit.manipulation;

public class BitCount2 {
    public static void main(String[] args) {

        System.out.println(firstSetBit(1));
        System.out.println(firstSetBit(2));
        System.out.println(firstSetBit(3));
        System.out.println(firstSetBit(4));
        System.out.println(firstSetBit(5));

       // System.out.println(setBitCount(4));
//        System.out.println(setBitCount(5));
//
//        System.out.println(Integer.toBinaryString(4));
//        System.out.println(Integer.toBinaryString(-4));
//        System.out.println(Integer.toBinaryString(4 &-4));

    }

    static int firstSetBit(int x){
        return (x& -x);
    }

    static int setBitCount(int n) {
        int count = 0;
        while (n != 0) {
            int rsbm = n & -n;
            n = n - rsbm;
            System.out.println(n);
            count++;
        }
        return count;
    }


}
