package practise.recurssion;

import java.util.ArrayList;
import java.util.List;

public class StairCase {
    public static void main(String[] args) {
        System.out.println(getAllPaths(6));
        printAllPaths(6,"");
    }

    static List<String> getAllPaths(int n) {
        if (n < 0) {
            return new ArrayList<>();
        }
        if (n == 0) {
            List<String> l = new ArrayList<>();
            l.add("");
            return l;
        }

        List<String> path1 = getAllPaths(n - 1);
        List<String> path2 = getAllPaths(n - 2);
        List<String> path3 = getAllPaths(n - 3);

        List<String> result = new ArrayList<>();
        for (String p : path1) {
            result.add("1" + p);
        }
        for (String p : path2) {
            result.add("2" + p);
        }
        for (String p : path3) {
            result.add("3" + p);
        }
        return result;
    }

    static void printAllPaths(int n,String psf){
        if(n<0){
            return;
        }
        if(n==0){
            System.out.print(psf+" ");
            return;
        }
        printAllPaths(n-1,psf+"1");
        printAllPaths(n-2,psf+"2");
        printAllPaths(n-3,psf+"3");

    }
}
