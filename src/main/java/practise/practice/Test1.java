package practise.practice;

public class Test1 {
    public static void main(String[] args) {

        //print(new int[4],1,2);
        printC(new int[4],1,2,-1);

    }

    static void print(int[] box,int ci,int ti){
        if(ci>ti){
            for (int i = 0; i < box.length; i++) {
                if(box[i]==0){
                    System.out.print("-");
                }else{
                    System.out.print(box[i]);
                }
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < box.length; i++) {
            if(box[i]==0) {
                box[i] = ci;
                print(box, ci + 1, ti);
                box[i]=0;
            }
        }
    }


    static void printC(int[] box,int ci,int ti,int llb){
        if(ci>ti){
            for (int i = 0; i < box.length; i++) {
                if(box[i]==0){
                    System.out.print("-");
                }else{
                    System.out.print(box[i]);
                }
            }
            System.out.println();
            return;
        }
        for (int i = llb+1; i < box.length; i++) {
            if(box[i]==0) {
                box[i] = ci;
                printC(box, ci + 1,ti, i);
                box[i]=0;
            }
        }
    }



}
