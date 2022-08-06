package dsa.level1;

public class DigitCount {
    public static void main(String[] args) {
//        System.out.println(countDigit(100));
//        System.out.println(countDigit(10));
//        System.out.println(countDigit(1));
//        System.out.println(countDigit(00));
//        System.out.println(countDigit(1000));
//        System.out.println(countDigit(250));
        printNumberLeftToRight(0000);
//        reverseANumber(253);
//        reverseANumber(100);
//        reverseANumber(101);
//        reverseANumber(203);
//        System.out.println(rotateANumber(123,1));
//        System.out.println(rotateANumber(123,2));
//        System.out.println(rotateANumber(100,2));

        System.out.println(inverse(54321));

        System.out.println(digitFrequencyInDigit(54356,5));
    }

    /**
     * Divide n by 10 until n become zero
     *
     * @param n
     * @return digit count
     */
    static int countDigit(int n) {
        if (n == 0)
            return 1;
        int digitCount = 0;
        while (n != 0) {
            n /= 10;
            digitCount++;
        }
        return digitCount;
    }


    static void printNumberLeftToRight(int n) {
        int countDigit = countDigit(n);
        int div = (int) Math.pow(10, countDigit - 1);
        while (div != 0) {
            System.out.println(n / div);
            n = n % div;
            div = div / 10;
        }
    }

    static void reverseANumber(int n) {
        int reverse = 0;
        while (n > 0) {
            int d = n % 10;
            reverse = reverse * 10 + d;
            n = n / 10;
        }
        System.out.println(reverse);
    }


    static int rotateANumber(int n, int k) {
        /**
         * n=1234 k=2
         * result = 3412
         * divide number like this 12 and 34
         * multiply 34*100 + 12
         */
        int digitCount = countDigit(n);
        k = k % digitCount;
        if (k < 0) {
            k = k + digitCount;
        }
        int mul = 1;
        int div = 1;
        for (int i = 1; i <= digitCount; i++) {
            if (i <= k) {
                div *= 10;
            } else {
                mul *= 10;
            }
        }
        int q = n / div;
        int r = n % div;
        int resultNumber = r * mul + q;
        return resultNumber;
    }


    /**
     * Inverse a number just change position
     *
     * @param n
     * @return
     */
    static int inverse(int n) {
        int inverse = 0;
        int originalPosition = 1;
        while (n != 0) {
            int originalDigit = n % 10;
            int inverseDigit = originalPosition;
            int inversePosition = originalDigit;
            inverse = inverse + inverseDigit * (int) Math.pow(10, inversePosition - 1);
            n /= 10;
            originalPosition++;
        }

        return inverse;
    }


    /**
     * find k how many time occur in number n
     * @param n
     * @param k
     * @return
     */
    static int digitFrequencyInDigit(int n,int k){
        int count=0;
        while(n>0){
            int dig =n%10;
            n/=10;
            if(dig==k){
                count++;
            }
        }
        return count;
    }


}
