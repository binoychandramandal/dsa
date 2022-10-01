package own.practice.array;

public class MatrixZeroSet {
    public static void main(String[] args) {

        int[][] a = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        print(a);
        System.out.println("All values are set zero");
        setZero(a);
        print(a);
        System.out.println("Printing");
        int[][] b = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        print(b);
        System.out.println("After modified");
        setZeroWithTempArray(b);
        print(b);

        System.out.println("Printing");
        int[][] c = {
                {1, 0, 1},
                {1, 0, 1},
                {1, 0, 1}
        };
        print(c);
        System.out.println("After modified");
        setZeroWithTempArray(c);
        print(c);
    }

    private static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void setZeroWithTempArray(int[][] a) {
        if (a == null || a.length <= 0) {
            return;
        }

        int[] row = new int[a.length];
        int[] col = new int[a[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    a[i][j] = 0;
                }
            }
        }

    }

    /**
     * brute force approach
     * O(n*m)
     *
     * @param a
     */
    private static void setZero(int[][] a) {
        if (a == null || a.length <= 0) {
            return;
        }
        int rows = a.length;
        int cols = a[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (a[i][j] == 0) {

                    //make row -1
                    int index = j - 1;
                    while (index >= 0) {
                        if (a[i][index] == 1) {
                            a[i][index] = -1;
                        }
                        index--;
                    }
                    index = j + 1;
                    while (index < cols) {
                        if (a[i][index] == 1) {
                            a[i][index] = -1;
                        }
                        index++;
                    }

                    //make col -1
                    index = i - 1;
                    while (index >= 0) {
                        if (a[index][j] == 1) {
                            a[index][j] = -1;
                        }
                        index--;
                    }
                    index = i + 1;
                    while (index < rows) {
                        if (a[index][j] == 1) {
                            a[index][j] = -1;
                        }
                        index++;
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (a[i][j] == -1) {
                    a[i][j] = 0;
                }
            }
        }

    }


}
