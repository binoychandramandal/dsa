package dynamicprogramming.tuf;

public class MaximumProductSubArray {
    public static void main(String[] args) {
        System.out.println(maxProductSubArray(new int[]{-1,0,-3,0,-4,-5}));
        System.out.println(maxProductSubArray1(new int[]{-1,0,-3,0,-4,-5}));
        System.out.println(maxProductSubArrayUsingTwoLoop(new int[]{-1,0,-3,0,-4,-5}));
        System.out.println(maxProductSubArrayUsingKadaneAlgorithm(new int[]{-1,0,-3,0,-4,-5}));
        System.out.println(maxProductSubArrayTwoLoop(new int[]{-1,0,-3,0,-4,-5}));
    }

    static int maxProductSubArray1(int arr[]) {
        int result = Integer.MIN_VALUE;
        for(int i=0;i<arr.length-1;i++)
            for(int j=i+1;j<arr.length;j++) {
                int prod = 1;
                for(int k=i;k<=j;k++)
                    prod *= arr[k];
                result = Math.max(result,prod);
            }
        return result;
    }

    static int maxProductSubArray(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int prod = 1;
                for (int k = i; k <= j; k++) {
                    prod *= a[k];
                }
                max = Math.max(prod, max);
            }
        }
        return max;
    }

    static int maxProductSubArrayUsingTwoLoop(int arr[]) {
        int result = arr[0];
        for(int i=0;i<arr.length-1;i++) {
            int p = arr[i];
            for(int j=i+1;j<arr.length;j++) {
                result = Math.max(result,p);
                p *= arr[j];
            }
            result = Math.max(result,p);
        }
        return result;
    }


    static int maxProductSubArrayUsingKadaneAlgorithm(int arr[]) {
        int prod1 = arr[0],prod2 = arr[0],result = arr[0];

        for(int i=1;i<arr.length;i++) {
            int temp = Math.max(arr[i],Math.max(prod1*arr[i],prod2*arr[i]));
            prod2 = Math.min(arr[i],Math.min(prod1*arr[i],prod2*arr[i]));
            prod1 = temp;

            result = Math.max(result,prod1);
        }

        return result;
    }

    static int maxProductSubArrayTwoLoop(int arr[]) {
        int maxLeft = arr[0];
        int maxRight = arr[0];

        boolean zeroPresent = false;

        int prod = 1;

        for(int i:arr) {
            prod *= i;
            if(i == 0) {
                zeroPresent = true;
                prod = 1;
                continue;
            }
            maxLeft = Math.max(maxLeft,prod);
        }

        prod = 1;

        for(int j=arr.length-1;j>=0;j--) {
            prod *= arr[j];
            if(arr[j] == 0) {
                zeroPresent = true;
                prod = 1;
                continue;
            }
            maxRight = Math.max(maxRight,prod);
        }

        if(zeroPresent) return Math.max(Math.max(maxLeft,maxRight),0);
        return Math.max(maxLeft,maxRight);
    }
}
