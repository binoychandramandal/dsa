package greedy;

import java.util.Arrays;
import java.util.stream.Stream;

public class MinimumPlatformRequired {
    public static void main(String[] args) {
        int[] arr = {900, 945, 955, 1100, 1500, 1800};
        int[] dep = {920, 1200, 1130, 1150, 1900, 2000};
        int n = arr.length;
        int totalCount = countPlatforms(n, arr, dep);
        System.out.println("Minimum number of Platforms required " + totalCount);
        System.out.println("Minimum number of Platforms required " + maxTrainCountAtParticularTime(arr,dep));
    }

    static int countPlatforms(int n, int arr[], int dep[]) {
        int ans = 1; //final value
        for (int i = 0; i < n; i++) {
            int count = 1; // count of overlapping interval of only this   iteration
            for (int j = i + 1; j < n; j++) {
                if ((arr[i] >= arr[j] && arr[i] <= dep[j]) || (arr[j] >= arr[i] && arr[j] <= dep[i])) {
                    count++;
                }
            }
            ans = Math.max(ans, count); //updating the value
        }
        return ans;
    }


    static int maxTrainCountAtParticularTime(int[] arr, int[] dep) {
        //1. sort both array
        Arrays.sort(arr);
        Arrays.sort(dep);


        //2. Get max train at a particular time
        int i = 0;
        int j = 0;
        int trainCount = 0;
        int maxTrainAtTime = 0;
        while (i < arr.length && j < dep.length) {
            if (arr[i] <= dep[j]) {
                trainCount++;
                i++;
            } else {
                trainCount--;
                j++;
            }
            maxTrainAtTime = Math.max(maxTrainAtTime, trainCount);
        }
        return maxTrainAtTime;

    }

}
