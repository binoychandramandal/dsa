package binary.tuf;

public class KthElementOfSortedArray {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7};
        int[] b = {2, 4, 6, 9};
        System.out.println(getMedian(a, b,8));
    }

    private static double getMedian(int[] a, int[] b,int k) {
        if (b.length > a.length) {
            int[] t = a;
            a = b;
            b = t;
        }
        int n1=a.length;
        int n2=b.length;
        int low= Math.max(0,k-n2);
        int high = Math.min(k,n1);

        while (low<=high){
            int cut1 = (low+high)>>1;
            int cut2 = k-cut1;

            int left1 =cut1==0?Integer.MIN_VALUE:a[cut1-1];
            int left2 =cut2==0?Integer.MIN_VALUE:b[cut2-1];
            int right1 =cut1==n1?Integer.MAX_VALUE:a[cut1];
            int right2 =cut2==n1?Integer.MAX_VALUE:b[cut2];

            if(left1<=right2 && left2<=right1){
                return Math.max(left1,left2);
            }else if(left1>right2){
                high=cut1-1;
            }else{
                low = cut1+1;
            }
        }
        return Integer.MIN_VALUE;
    }

}
