package practise.backtracking;

public class TowerOfHanoi {
    public static void main(String[] args) {
        printStep(3,"A","B","C");
    }

    static void printStep(int n, String src, String temp, String dest) {
        if (n == 0) return;
        printStep(n - 1, src, dest, temp);
        System.out.println(n + " move from " + src + " to " + dest);
        printStep(n - 1, temp, src, dest);
    }
}
