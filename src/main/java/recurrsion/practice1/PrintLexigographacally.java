package recurrsion.practice1;

public class PrintLexigographacally {
    public static void main(String[] args) {
        printLEgigographically(100);
    }

    static void printLEgigographically(int n){
        for (int i = 1; i < 10; i++) {
            solution(i,n);
        }
    }

    static void solution(int i,int n){
        if(i>n){
            return;
        }
        System.out.println(i);
        for (int j = 0; j < 10; j++) {
            solution(10*i+j,n);
        }

    }
}
