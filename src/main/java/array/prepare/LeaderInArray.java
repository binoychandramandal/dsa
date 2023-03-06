package array.prepare;

/**
 * Problem:
 * Print all the LEADERS in the array.
 * An element is leader if it is greater than all the elements to its right side.
 *
 * The rightmost element is always a leader.
 *
 * Example:
 *
 * Input: [13, 15, 6, 7, 8, 3]
 *
 * Output: 15, 8, 3
 *
 * Approach-1: Brute Force
 * Use two loops, the outer loop runs one by one picks all elements from left to right.
 * The inner loop compares the picked element to all the elements to its right side.
 * If the picked element is greater than all the elements to its right side, then the picked element is the leader.
 * Time Complexity: O(n2)
 * Approach-2: Scan from right
 * Scan all the elements from right to left in an array and keep track of maximum till now.
 * When maximum changes its value, print it.
 * Time Complexity: O(n)
 */
public class LeaderInArray {
    public static void main(String[] args) {
        //printLeader(new int[]{13, 15, 6, 7, 8, 3});
        //printLeader(new int[]{1,2,3,4});
        //printLeader(new int[]{4,3,2,1});
        //printLeader1(new int[]{4,3,2,1});
        //printLeader1(new int[]{1,2,3,4});
        printLeader1(new int[]{13, 15, 6, 7, 8, 3});
    }

    /**
     * Using two for loop
     * @param a
     */
    static void printLeader(int[]a){
        for (int i = 0; i < a.length; i++) {
            boolean isAllMax =true;
            for (int j = i+1; j < a.length; j++) {
                 if(a[i]<a[j]){
                     isAllMax=false;
                     break;
                 }
            }
            if(isAllMax){
                System.out.println(a[i]);
            }
        }
    }

    /**
     * Traverse from end and keep track max of right
     * @param a
     */
    static void printLeader1(int[]a){
        int max =a[a.length-1];
        System.out.println(max);
        for (int i = a.length-2; i >=0; i--) {
            if(a[i]>max){
                System.out.println(a[i]);
                max =a[i];
            }
        }
    }

}
