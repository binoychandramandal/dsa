package binary.tuf;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {

        int[]a ={4,5,6,7,0,1,2};
        System.out.println(find(a,9));

        int[]b ={1,2,2,3,3};
        System.out.println(find(b,1));

    }

    static boolean find(int[] a,int target) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if(a[mid] == target)
                return true;
            if(a[low]<=a[mid]){
               if(target>=a[low] && target<=a[mid]){
                   high=mid-1;
               }else{
                   low=mid+1;
               }
            }else{
                if(target>=a[mid] && target<=a[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return false;
    }
}
