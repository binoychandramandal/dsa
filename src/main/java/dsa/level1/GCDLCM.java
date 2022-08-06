package dsa.level1;

import java.util.ArrayList;
import java.util.List;

public class GCDLCM {
    public static void main(String[] args) {
//        System.out.println(gcd(2, 4));
//        System.out.println(gcd(0, 4));
//        System.out.println(gcd(4, 0));
//        System.out.println(gcd(2, 4));
//        System.out.println(lcm(2, 4));
//        System.out.println(primeFactorization(24 * 3));
//        System.out.println(primeFactorization(25));
       System.out.println(primeFactorizationOptimized(20));
        System.out.println(primeFactorizationOptimized(24));

    }

    static int gcd(int n1, int n2) {
        if (n1 == 0)
            return n2;
        if (n2 == 0) {
            return n1;
        }
        while (n1 % n2 != 0) {
            int rem = n1 % n2;
            n1 = n2;
            n2 = rem;
        }
        return n2;
    }

    static int lcm(int n1, int n2) {
        return (n1 * n2) / gcd(n1, n2);
    }

    static List<Integer> primeFactorization(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                n = n / i;
                result.add(i);
            }
        }
        return result;
    }
    static List<Integer> primeFactorizationOptimized(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i*i <= n; i++) {
            while (n % i == 0) {
                n = n / i;
                result.add(i);
            }
        }
        if(n!=1){
            result.add(n);
        }
        return result;
    }
}
