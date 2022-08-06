package recurrsion.practise;

import java.util.ArrayList;
import java.util.List;

public class StairProblem {
    public static void main(String[] args) {
        System.out.println(getStairPath(4));
        System.out.println(getStairPath(5));
        printStairPath(4,"");
    }

    static List<String> getStairPath(int n) {

        if (n == 0) {
            List<String> l = new ArrayList<>();
            l.add("");
            return l;
        } else if (n < 0) {
            List<String> l = new ArrayList<>();
            return l;
        }

        List<String> paths1 = getStairPath(n - 1);
        List<String> paths2 = getStairPath(n - 2);
        List<String> paths3 = getStairPath(n - 3);
        List<String> paths = new ArrayList<>();
        for (String p1 : paths1) {
            paths.add("1" + p1);
        }
        for (String p2 : paths2) {
            paths.add("2" + p2);
        }

        for (String p3 : paths3) {
            paths.add("3" + p3);
        }
        return paths;
    }


    static void printStairPath(int n, String path) {

        if (n == 0) {
            System.out.print(path + " ");
            return;
        } else if (n < 0) {
            return;
        }
        printStairPath(n - 1, path + "1");
        printStairPath(n - 2, path + "2");
        printStairPath(n - 3, path + "3");
    }


}
