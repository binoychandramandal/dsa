package binary;

public class Floor {
    public static void main(String[] args) {
   int[] a=new int[]{-1,0,1,2,3,4,5,6,8};
        System.out.println(floor(a,1));
        System.out.println(floor(a,6));
        System.out.println(floor(a,3));
        System.out.println(floor(a,10));
        System.out.println(floor(a,-1));
    }

    static  int floor(int[] a, int key){
        int s =0;
        int e=a.length-1;
        int ans=Integer.MIN_VALUE;
        while (s<=e){
            int mid = s+(e-s)/2;
            if(a[mid]==key){
                return a[mid];
            }else if(a[mid]>key){
                e=mid-1;
            }else{
                s=mid+1;
                ans=a[mid];
            }
        }
        return ans;
    }
}
