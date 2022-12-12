package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test3 {
    public static void main(String[] args) {
        //System.out.println(getSubSequence("abc"));
        System.out.println(generatePropertyCombination(Arrays.asList("a","b","c")));
       // System.out.println(getAllPaths(4));
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

    private static List<Set<String>> generatePropertyCombination(List<String> propertyList){
        List<String> props=generateCombination(propertyList,0);
      return props.stream().filter(x->!x.isEmpty()).map(x-> Stream.of(x.split(",")).collect(Collectors.toSet())).collect(Collectors.toList());
    }

   private static List<String> generateCombination(List<String> str,int i) {
        if (str.size()==i) {
            ArrayList<String> r = new ArrayList<>();
            r.add("");
            return r;
        }
        String ch = str.get(i);
        List<String> res = generateCombination(str,i+1);
        List<String> mRes = new ArrayList<>();
        for (String r : res) {
            mRes.add(r);
        }
        for (String r : res) {
            mRes.add(ch +","+ r);
        }
        return mRes;
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
