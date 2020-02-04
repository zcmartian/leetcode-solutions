/*
 * @lc app=leetcode id=453 lang=java
 *
 * [453] Minimum Moves to Equal Array Elements
 *
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/description/
 *
 * algorithms
 * Easy (48.77%)
 * Total Accepted:    52.1K
 * Total Submissions: 106.9K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty integer array of size n, find the minimum number of moves
 * required to make all array elements equal, where a move is incrementing n -
 * 1 elements by 1.
 * 
 * Example:
 * 
 * Input:
 * [1,2,3]
 * 
 * Output:
 * 3
 * 
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 * 
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * 
 * 
 */
class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        int sum = min;
        for (int i = 1;i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            sum += nums[i];
        }
        return sum - min * nums.length;
    }
}
