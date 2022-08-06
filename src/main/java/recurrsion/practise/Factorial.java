package recurrsion.practise;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factTail(4));
        System.out.println(factHead(4));
    }
    static int factTail(int n){
        if(n==1)
            return 1;
        return n*factTail(n-1);
    }

    static int factHead(int n){
        if(n==1)
            return 1;
        return factHead(n-1)*n;
    }


}
