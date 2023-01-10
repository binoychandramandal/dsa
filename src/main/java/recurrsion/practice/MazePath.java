package recurrsion.practice;

import java.util.ArrayList;
import java.util.List;

public class MazePath {
    public static void main(String[] args) {
        //System.out.println(generateAllMazePath(new int[2][4], 0, 0));
       // generateAllMazePath(new int[2][4], 0, 0, "");
        System.out.println(generateAllMazePathWithAnyJump(new int[2][2],0,0));
        generateAllMazePathWithAnyJump(new int[2][2],0,0,"");
    }


    static List<String> generateAllMazePath(int[][] a, int r, int c) {

        if (r == a.length - 1 && c == a[0].length - 1) {
            List<String> path = new ArrayList<>();
            path.add("");
            return path;
        }
        List<String> vPath = new ArrayList<>();
        List<String> hPath = new ArrayList<>();
        List<String> result = new ArrayList<>();

        if (r < a.length) {
            vPath = generateAllMazePath(a, r + 1, c);
            for (String p : vPath) {
                result.add("V" + p);
            }
        }
        if (c < a[0].length) {
            hPath = generateAllMazePath(a, r, c + 1);
            for (String p : hPath) {
                result.add("H" + p);
            }
        }
        return result;
    }

    static List<String> generateAllMazePathWithAnyJump(int[][] a, int r, int c) {

        if (r == a.length - 1 && c == a[0].length - 1) {
            List<String> path = new ArrayList<>();
            path.add("");
            return path;
        }
        List<String> vPath = new ArrayList<>();
        List<String> hPath = new ArrayList<>();
        List<String> dPath = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= a.length - r-1; i++) {
            vPath = generateAllMazePathWithAnyJump(a, r + i, c);
            for (String p : vPath) {
                result.add("V"+i + p);
            }
        }
        for (int i = 1; i <= a[0].length -1 - c; i++) {
            hPath = generateAllMazePathWithAnyJump(a, r, c + 1);
            for (String p : hPath) {
                result.add("H"+i + p);
            }
        }
        for (int i = 1; i <= a.length - r-1 && i<=a[0].length-c-1; i++) {
            dPath = generateAllMazePathWithAnyJump(a, r+i, c + i);
            for (String p : dPath) {
                result.add("D"+i + p);
            }
        }
        return result;
    }


    static void generateAllMazePathWithAnyJump(int[][] a, int r, int c,String psf) {
        if (r == a.length - 1 && c == a[0].length - 1) {
            System.out.println(psf);
            return;
        }
        for (int i = 1; i <= a.length - r-1; i++) {
           generateAllMazePathWithAnyJump(a, r + i, c,psf+"V"+i);
        }
        for (int i = 1; i <= a[0].length -1 - c; i++) {
           generateAllMazePathWithAnyJump(a, r, c + 1,psf+"H"+i);
        }
        for (int i = 1; i <= a.length - r-1 && i<=a[0].length-c-1; i++) {
           generateAllMazePathWithAnyJump(a, r+i, c + i,psf+"D"+i);
        }
    }


    static void generateAllMazePath(int[][] a, int r, int c, String psf) {
        if (r == a.length - 1 && c == a[0].length - 1) {
            System.out.println(psf);
            return;
        }
        if (r < a.length)
            generateAllMazePath(a, r + 1, c, psf + "V");
        if (c < a[0].length)
            generateAllMazePath(a, r, c + 1, psf + "H");
    }


}
