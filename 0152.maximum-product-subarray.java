/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 *
 * https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (28.57%)
 * Total Accepted:    191.4K
 * Total Submissions: 669.9K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 */
class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1)return nums[0];

        int dpMax = nums[0];
        int dpMin = nums[0];

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int k = dpMax*nums[i];
            int m = dpMin*nums[i];
            dpMax = Math.max(nums[i], Math.max(k, m));
            dpMin = Math.min(nums[i], Math.min(k, m));

            max = Math.max(dpMax, max);
        }
        return max;
    }
}
