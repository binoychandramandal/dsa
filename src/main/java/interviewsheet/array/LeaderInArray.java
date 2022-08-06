package interviewsheet.array;

public class LeaderInArray {

    public static void main(String[] args) {
        int[] a = {16, 17, 4, 3, 5, 2};
        printLeader(a);
    }

    public static void printLeader(int[] a) {
        if (a.length == 1) {
            System.out.println(a[0]);
            return;
        }
        System.out.print(a[a.length - 1] + " ");
        int maxSoFar = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            if (maxSoFar < a[i]) {
                maxSoFar=a[i];
                System.out.print(a[i] + " ");
            }
        }
    }
}
