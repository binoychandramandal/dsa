package tuf.array;

import java.util.*;

class TUF {
    static void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {

                    int ind = i - 1;
                    while (ind >= 0) {
                        if (matrix[ind][j] != 0) {
                            matrix[ind][j] = -1;
                        }
                        ind--;
                    }
                    ind = i + 1;
                    while (ind < rows) {
                        if (matrix[ind][j] != 0) {
                            matrix[ind][j] = -1;
                        }
                        ind++;
                    }
                    ind = j - 1;
                    while (ind >= 0) {
                        if (matrix[i][ind] != 0) {
                            matrix[i][ind] = -1;

                        }
                        ind--;
                    }
                    ind = j + 1;
                    while (ind < cols) {
                        if (matrix[i][ind] != 0) {
                            matrix[i][ind] = -1;

                        }
                        ind++;
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] <= 0) {
                    matrix[i][j] = 0;
                }
            }
        }


    }


    static void setZero(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 0) {
                    //set all value -1 which does not have 0 through row
                    for (int k = 0; k < a[0].length; k++) {
                        if (a[i][k] != 0) {
                            a[i][k] = -1;
                        }
                    }
                    //set all value -1 which does not have 0 through row
                    for (int k = 0; k < a.length; k++) {
                        if (a[k][j] != 0) {
                            a[k][j] = -1;
                        }
                    }
                }
            }
        }
        // set all -1 to 0
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == -1) {
                    a[i][j] = 0;
                }
            }
        }
    }

    public static void main(String args[]) {
        int arr[][] = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}};

        int arr1[][] = {
                {0, 1, 2, 0},
                {3, 4, 0, 2},
                {0, 3, 1, 5}};
        setZero(arr1);
        print(arr1);
    }

    static void print(int[][] arr) {
        System.out.println("The Final Matrix is ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}