package sorting;

import java.util.*;

public class Test {

    public static  int solve(String A) {
        Scanner s=null;
        Map m=null;

        int[] freq=new int[26];
        for(int i=0;i<A.length();i++){
            freq[A.charAt(i)-'a']++;
        }
        int count=0;
        for(int i=0;i<freq.length;i++){
            if(freq[i]%2==1)
                count++;
        }
        if(count<=1)
            return 1;
        else
            return 0;

    }
    public static void main(String[] args) {
        System.out.println(solve("hddavxfqmfvgwicsgbunqokernzxslxuyffflngrhw"));
        List<Integer> l=Arrays.asList(947, 871, 859, 471, 763, 766, 379, 746, 485, 966, 10, 350, 341, 22, 706, 702, 717, 967, 641, 712, 10, 954, 751, 250, 777, 214, 820, 276, 708, 509, 123, 73, 593, 790, 797, 678, 320, 865, 392, 428, 611, 813, 655, 195, 102, 902, 919, 171, 706, 841, 873, 98, 128, 728, 878, 701, 874, 158, 548, 214, 414, 600, 869, 936, 841, 221, 87, 255, 233, 627, 487, 53, 270, 162, 517, 576, 240, 681, 172, 148, 86, 778, 205, 741, 483, 11, 795, 188, 450);
        Collections.sort(l);
        int count=0;
        for (int i = 1; i < l.size(); i++) {
            if(l.get(i)>l.get(i-1)){
                count++;
            }
        }
        System.out.println(l);
        System.out.println(new HashSet<>(l).size());
        System.out.println(l.size());
        System.out.println(count);



//        int nums[]={1};
//        new Test().rotate(nums,3);
//        System.out.println(Arrays.toString(nums));
    }
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }

    public void reverse(int[] nums,int i,int j){
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
}
