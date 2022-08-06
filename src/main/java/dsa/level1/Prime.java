package dsa.level1;

public class Prime {
    public static void main(String[] args) {
        System.out.println(isPrime(0));
        System.out.println(isPrime(1));
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(4));
        System.out.println(isPrime(5));
        System.out.println(isPrime(7));
        System.out.println(isPrime(9));
        System.out.println("Optimized");
        System.out.println(isPrimeWithSqrtN(0));
        System.out.println(isPrimeWithSqrtN(1));
        System.out.println(isPrimeWithSqrtN(2));
        System.out.println(isPrimeWithSqrtN(3));
        System.out.println(isPrimeWithSqrtN(4));
        System.out.println(isPrimeWithSqrtN(11));
        System.out.println(isPrimeWithSqrtN(12));


        System.out.println("Given Range");
        allPrimeInGivenRange(200,1000);
    }

    /**
     * two factor  of a number is called prime. 1 and number itseft.
     * But this algo will take n time to check is prime or not?
     *
     * @param n
     * @return
     */
    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count > 2 ? false : true;
    }

    /**
     * This will not check with n
     * two factor  of a number is called prime. 1 and number itseft.
     * But this algo will take n time to check is prime or not?
     *
     * @param n
     * @return
     */
    static boolean isPrimeWithSqrtN(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void allPrimeInGivenRange(int low, int high) {
        if (low < 1) {
            return;
        }
        for (int n = low; n <= high; n++) {
            if (isPrimeWithSqrtN(n)) {
                System.out.println(n);
            }
        }
    }

}
