package pepcoding.backtracking.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EqualSubSetPartition {
    public static void main(String[] args) {
        equalSum(new int[]{1,2,3,4,5,6,7,8,9},4);

    }

    static void equalSum(int[] arr,int k){
      int sum =   Arrays.stream(arr).sum();
      if(k==1){
          System.out.println(Arrays.toString(arr));
          return;
      }
      if(k>arr.length || sum%k!=0){
          System.out.println("-1");
          return;
      }

      int[] subSetSum =new int[k];
        List<List<Integer>> ans =new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(new ArrayList<>());
        }
        solution(arr,0,arr.length,k,subSetSum,0,ans);
    }


    static void solution(int[] arr,int vidx,int n,int k,int[] subsetSum,int ssssf,List<List<Integer>> ans){

        if(arr.length==vidx){
            if(ssssf==k){
                boolean flag =true;
                for (int i = 0; i < subsetSum.length-1; i++) {
                    if(subsetSum[i]!=subsetSum[i+1]){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    for(List<Integer> partition :ans){
                        System.out.print(partition+" ");
                    }
                    System.out.println();
                }
            }
            return;
        }
        for (int i = 0; i < ans.size(); i++) {
            if(ans.get(i).size()>0){
                subsetSum[i] += arr[vidx];
                ans.get(i).add(arr[vidx]);
                solution(arr,vidx+1,n,k,subsetSum,ssssf,ans);
                subsetSum[i] -= arr[vidx];
                ans.get(i).remove(ans.get(i).size()-1);
            }else{
                subsetSum[i] += arr[vidx];
                ans.get(i).add(arr[vidx]);
                solution(arr,vidx+1,n,k,subsetSum,ssssf+1,ans);
                subsetSum[i] -= arr[vidx];
                ans.get(i).remove(ans.get(i).size()-1);
                break;
            }
        }
    }


}
