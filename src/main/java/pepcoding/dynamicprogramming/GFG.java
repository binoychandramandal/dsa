package pepcoding.dynamicprogramming;

import java.util.*;

class GFG {

    public static void main(String[] args) {
        // System.out.println(new GFG().find(new long[]{1 ,1, 1 ,2 ,3 ,3 ,3 ,4 ,4, 4 ,4 ,4 ,5, 5 ,6 ,7 ,7, 7 ,8, 8 ,8 ,8 ,9, 9, 9, 9, 9 ,10 ,10 ,10}, 9, 8));
        // System.out.println(floorSqrt(4));

        long[] v = new long[]{1, 4, 4, 4, 5};
        //System.out.println(getFirstIndex(v,4)+" "+getLastIndex(v,4));
        //System.out.println(findPeakElement(Arrays.asList(1,2,3,4,5,6,5,4)));
        //System.out.println(findPeakElement(Arrays.asList(1,2,3,4,5,6)));
        // System.out.println(leaders(new int[]{16 ,17, 4, 3 ,5, 2},0));
        //System.out.println(firstRepeated(new int[]{1, 5, 3, 4, 3, 5, 6}, 0));
int [] r=new int[]{5,4,6,3,8,1};
        mergeSort(r,0,5);
        System.out.println(Arrays.toString(r));
    }

    static void merge(int arr[], int l, int m, int r)
    {
        int[] temp=new int[r-l+1];
        int ol =l;
        int oh = m;

        int ol1 = m+1;
        int oh1 = r;
        int i=0;
        while(ol<=oh && ol1<=oh1){
            if(arr[ol]<arr[ol1]){
                temp[i++] = arr[ol++];
            }else{
                temp[i++] = arr[ol1++];
            }
        }

        while(ol<=oh){
            temp[i++] = arr[ol++];
        }
        while(ol1<=oh1){
            temp[i++] = arr[ol1++];
        }
        int k=0;
        for(int kk=l;kk<=r;kk++){
            arr[kk]=temp[k++];
        }
    }
   static void mergeSort(int arr[], int l, int r)
    {
        if(l<r){
            int mid = l+(r-l)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }
    }

    public static int firstRepeated(int[] arr, int n) {
        Set<Integer> m = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (m.contains(arr[i])) {
                return arr[i];
            } else {
                m.add(arr[i]);
            }
        }
        return -1;
    }



    static ArrayList<Integer> leaders(int arr[], int n) {
        Stack<Integer> s = new Stack<>();
        s.push(arr[arr.length - 1]);
        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > s.peek()) {

                l.add(arr[i]);
            }
            if (s.isEmpty()) {
                s.push(arr[i]);
                continue;
            }
            if (arr[i] > s.peek()) {
                s.push(arr[i]);
            }
        }
        Collections.reverse(l);
        return l;
    }

    static public int findPeakElement(List<Integer> a) {
        int s = 0;
        int h = a.size() - 1;

        while (s <= h) {
            int mid = s + (h - s) / 2;
            if (a.get(mid) > a.get(mid - 1) && mid + 1 < a.size() && a.get(mid) > a.get(mid + 1)) {
                return a.get(mid);
            } else if (a.get(mid) > a.get(mid - 1) && mid + 1 < a.size() && a.get(mid) < a.get(mid + 1)) {
                s = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return a.get(a.size() - 1);
    }


    static long getFirstIndex(long v[], long x) {
        int s = 0;
        int h = v.length - 1;
        long ans = -1;
        while (s <= h) {
            int mid = s + (h - s) / 2;
            if (v[mid] == x) {
                ans = mid;
                h = mid - 1;
            } else if (v[mid] < x) {
                s = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return ans;
    }

    static long getLastIndex(long v[], long x) {
        int s = 0;
        int h = v.length - 1;
        long ans = -1;
        while (s <= h) {
            int mid = s + (h - s) / 2;
            if (v[mid] == x) {
                ans = mid;
                s = mid + 1;
            } else if (v[mid] < x) {
                s = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return ans;
    }


    static long floorSqrt(long x) {
        long i = 0;
        long j = x;
        long ans = 0;
        while (i <= j) {
            long mid = i + (j - i) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid > x) {
                j = mid - 1;
            } else {
                ans = mid;
                i = mid + 1;
            }
        }
        return ans;
    }

    ArrayList<Long> find(long arr[], int n, int x) {
        ArrayList<Long> r = new ArrayList<>();
        int f1 = getFirstOccurence(arr, x);

        if (f1 == -1) {
            r.add(-1l);
            return r;
        }

        int f2 = getLastOccurence(arr, x);
        if (f2 == -1) {
            r.add(-1l);
            return r;
        }


        r.add(f1 + 0l);
        r.add(f2 + 0l);
        return r;
    }


    int getFirstOccurence(long[] a, int x) {
        int s = 0;
        int h = a.length - 1;
        int ans = -1;
        while (s <= h) {
            int mid = s + (h - s) / 2;
            if (a[mid] == x) {
                ans = mid;
                h = mid - 1;
            } else if (a[mid] > x) {

                h = mid - 1;
            } else if (a[mid] < x) {
                s = mid + 1;
            }

        }
        return ans;
    }

    int getLastOccurence(long[] a, int x) {
        int s = 0;
        int h = a.length - 1;
        int ans = -1;
        while (s <= h) {
            int mid = s + (h - s) / 2;
            if (a[mid] == x) {
                ans = mid;
                s = mid + 1;
            } else if (a[mid] > x) {
                h = mid - 1;
            } else {
                s = mid + 1;
            }

        }
        return ans;
    }
}
