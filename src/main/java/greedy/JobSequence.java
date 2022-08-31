package greedy;

import java.util.Arrays;

public class JobSequence {
    public static void main(String[] args) {
        Job[] arr = new Job[4];
        arr[0] = new Job(1, 4, 20);
        arr[1] = new Job(2, 1, 10);
        arr[2] = new Job(3, 2, 40);
        arr[3] = new Job(4, 2, 30);
        System.out.println(Arrays.toString(jobScheduling(arr,arr.length)));
    }

   static int[] jobScheduling(Job arr[], int n) {
        //1. sort according to profit in  descending order
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));
        //2. Get the max deadline
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > maxi) {
                maxi = arr[i].deadline;
            }
        }
        //3. Create max deadline array and initialize with -1
        int result[] = new int[maxi + 1];
        Arrays.fill(result, -1);
        int countJobs = 0, jobProfit = 0;
        for (int i = 0; i < n; i++) {
            //check for slot
            for (int j = arr[i].deadline; j > 0; j--) {
                // Free slot found
                if (result[j] == -1) {
                    result[j] = i;
                    countJobs++;
                    jobProfit += arr[i].profit;
                    break;
                }
            }
        }
        int ans[] = new int[2];
        ans[0] = countJobs;
        ans[1] = jobProfit;
        return ans;
    }

    static class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }
}
