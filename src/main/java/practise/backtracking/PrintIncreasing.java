package practise.backtracking;

public class PrintIncreasing {
    public static void main(String[] args) {
        //printIncreasing(10);
        //printDecreasingOrder(10);
        printIncDec(10);
    }

    static void printIncreasing(int n){
        if(n==0)
            return ;
        printIncreasing(n-1);
        System.out.println(n);
    }
    static  void printDecreasingOrder(int n){
        if(n==0)
            return;
        System.out.println(n);
        printDecreasingOrder(n-1);
    }

    static void printIncDec(int n){
        if(n==0)
            return;
        System.out.println(n);//decreasing
        printIncDec(n-1);
        System.out.println(n);  // increasing order
    }
}
