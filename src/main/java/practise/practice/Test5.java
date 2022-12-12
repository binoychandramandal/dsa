package practise.practice;

public class Test5 {
    public static void main(String[] args) {

        //printC(1,4,0,2,"");
        printC(1,4,new int[2],0,2,"");
    }

    static void printC( int cb,int tb,int ssf,int ts,String ans){
        if(cb>tb){
            if(ssf==ts){
                System.out.println(ans);
            }
            return;
        }

        printC(cb+1,tb,ssf+1,ts,ans+"i");
        printC(cb+1,tb,ssf,ts,ans+"-");
    }

    static void printC( int cb,int tb,int [] item,int ssf,int ts,String ans){
        if(cb>tb){
            if(ssf==ts){
                System.out.println(ans);
            }
            return;
        }
        for (int i = 0; i < item.length; i++) {
            if(item[i]==0) {
                item[i] = i+1;
                printC(cb + 1, tb, item,ssf + 1, ts, ans + (i+1));
                item[i] = 0;
            }
        }
        printC(cb+1,tb,item,ssf,ts,ans+"-");
    }


}
