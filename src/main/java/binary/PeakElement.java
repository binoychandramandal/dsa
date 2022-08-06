package binary;

public class PeakElement {
    public static void main(String[] args) {
        int[] a = new int[]{-1, 0, 1, 2, 3, 3, 3, 4, 5, 6, 8};
        System.out.println(peakElement(a));
    }


    static int peakElement(int[] a) {
        if(a[0]>a[a.length-1]){
            return a[0];
        }
        if(a[a.length-1]>a[a.length-2]){
            return a[a.length-1];
        }
        int s = 0;
        int e = a.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (a[mid]>a[mid-1] && a[mid]>a[mid+1]) {
               return a[mid];
            } else if (a[mid] > a[mid+1]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }
}
