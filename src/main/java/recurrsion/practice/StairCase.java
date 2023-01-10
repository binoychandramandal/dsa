package recurrsion.practice;

import java.util.ArrayList;
import java.util.List;

public class StairCase {
    public static void main(String[] args) {
        printStairCase(3, "");
        System.out.println();
        System.out.println(generateStairCase(3));
    }

    static void printStairCase(int n, String ans) {
        if (n < 0) {
            return;
        }
        if (n == 0) {
            System.out.print(ans+" ");
            return;
        }
        printStairCase(n - 1, ans + "1");
        printStairCase(n - 2, ans + "2");
        printStairCase(n - 3, ans + "3");
    }

    static List<String> generateStairCase(int n) {
        if (n < 0) {
            return new ArrayList<>();
        }
        if (n == 0) {
            List<String> l = new ArrayList<>();
            l.add("");
            return l;
        }
        List<String> path1 = generateStairCase(n - 1);
        List<String> path2 = generateStairCase(n - 2);
        List<String> path3 = generateStairCase(n - 3);
        List<String> result = new ArrayList<>();
        for(String p:path1){
            result.add(p+"1");
        }
        for(String p:path2){
            result.add(p+"2");
        }
        for(String p:path3){
            result.add(p+"3");
        }
        return result;
    }


}
