package recurrsion.practise;

import java.util.ArrayList;

public class MazePath {
    public static void main(String[] args) {

        //System.out.println(getMazePaths(1, 1, 3, 3));
        //printMazePaths(1, 1, 3, 3, "");
        //System.out.println();

        System.out.println(getMazePathsWithJump(1, 1, 5, 5));
        //printMazePathsWithJump(1,1,3,3,"");

    }

    /**
     * Simple without jump
     * at a time one step either horizontal or vertical
     *
     * @param srcRow
     * @param srcCol
     * @param desRow
     * @param destCol
     * @return
     */
    static ArrayList<String> getMazePaths(int srcRow, int srcCol, int desRow, int destCol) {

        if (srcRow == desRow && srcCol == destCol) {
            ArrayList<String> l = new ArrayList<>();
            l.add("");
            return l;
        }
        ArrayList<String> hPaths = new ArrayList<>();
        if (srcCol < destCol)
            hPaths = getMazePaths(srcRow, srcCol + 1, desRow, destCol);
        ArrayList<String> vPaths = new ArrayList<>();
        if (srcRow < desRow)
            vPaths = getMazePaths(srcRow + 1, srcCol, desRow, destCol);
        ArrayList<String> paths = new ArrayList<>();

        for (String p : hPaths) {
            paths.add("h" + p);
        }

        for (String p : vPaths) {
            paths.add("v" + p);
        }
        return paths;
    }

    static void printMazePaths(int srcRow, int srcCol, int desRow, int destCol, String psf) {
        if (srcRow > desRow || srcCol > destCol) {
            return;
        }
        if (srcRow == desRow && srcCol == destCol) {
            System.out.print(psf + " ");
            return;
        }
        printMazePaths(srcRow, srcCol + 1, desRow, destCol, psf + "h");
        printMazePaths(srcRow + 1, srcCol, desRow, destCol, psf + "v");

    }

    //step h1, h2, h3 or v1,v2 and v3 or d1,d2 and d3 way u can jump at a time.
    static ArrayList<String> getMazePathsWithJump(int srcRow, int srcCol, int desRow, int destCol) {

        if (srcRow == desRow && srcCol == destCol) {
            ArrayList<String> l = new ArrayList<>();
            l.add("");
            return l;
        }

        ArrayList<String> paths = new ArrayList<>();
        //horizontal move
        for (int ms = 1; ms <= destCol - srcCol; ms++) {
            ArrayList<String> hPaths = getMazePathsWithJump(srcRow, srcCol + ms, desRow, destCol);
            for (String p : hPaths) {
                paths.add("h" + ms + p);
            }
        }

        //vertical move
        for (int ms = 1; ms <= desRow - srcRow; ms++) {
            ArrayList<String> vPaths = getMazePathsWithJump(srcRow + ms, srcCol, desRow, destCol);
            for (String p : vPaths) {
                paths.add("v" + ms + p);
            }
        }

        //diagonal move
        for (int ms = 1; ms <= desRow - srcRow && ms <= destCol - srcCol; ms++) {
            ArrayList<String> dPaths = getMazePathsWithJump(srcRow + ms, srcCol + ms, desRow, destCol);
            for (String p : dPaths) {
                paths.add("d" + ms + p);
            }
        }

        return paths;
    }

    static void printMazePathsWithJump(int srcRow, int srcCol, int desRow, int destCol, String psf) {

        if (srcRow == desRow && srcCol == destCol) {
            System.out.print(psf + " ");
            return ;
        }

        //horizontal move
        for (int ms = 1; ms <= destCol - srcCol; ms++) {
            printMazePathsWithJump(srcRow, srcCol + ms, desRow, destCol, psf + "h" + ms);
        }

        //vertical move
        for (int ms = 1; ms <= desRow - srcRow; ms++) {
            printMazePathsWithJump(srcRow + ms, srcCol, desRow, destCol, psf + "v" + ms);

        }

        //diagonal move
        for (int ms = 1; ms <= desRow - srcRow && ms <= destCol - srcCol; ms++) {
            printMazePathsWithJump(srcRow + ms, srcCol + ms, desRow, destCol, psf + "d" + ms);

        }

    }

}
