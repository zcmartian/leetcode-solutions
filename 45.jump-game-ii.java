/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 *
 * https://leetcode.com/problems/jump-game-ii/description/
 *
 * algorithms
 * Hard (27.46%)
 * Total Accepted:    154.6K
 * Total Submissions: 562.9K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * Example:
 * 
 * 
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * ⁠   Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Note:
 * 
 * You can assume that you can always reach the last index.
 * 
 */
class Solution {
    public int jump(int[] nums) {
        int jumps = 0, curEnd = 0, curFar = 0;
        for(int i=0;i<nums.length-1;i++) {
            curFar = Math.max(curFar, i + nums[i]);
            if(i == curEnd) {
                jumps++;
                curEnd = curFar;
            }
        }
        return jumps;
    }
}
