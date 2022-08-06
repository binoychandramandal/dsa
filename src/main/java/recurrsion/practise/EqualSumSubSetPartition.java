package recurrsion.practise;

import java.util.ArrayList;

public class EqualSumSubSetPartition {
    public static void main(String[] args) {
        printEqualSumSubSetWithPartition(new int[]{1,2,3,4,5,6,7},4);
    }

    static void printEqualSumSubSetWithPartition(int[] arr, int k){
       int sum = 0;
       for (int i:arr){
           sum+=i;
       }
        if(k==1){
            System.out.print("[");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+", ");
            }
            System.out.println();
            return;
        }
        if(k> arr.length || sum%k!=0){
            System.out.println("-1");
            return;
        }
        int[] subsetSum =new int[k];
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(new ArrayList<>());
        }
        solution(arr,0,arr.length,k,subsetSum,0,ans);

    }

    static void solution(int[] arr, int vidx, int n, int k, int[]subsetSum, int ssssf, ArrayList<ArrayList<Integer>> ans){
        if(vidx==arr.length){
            if(ssssf==k){
                 boolean flag =true;
                for (int i = 0; i < subsetSum.length-1; i++) {
                    if(subsetSum[i]!=subsetSum[i+1]){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    for (ArrayList<Integer> partition: ans){
                        System.out.print(partition+" ");
                    }
                    System.out.println();
                }
            }
            return;
        }
        for (int i = 0; i < ans.size(); i++) {
            if(ans.get(i).size()>0){
                ans.get(i).add(arr[vidx]);
                subsetSum[i] +=arr[vidx];
                solution(arr,vidx+1,n,k,subsetSum,ssssf,ans);
                subsetSum[i] -=arr[vidx];
                ans.get(i).remove(ans.get(i).size()-1);
            }else{
                ans.get(i).add(arr[vidx]);
                subsetSum[i] +=arr[vidx];
                solution(arr,vidx+1,n,k,subsetSum,ssssf+1,ans);
                subsetSum[i] -=arr[vidx];
                ans.get(i).remove(ans.get(i).size()-1);
                break;
            }
        }
    }
}
