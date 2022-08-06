package practise;

import java.util.ArrayList;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        System.out.println(getSubSequence("abc"));
        System.out.println(getAllPaths(4));
    }

    static ArrayList<String> getSubSequence(String str) {
        if (str.isEmpty()) {
            ArrayList<String> r = new ArrayList<>();
            r.add("");
            return r;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> res = getSubSequence(ros);
        ArrayList<String> mres = new ArrayList<>();
        for (String r : res) {
            mres.add(r);
        }
        for (String r : res) {
            mres.add(ch + r);
        }
        return mres;
    }

    static List<String> getAllPaths(int n) {
        if (n == 0) {
            List<String> l = new ArrayList<>();
            l.add("");
            return l;
        }
        if (n < 0) {
            List<String> l = new ArrayList<>();
            return l;
        }
        List<String> result = new ArrayList<>();
        List<String> paths1 = getAllPaths(n - 1);

        List<String> paths2 = getAllPaths(n - 2);

        List<String> paths3 = getAllPaths(n - 3);
        for (String p1 : paths1) {
            result.add("1"+p1);
        }
        for (String p1 : paths2) {
            result.add("2"+p1);
        }
        for (String p1 : paths3) {
            result.add("3"+p1);
        }
        return result;

    }
}
