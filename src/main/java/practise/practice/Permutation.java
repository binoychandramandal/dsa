package practise.practice;

public class Permutation {
    public static void main(String[] args) {
        //printPermutation("abc","");
        //permutationItemInLevel(new int[4],1,1);
       // printNPR(new int[3],new int[]{4,5,6},0);
        printNPR1(new int[4],new int[]{4,5,6},0,-1);
    }

    static void permutationItemInLevel(int[] box,int ci,int ti){
        if(ci>ti){
            for (int i = 0; i < box.length; i++) {
                if(box[i]==0){
                    System.out.print("-");
                }else {
                    System.out.print(box[i]);
                }
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < box.length; i++) {
            if(box[i]==0){
                box[i]=ci;
                permutationItemInLevel(box,ci+1,ti);
                box[i]=0;
            }
        }
    }

    static void printPermutation(String st, String ans) {
        if(st.isEmpty()){
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < st.length(); i++) {
            char c = st.charAt(i);
            String s1 = st.substring(0, i);
            String s2 = st.substring(i+1, st.length());
            printPermutation(s1 + s2, ans + c);
        }
    }

    static void printNPR(int[] box,int[] item,int ci){
        if(ci>item.length-1){
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
                box[i]=item[ci];
                printNPR(box,item,ci+1);
                box[i]=0;
            }
        }
    }

    static void printNPR1(int[] box,int[] item,int ci,int llb){
        if(ci>item.length-1){
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
            if(box[i]==0){
                box[i]=item[ci];
                printNPR1(box,item,ci+1,i);
                box[i]=0;
            }
        }
    }
}
