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
        int memo[] = new int[nums.length];
        Arrays.fill(memo, 1);
        for(int i=1;i<nums.length;i++) {
            for(int j=0;j<i;j++) {
                if(nums[i]>nums[j]) {
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                }
            }
        }

        int ret = memo[0];
        for(int i=1;i<memo.length;i++) {
            ret = Math.max(ret, memo[i]);
        }
        return ret;
    }
}
