package recurrsion.practice1;

public class LexicographacallyPrint {
    public static void main(String[] args) {
        print(1000);
    }

    static void print(int n){
        for (int i = 1; i < 10; i++) {
            dfs(i,n);
        }
    }

    private static void dfs(int i, int n) {
        if(i>n){
            return;
        }
        System.out.println(i);
        for (int j = 0; j < 10; j++) {
            dfs(10*i+j,n);
        }
    }


}
