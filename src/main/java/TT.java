import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class TT {
    public static void main(String[] args) {

      //  System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        //System.out.println(trap(new int[]{4,2,0,3,2,5}));
        //System.out.println(maxProduct(new int[]{-10, -3, 5, 6, -2}));
        System.out.println(maxProduct1(new int[]{-10, -3, 5, 6, -2}));
    }


    static int maxProduct(int[] a){
        int sum = 0;
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i+1; j < a.length; j++) {
                int t =a[i]*a[j];
                if(sum<=t){
                    System.out.println(a[i]+" : "+a[j]);
                    sum = a[i]*a[j];
                }
            }
        }
        return sum;
    }

    static int maxProduct1(int[] a){
//1,2,3,4
        //-1,-2
        int fMax =a[0];
        int sMax =a[0];
        int fMin =a[0];
        int sMin =Integer.MAX_VALUE;

        for (int i = 1; i < a.length; i++) {

            if(fMax<a[i]){
                sMax =fMax;
                fMax=a[i];
            }else if(sMax<a[i]){
                sMax =a[i];
            }

           if(fMin>a[i]){
               sMin =fMin;
               fMin = a[i];
           }else if(sMin>a[i]) {
               sMin = a[i];
           }

        }
        System.out.println(fMax+" "+sMax+" "+fMin+""+sMin);
        return Math.max(fMax*sMax,fMin*sMin);
    }

    public static int trap(int[] height) {

        int sum =0;

       int[] leftMax = new int[height.length];
       leftMax[0]=height[0];
       int[] rightMax = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];
        for (int i = 1; i <= height.length-1; i++) {
             leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }

        for (int i = height.length-2; i >=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }


        for(int i=1;i<height.length-1;i++){
            int min = Math.min(leftMax[i],rightMax[i]);
            if(min-height[i]>0){
                sum+=(min-height[i]);
            }
        }
        return sum;
    }


}
