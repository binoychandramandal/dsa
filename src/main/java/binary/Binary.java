package binary;

public class Binary {
    public static void main(String[] args) {
   int[] a=new int[]{1,2,3,4,5,6};
        System.out.println(isPresent(a,1));
        System.out.println(isPresent(a,6));
        System.out.println(isPresent(a,3));
        System.out.println(isPresent(a,10));
        System.out.println(isPresent(a,-1));
    }

    static  int isPresent(int[] a,int key){
        int s =0;
        int e=a.length-1;
        while (s<=e){
            int mid = s+(e-s)/2;
            if(a[mid]==key){
                return mid;
            }else if(a[mid]>key){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return -1;
    }
}
