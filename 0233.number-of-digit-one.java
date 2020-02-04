/*
 * @lc app=leetcode id=233 lang=java
 *
 * [233] Number of Digit One
 *
 * https://leetcode.com/problems/number-of-digit-one/description/
 *
 * algorithms
 * Hard (30.03%)
 * Total Accepted:    39.9K
 * Total Submissions: 132.9K
 * Testcase Example:  '13'
 *
 * Given an integer n, count the total number of digit 1 appearing in all
 * non-negative integers less than or equal to n.
 * 
 * Example:
 * 
 * 
 * Input: 13
 * Output: 6 
 * Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 * 
 * 
 */
class Solution {
    public int countDigitOne(int n) {
        int count = 0;

        for (long k = 1; k <= n; k *= 10) {
            long r = n / k, m = n % k;
            // sum up the count of ones on every place k
            count += (r + 8) / 10 * k + (r % 10 == 1 ? m + 1 : 0);
        }

        return count;
    }
}
