package bit.manipulation;

public class BitCount1 {
    public static void main(String[] args) {
       int p= Integer.parseInt("01000000000000000000000000000000",2);
        System.out.println(p&-p);
        System.out.println(p);
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(-4));

        int x=2;
        System.out.println(x&-x);
        System.out.println(isSet(4, 2));
        System.out.println(countSetBit(4));
        System.out.println(Integer.MAX_VALUE<<31);
        printUniqueElement(new int[]{1,1,2,2,3,3,4,5});

    }

    static void printUniqueElement(int[] a){
        int x=0;
        for (int i = 0; i < a.length; i++) {
            x^=a[i];
        }
        int position=x&-x;
         int set=0;
         int unset  =0;
        for (int i = 0; i < a.length; i++) {
            if(isSet(a[i],position-1)){
                set^=a[i];
            }else{
                unset^=a[i];
            }
        }
        System.out.println(set+" -> "+unset);
    }

    static boolean isSet(int n, int position) {
        return ((n >> position) & 1) == 1 ? true : false;
    }

    static int lsbBit(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                return count++;
            }
            n >>= 1;
        }
        return count;
    }

    static int countSetBit(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }


}
