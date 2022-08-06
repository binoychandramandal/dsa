package dsa.level1.pattern;

public class PatternPrinting {
    public static void main(String[] args) {

        //printSqure(10,'#');
        //printSqure(10,'*',8);
        //System.out.println();
        //printSqure(10,'*',5);
        //printRectangle(10,10,'*');
        //printTriangle1(20,'*');
        //printTriangle2(20,'*');
        printTriangle3(10, '*');
        printTriangle3(10, '*');
        printTriangle4(10, '*');
    }

    static void printTriangle(int size, char ch) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j != i; j++) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    static void printTriangle2(int size, char ch) {
        for (int i = 1; i <= size; i++) {
            print(i, ' ');
            for (int j = i + 1; j <= size - i + 1; j++) {
                System.out.print(ch);
            }
            if (i == size - 1) {
                System.out.print("");
            } else {
                System.out.println();
            }
        }
    }

    static void printTriangle3(int size, char ch) {
        for (int i = 1; i <= size; i++) {
            print(size - i, ' ');
            print(i, '*');
            System.out.println();
        }
    }

    static void printTriangle4(int size, char ch) {
        for (int i = 1; i <= size; i++) {
            print(i-1, ' ');
            print(size-i+1, '*');
            System.out.println();
        }
    }


    static void printTriangle1(int size, char ch) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                System.out.print(ch);
            }
            if (i == size - 1) {
                System.out.print("");
            } else {
                System.out.println();
            }

        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j != i; j++) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }


    static void printRectangle(int height, int width, char ch) {
        for (int i = 0; i < height; i++) {
            print(width, ch);
            System.out.println();
        }
    }


    static void printSqure(int size, char ch) {
        for (int i = 0; i < size; i++) {
            print(size, ch);
            System.out.println();
        }
    }

    static void printSqure(int size, char ch, int intend) {
        for (int i = 0; i < size; i++) {
            print(intend, ' ');
            print(size, ch);
            System.out.println();
        }
    }

    static void print(int n, char ch) {
        for (int i = 1; i <= n; i++) {
            System.out.print(ch + " ");
        }
    }
}
