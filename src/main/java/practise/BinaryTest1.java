package practise;

import java.util.Arrays;

public class BinaryTest1 {
    public static void main(String[] args) {
        //searchTest();
        //floorTest();
       // searchFirstFrequencyTest();
        //searchLastFrequencyTest();
        //occuranceTest();
        //rotatedArrayTest();

        System.out.println(countRotation(new int[]{1}));
        System.out.println(countRotation(new int[]{1,2,3,4,5}));
        System.out.println(countRotation(new int[]{5,1,2,3,4}));
        System.out.println(countRotation(new int[]{4,5,1,2,3}));
        System.out.println(countRotation(new int[]{2,3,4,5,1}));
        System.out.println(countRotation(new int[]{1,2,3,4,5}));
    }

    public static int countRotation(int[] a){
        if(a.length==1){
            return 0;
        }
        int l=0;
        int h =a.length-1;
        int ans =0;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(a[mid]<a[0]){
                ans=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        if(ans==0){
            return 0;
        }else return ans;
    }
    public static int search1(final int[] A, int B) {
        if(A.length==1 ){
            if(A[0]==B)
                return 0;
            else return -1;
        }
        if(A[0]<=A[A.length-1]){
            return bs(A,0,A.length-1,B);
        }
        int index = findIndex(A);
        if(B<A[0]){
            return bs(A,index,A.length-1,B);
        }else{
            return bs(A,0,index-1,B);
        }
        // return -1;

    }

    static void  rotatedArrayTest(){
        int[] a=new int[]{101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100 };
        int B=202;
        //System.out.println(bs(a,0,9,B));
        // System.out.println(findIndex(new int[]{ 1, 7, 67, 133, 178}));
        //System.out.println(findIndex(new int[]{ 178,1, 7, 67, 133}));
        System.out.println( search1(new int[]{},10));
    }

    public  static  int bs(int[] a,int i,int j,int k){
        int l=i;
        int h=j;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(a[mid]==k){
                return mid;
            }
            if(a[mid]>k){
                h=mid-1;

            }else{
                l=mid+1;
            }
        }
        return -1;
    }

    public static  int findIndex(int[] a){
        int l=0;
        int h=a.length-1;
        int k=0;
        while(l<=h){
            int mid= l+(h-l)/2;
            if(a[mid]<a[0]){
                k = mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return k;
    }

    static void searchTest(){
        System.out.println(search(new int[]{1, 2, 3, 4, 20, 50}, 20));
        System.out.println(search(new int[]{1, 2, 3, 4, 20, 50}, 0));
        System.out.println(search(new int[]{1, 2, 3, 4, 20, 50}, 60));
    }

    static int search(int[] a, int k) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (a[mid] == k) {
                return mid;
            } else if (a[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    static void searchFirstFrequencyTest(){
        System.out.println(searchFirstFrequency(new int[]{1,2,2,2,2,2,3},2));
        System.out.println(searchFirstFrequency(new int[]{1,2,2,2,2,2,3,3},3));
    }

    static  void occuranceTest(){
        System.out.println(occurance(new int[]{1,2,2,2,2,2,3},2));
        System.out.println(occurance(new int[]{1,2,2,2,2,2,3,3},3));
    }
    static int occurance(int[] a,int k){
        int p1=searchFirstFrequency(a,k);
        int p2=searchLastFrequency(a,k);
        return p2-p1+1;

    }


    static int searchFirstFrequency(int[] a, int k) {
        int start = 0;
        int end = a.length - 1;
        int ans=-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == k) {
                end = mid - 1;
               ans= mid;
            } else if (a[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
    static void searchLastFrequencyTest(){
        System.out.println(searchLastFrequency(new int[]{1,2,2,2,2,2,3},2));
        System.out.println(searchLastFrequency(new int[]{1,2,2,2,2,2,3,3},3));
    }
    static int searchLastFrequency(int[] a, int k) {
        int start = 0;
        int end = a.length - 1;
        int ans=-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == k) {
                start = mid + 1;
                ans= mid;
            } else if (a[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }


    static void floorTest(){
        System.out.println(floor(new int[]{1,3,4,5},2));
        System.out.println(floor(new int[]{1,3,4,5},10));
        System.out.println(floor(new int[]{1,3,5,6},4));
    }
    static int floor(int[] a, int k) {
        int start = 0;
        int end = a.length - 1;
        int ans=0;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (a[mid] == k) {
                return mid;
            } else if (a[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
                ans =a[mid];
            }
        }
        return ans;
    }
}
