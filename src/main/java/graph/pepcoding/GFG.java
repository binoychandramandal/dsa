package graph.pepcoding;

import java.util.HashSet;
import java.util.Vector;

class GFG
{
  
    // Maximum
    static int MAX = 100;
  
    // Prefix Array
    static Vector<Integer> prefix = new Vector<>();
  
    static int isValid(int n) {
        HashSet<Integer> a = new HashSet<>();
        int d;
        while (n != 0)
        {
            d = n % 10;
            if (a.contains(d))
                return 0;
            a.add(d);
            n /= 10;
        }
        return 1;
    }
  
    static void pre_calculations()
    {
        prefix.add(0);
        prefix.add(isValid(1));
  
        // Traversing through the numbers
        // from 2 to MAX
        for (int i = 2; i < MAX + 1; i++)
  
            // Generating the Prefix array
            prefix.add(isValid(i) + prefix.elementAt(i - 1));
    }
  

    static int calculate(int L, int R)
    {
        return prefix.elementAt(R) - prefix.elementAt(L - 1);
    }
  
    // Driver Code
    public static void main(String[] args)
    {
        int L = 1, R = 20;
        pre_calculations();

        System.out.println(calculate(L, R));
    }
}
