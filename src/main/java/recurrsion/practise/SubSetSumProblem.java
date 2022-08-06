package recurrsion.practise;

public class SubSetSumProblem {
    public static void main(String[] args) {
        int[] arr = new int[]{10,20,30,40,50};
        int target =70;
        printTargetSubSubset(arr,0,"",0,target);
    }

    static void printTargetSubSubset(int[] arr,int idx,String set,int sos,int tar){
        if(idx==arr.length){
            if(sos==tar){
                System.out.println(set+" . ");
            }
            return;
        }
        printTargetSubSubset(arr,idx+1,set+arr[idx]+",",sos+arr[idx],tar);
        printTargetSubSubset(arr,idx+1,set,sos,tar);
    }
}
