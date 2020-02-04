/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 *
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (40.42%)
 * Total Accepted:    206.7K
 * Total Submissions: 511.2K
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * Example:
 * 
 * 
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4 
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore
 * the length is 4. 
 * 
 * Note: 
 * 
 * 
 * There may be more than one LIS combination, it is only necessary for you to
 * return the length.
 * Your algorithm should run in O(n^2) complexity.
 * 
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 * 
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, Integer.MIN_VALUE);

        int len = 1;
        dp[1] = nums[0];
        for(int i=1;i<nums.length;i++) {
            if(dp[len]< nums[i]) {
                dp[++len] = nums[i];
            } else {
                int index = lowerBound(dp, 0, len, nums[i]);
                if(dp[index] != nums[i]) {
                    dp[index] = Math.min(dp[index], nums[i]);
                }
            }
        }
        return len;
    }

    private int lowerBound(int[] dp, int l, int r, int target) {
        int left = l , right = r + 1;
        while(left != right) {
            int mid = left + (right - left) / 2;
            if(dp[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
