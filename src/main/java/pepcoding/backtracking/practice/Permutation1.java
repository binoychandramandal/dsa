package pepcoding.backtracking.practice;

public class Permutation1 {
    public static void main(String[] args) {
        permutation(1,3,new int[2],0,"");
    }
    
    static void permutation(int cb,int tb,int[] items,int ssf,String ans){
        if(cb>tb){
            if(ssf==items.length){
                System.out.println(ans);
            }
            return;
        }

        for (int i = 0; i < items.length; i++) {
            if(items[i]==0){
                items[i]=1;
                permutation(cb+1,tb,items,ssf+1,ans+(i+1));
                items[i]=0;
            }
        }
        permutation(cb+1,tb,items,ssf,ans+"0");
    }
}
