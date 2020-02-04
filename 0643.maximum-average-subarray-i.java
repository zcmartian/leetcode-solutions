/*
 * @lc app=leetcode id=643 lang=java
 *
 * [643] Maximum Average Subarray I
 *
 * https://leetcode.com/problems/maximum-average-subarray-i/description/
 *
 * algorithms
 * Easy (38.55%)
 * Total Accepted:    43.3K
 * Total Submissions: 112.3K
 * Testcase Example:  '[1,12,-5,-6,50,3]\n4'
 *
 * 
 * Given an array consisting of n integers, find the contiguous subarray of
 * given length k that has the maximum average value. And you need to output
 * the maximum average value.
 * 
 * 
 * Example 1:
 * 
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 * 
 * 
 * 
 * Note:
 * 
 * 1 k n 
 * Elements of the given array will be in the range [-10,000, 10,000].
 * 
 * 
 */
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int max = -10000 * k;
        for ( int i = 0; i <= nums.length - k;i++ ) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += nums[i + j];
            }
            max = Math.max(max, sum);
        }
        double ret = (double) max / k;
        return ret;
    }
}
