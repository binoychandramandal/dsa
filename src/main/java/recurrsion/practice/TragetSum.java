package recurrsion.practice;

public class TragetSum {
    public static void main(String[] args) {
        printSubSet(new int[]{1,2,3,4,5,6,7},0,0,7,"");
    }

    static void printSubSet(int[] a,int index,int sof,int target,String ans){
        if(index==a.length){
            if(sof==target)
            System.out.println(ans);
            return;
        }
        printSubSet(a,index+1,sof,target,ans);
        printSubSet(a,index+1,sof+a[index],target,ans+a[index]+" ");
    }
}
