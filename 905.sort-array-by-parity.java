/*
 * @lc app=leetcode id=905 lang=java
 *
 * [905] Sort Array By Parity
 *
 * https://leetcode.com/problems/sort-array-by-parity/description/
 *
 * algorithms
 * Easy (71.63%)
 * Total Accepted:    51K
 * Total Submissions: 71.2K
 * Testcase Example:  '[3,1,2,4]'
 *
 * Given an array A of non-negative integers, return an array consisting of all
 * the even elements of A, followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 *
 *
 *
 * Example 1:
 *
 *
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 *
 *
 *
 * Note:
 *
 *
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 *
 *
 *
 */
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int length = A.length;
        int[] ret = new int[length];
        int[] queue = new int[length];
        int j = 0;
        int k = 0;
        for (int i = 0; i < length; i++) {
            if (A[i] % 2 == 0) {
                ret[j++] = A[i];
            } else {
                queue[k++] = A[i];
            }
        }
        int offset = length - k;
        for (int i = 0; i < k; i++) {
            ret[offset + i] = queue[i];
        }
        return ret;
    }
}
