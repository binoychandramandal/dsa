package matrix;

public class SubMatrix {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] mat1 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        //printMatrix(mat,0,0,1,0);
        //printAllSubMatrix(mat);
        printMatrix(mat);
        generatePrefixMatrix(mat);
        System.out.println();
        printMatrix(mat);
        generatePrefixMatrix1(mat1);
        System.out.println();
        printMatrix(mat1);
    }

    public static void printMatrix(int[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j <mat[i].length; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static void generatePrefixMatrix(int[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 1; j < mat[i].length; j++) {
                mat[i][j] +=mat[i][j-1];
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 1; j < mat[i].length; j++) {
                mat[j][i] +=mat[j-1][i];
            }
        }
    }

    public static void generatePrefixMatrix1(int[][] mat){
        for (int i = 1; i < mat.length; i++) {
                mat[0][i] +=mat[0][i-1];
        }
        for (int i = 1; i < mat.length; i++) {
            mat[i][0] +=mat[i-1][0];
        }

        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[i].length; j++) {
                mat[i][j] +=mat[i][j-1]+mat[i-1][j]-mat[i-1][j-1];
            }
        }
    }


    public  static  void printAllSubMatrix(int[][] mat){

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                //(i,j) start point or Top Left point
                int a1=i;
                int b1=j;

                for (int k = a1; k <mat.length ; k++) {
                    for (int l = b1; l < mat[i].length; l++) {
                        //end pont or Bottom right point
                        int a2=k;
                        int b2=l;
                        printMatrix(mat,a1,b1,a2,b2);
                        System.out.println();
                    }

                }

            }
        }

    }


    public static void printMatrix(int[][] mat,int a1,int b1,int a2,int b2){
        for (int i = a1; i <=a2; i++) {
            for (int j = b1; j <=b2; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

}
