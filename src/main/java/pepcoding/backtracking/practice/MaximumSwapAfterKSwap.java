package pepcoding.backtracking.practice;

public class MaximumSwapAfterKSwap {
    static int max=Integer.MIN_VALUE;
    public static void main(String[] args) {
        printMax("1234567",4);
        System.out.println(max);
    }

    static void printMax(String str,int k){
        if(Integer.parseInt(str)>max){
            max=Integer.parseInt(str);
        }
        if(k==0){
            return;
        }
        for (int i = 0; i < str.length()-1; i++) {
            for (int j = i+1; j < str.length(); j++) {
                if(str.charAt(j)>str.charAt(i)){
                    String swappedString=swap(str,i,j);
                    printMax(swappedString,k-1);
                }
            }
        }
    }
    static String swap(String str,int i ,int j){
        char ithChar = str.charAt(i);
        char jthChar = str.charAt(j);
        String left = str.substring(0,i);
        String middle = str.substring(i+1,j);
        String right = str.substring(j+1);
        return left+jthChar+middle+ithChar+right;
    }
}
