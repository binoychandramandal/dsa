package pepcoding.backtracking.practice;

import java.util.ArrayList;
import java.util.List;

public class KPartitionSubset    {
    public static void main(String[] args) {
        int k =3;
        List<List<Integer>> asf =new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            asf.add(new ArrayList<>());
        }
        partition(1,4,0,k,asf);
    }
    static void partition(int i , int n, int ssf,int k, List<List<Integer>> asf){
        if(i>n){
            if(ssf==k){
                for (List<Integer> ele : asf) {
                    System.out.print(ele+" ");
                }
                System.out.println();
            }
            return;
        }
        for (int j = 0; j < asf.size(); j++) {
            if(asf.get(j).size()>0){
                asf.get(j).add(i);
                partition(i+1,n,ssf,k,asf);
                asf.get(j).remove(asf.get(j).size()-1);
            }else{
                asf.get(j).add(i);
                partition(i+1,n,ssf+1,k,asf);
                asf.get(j).remove(asf.get(j).size()-1);
                break;
            }
        }
    }
}
