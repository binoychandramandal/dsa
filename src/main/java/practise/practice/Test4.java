package practise.practice;

public class Test4 {
    public static void main(String[] args) {
        //print(new int[3],1,2);
        print1(new int[4],1,2,-1);
    }

    static void print(int[] box,int ci,int ts){
        if(ci>ts){
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
            if(box[i]==0){
                box[i] = ci;
                print(box,ci+1,ts);
                box[i]=0;
            }
        }
    }

    static void print1(int[] box,int ci,int ts,int ll){
        if(ci>ts){
            for (int i = 0; i < box.length; i++) {
                if(box[i]==0){
                    System.out.print("-");
                }else{
                    System.out.print("i");
                }
            }
            System.out.println();
            return;
        }

        for (int i = ll+1; i < box.length; i++) {
            if(box[i]==0){
                box[i] = ci;
                print1(box,ci+1,ts,i);
                box[i]=0;
            }
        }
    }


}
