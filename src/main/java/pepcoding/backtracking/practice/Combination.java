package pepcoding.backtracking.practice;

public class Combination {
    public static void main(String[] args) {
        combination(1,4,0,2,"");

    }
    static void combination(int cb,int tb,int ssf,int ts,String ans){
        if(cb>tb){
            if(ssf==ts)
            System.out.println(ans);
            return;
        }
        combination(cb+1,tb,ssf+1,ts,ans+"i");
        combination(cb+1,tb,ssf,ts,ans+"-");
    }
}
