package recurrsion.practise;

public class Combination {
    public static void main(String[] args) {
       // combinations(1,5,0,2,"");
        combinations(new boolean[5],1,3,-1);
    }

    static void combinations(int cb,int tb,int ssf,int ts,String asf ){
        if(cb>tb){
            if(ssf==ts){
                System.out.println(asf);
            }
            return;
        }
        combinations(cb+1,tb,ssf+1,ts,asf+"i");
        combinations(cb+1,tb,ssf,ts,asf+"-");
    }


    /**
     * Other way to find permutation
     * @param boxes
     * @param ci
     * @param ti
     * @param llb
     */
    static void combinations(boolean[] boxes,int ci,int ti,int llb){
        if(ci>ti){
            for (int i = 0; i < boxes.length; i++) {
                if(boxes[i]){
                    System.out.print("i");
                }else {
                    System.out.print("-");
                }
            }
            System.out.println();
            return;
        }
        for (int b = llb+1; b < boxes.length; b++) {
            if(boxes[b]==false){
                boxes[b]=true;
                combinations(boxes,ci+1,ti,b);
                boxes[b]=false;
            }
        }
    }


}
