/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 *
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (45.86%)
 * Total Accepted:    214.5K
 * Total Submissions: 467.7K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * 
 * 
 */
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;

        int[] dp = new int[cols];
        dp[0] = rows > 1 ? grid[1][0] : grid[0][0];
        for(int i=1;i<cols;i++)
            dp[i] = grid[0][i];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(i==0 && j==0)
                    dp[j] = grid[i][j];
                else if(i==0)
                    dp[j] = grid[i][j] + dp[j-1];
                else if(j==0)
                    dp[j] = grid[i][j] + dp[j];
                else
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j-1]);
            }
        }
        return dp[cols - 1];
    }
}
