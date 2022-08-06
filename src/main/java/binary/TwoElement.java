package binary;

public class TwoElement {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{13, 13, 21, 21, 27, 50, 50, 102, 102, 108, 108, 110, 110, 117, 117, 120, 120, 123, 123, 124, 124, 132, 132, 164, 164, 166, 166, 190, 190, 200, 200, 212, 212, 217, 217, 225, 225, 238, 238, 261, 261, 276, 276, 347, 347, 348, 348, 386, 386, 394, 394, 405, 405, 426, 426, 435, 435, 474, 474, 493, 493}));
    }
    static public int solve(int[] A) {

        int l=1;
        int h=A.length-1;
        if(A.length==1){
            return A[0];
        }
        if(A[0]!=A[1]){
            return A[0];
        }
        if(A[A.length-1]!=A[A.length-2]){
            return A[A.length-1];
        }
        while(l<=h){
            int mid= (l+h)/2;

            if(A[mid]!=A[mid-1] && A[mid]!=A[mid+1]){
                return A[mid];
            }else if(A[mid]==A[mid-1]){
                l=mid+1;
            }else{
                h=mid-1;
            }
        }

        return 0;

    }
}
