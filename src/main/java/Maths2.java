import java.util.Arrays;

public class Maths2 {
    public static void main(String[] args) {
        System.out.println(findNearestPowerOf2(100));
        System.out.println(Arrays.toString(rearrangeNegativePositive(new int[]{0, 1, -2, -3, -4})));
        System.out.println(findMajority(new int[]{6, 6, 8, 4, 4, 7, 4, 4, 4, 4, 4, 6}));
        System.out.println(fintMajo(new int[]{6, 6, 8, 4, 4, 7, 4, 4, 4, 4, 4}));


        System.out.println(findNthMagicalNumber(11));




    }

   static int findNthMagicalNumber(int n){
        int pow=1;
        int answer =0;
        while(n>0){
            pow*=5;
            if((n&1)==1){
                answer+=pow;
            }
            n>>=1;
        }
        return answer;
    }

    static int fintMajo(int[] a) {

        Integer mla = -1;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (count == 0) {
                mla = a[i];
                count++;
            } else if (mla!=null && a[i] == mla) {
                count++;
            } else {
                if(count==1)
                    mla=null;
                count--;
            }

        }
        int r=0;
        for (int i = 0; i < a.length; i++) {
            if(a[i]==mla){
                r++;
            }

        }
        if(r>=a.length/2){
            return mla;
        }
        return -1;
    }

    // Function to find majority element
    public static int findMajority(int[] nums) {
        int count = 0, candidate = -1;

        // Finding majority candidate
        for (int index = 0; index < nums.length; index++) {
            if (count == 0) {
                candidate = nums[index];
                count = 1;
            } else {
                if (nums[index] == candidate)
                    count++;
                else
                    count--;
            }
        }

        // Checking if majority candidate occurs more than
        // n/2 times
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == candidate)
                count++;
        }
        if (count > (nums.length / 2))
            return candidate;
        return -1;

        // The last for loop and the if statement step can
        // be skip if a majority element is confirmed to
        // be present in an array just return candidate
        // in that case
    }

    static int findNearestPowerOf2(int n) {
        if (n <= 0) {
            return 0;
        }
        int result = n;
        for (int i = n; i >= 1; i--) {
            if ((i & (i - 1)) == 0) {
                result = i;
                break;
            }
        }
        return result;
    }

    static int[] rearrangeNegativePositive(int[] a) {
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            if (a[i] < 0 && a[j] > 0) {
                i++;
                j--;
            } else if (a[i] < 0 && a[j] < 0) {
                i++;
            } else if (a[i] >= 0 && a[j] < 0) {
                int tm = a[j];
                a[j] = a[i];
                a[i] = tm;
                i++;
                j--;
            }
        }
        return a;
    }
}
