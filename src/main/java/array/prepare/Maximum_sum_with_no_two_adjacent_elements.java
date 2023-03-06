package array.prepare;

/**
 * Problem:
 * Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers in the sequence should be adjacent in the array.
 * So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).
 *
 * Example:
 *
 * Input: arr[] = {5, 5, 10, 100, 10, 5}   Output: 110
 *
 * Input: arr[] = {1, 2, 3}   Output: 4
 *
 * Input: arr[] = {1, 20, 3}   Output: 20
 *
 * Algorithm:
 * Start with two sums excluded and included.
 * Loop for all the elements and:
 * Calculate new_excluded as the max(included, excluded) as current element is still not added to the included.
 * Now change the included by adding current to excluded as no two adjacents should be present.
 * Finally update the exluded with new_excluded.
 * Return the max(included, excluded).
 */
public class Maximum_sum_with_no_two_adjacent_elements {
}
