package recurrsion.practise;

public class JosephusProblem {
    public static void main(String[] args) {
        System.out.println(solution(4,1));
    }

    static int solution(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int x = solution(n - 1, k);
        int y = (x + k) % n;
        return y;
    }

}
