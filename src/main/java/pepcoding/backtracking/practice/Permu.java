package pepcoding.backtracking.practice;

public class Permu {
    public static void main(String[] args) {
        permu(1,3,new int[2],0,2,"");
    }


    static void permu(int cb,int tb,int[] items,int ssf,int ts,String ans){
        if(cb>tb){
            if(ssf==ts)
                System.out.println(ans);
            return;
        }

        for(int i=0;i<ts;i++){
            if(items[i]==0){
                items[i]=i+1;
                permu(cb+1,tb,items,ssf+1,ts,ans+(i+1));
                items[i]=0;
            }
        }
        permu(cb+1,tb,items,ssf,ts,ans+"-");

    }

}
