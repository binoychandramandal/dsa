package prime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prime {
    public static void main(String[] args) {
        System.out.println(getAllPrimeCount(50));
        System.out.println(getAllPrimeNumber(50));
        System.out.println(Arrays.toString(getSpfArray(73)));
        System.out.println(getTotalFactorOf(74));
        System.out.println(getAllPrimeFactorOf(72));

    }

    static List<Integer> getAllPrimeFactorOf(int n) {
        int[] spf = getSpfArray(n);
        List<Integer> primeFactor = new ArrayList<>();
        while (n > 1) {
            int p = spf[n];
            primeFactor.add(p);
            n = n / p;
        }
        return primeFactor;
    }


    static int getTotalFactorOf(int n) {
        int[] spf = getSpfArray(n);
        int total = 1;
        while (n > 1) {
            int p = spf[n];
            int c = 0;
            while (n % p == 0) {
                c = c + 1;
                n = n / p;
            }
            total *= (c + 1);
        }
        return total;
    }


    static int[] getSpfArray(int n) {
        if (n < 1) {
            return new int[]{};
        }
        if (n == 1) {
            return new int[]{0, 1};
        }
        int[] spf = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            spf[i] = i;
        }
        for (int i = 2; i * i <= n; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
        return spf;

    }

    /**
     * Count how many prime number is there in range 1 to N
     *
     * @param n
     * @return
     */
    static int getAllPrimeCount(int n) {
        boolean[] b = new boolean[n + 1];
        if (n <= 1) {
            return 0;
        }
        for (int i = 2; i < b.length; i++) {
            b[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (b[i] == true) {
                for (int j = i * i; j <= n; j += i) {
                    b[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (b[i] == true)
                count++;
        }
        return count;

    }

    /**
     * @param n
     * @return
     */
    static List<Integer> getAllPrimeNumber(int n) {
        int[] b = new int[n + 1];
        if (n <= 1) {
            return new ArrayList<>();
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = i;
        }
        for (int i = 2; i * i <= n; i++) {
            if (b[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    if (b[j] == j)
                        b[j] = i;
                }
            }
        }
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (b[i] == i)
                primeList.add(b[i]);
        }
        return primeList;
    }
}
