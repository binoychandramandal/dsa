package practise.practice;

public class Test2 {
    public static void main(String[] args) {
        //printC(1,4,0,2,"");
        printP(1,4,new boolean[3],0,3,"");
    }

    static void printC(int cb,int tb,int ssf,int ts,String ans){
        if(cb>tb){
            if(ssf==ts){
                System.out.println(ans);
            }
            return;
        }

        printC(cb+1,tb,ssf+1,ts,ans+"i");
        printC(cb+1,tb,ssf,ts,ans+"0");
    }

    static void printP(int cb,int tb,boolean[] item,int ssf,int ts,String ans){
        if(cb>tb){
            if(ssf==ts){
                System.out.println(ans);
            }
            return;
        }
        for (int i = 0; i < item.length; i++) {
            if(item[i]==false){
                item[i] = true;
                printP(cb+1,tb,item,ssf+1,ts,ans+(i+1));
                item[i] = false;
            }
        }
        printP(cb+1,tb,item,ssf,ts,ans+"0");
    }




}
