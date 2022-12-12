import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

            String abc="次回もこのログイン名を使用する";
            for(char c:abc.toCharArray()){
                System.out.println(c+1);
            }
            System.out.println("String-->"+abc);

       // System.out.println(Arrays.toString(getAllindices(new int[]{2,4,4,4,5},0,0,4)));

    }

    static int[] getAllindices(int[] a, int idx, int csf, int data) {
        if (idx == a.length) {
            return new int[csf];
        }
        int[] t = null;
        if (a[idx] == data) {
            t = getAllindices(a, idx + 1, csf + 1, data);
        } else {
            t = getAllindices(a, idx + 1, csf, data);
        }

        if (a[idx] == data) {
            t[csf] = idx;
        }
        return t;
    }
}
