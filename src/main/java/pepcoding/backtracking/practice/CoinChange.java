package pepcoding.backtracking.practice;

public class CoinChange {
    public static void main(String[] args) {
        printCoinChange(0,new int[]{2,3,5,6,7},0,12,"");
    }

    static void printCoinChange(int i,int[] coins,int amtsf,int tamt,String ans){
        if(i== coins.length){
            if(amtsf==tamt){
                System.out.println(ans+" = "+tamt);
            }
            return;
        }
        printCoinChange(i+1,coins,amtsf+coins[i],tamt,ans.isEmpty()?coins[i]+"":ans+"+"+coins[i]);
        printCoinChange(i+1,coins,amtsf,tamt,ans);
    }
}
