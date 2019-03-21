/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 *
 * https://leetcode.com/problems/unique-paths/description/
 *
 * algorithms
 * Medium (46.68%)
 * Total Accepted:    266.6K
 * Total Submissions: 571.1K
 * Testcase Example:  '3\n2'
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * 
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 * 
 * Example 1:
 * 
 * 
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the
 * bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: m = 7, n = 3
 * Output: 28
 * 
 */
class Solution {
    int[] memo;
    int rows = 0;
    int cols = 0;
    public int uniquePaths(int m, int n) {
        memo = new int[m*n];
        rows = m;
        cols = n;
        return count(m-1, n-1);
    }
    private int count(int i, int j) {
        if(i == 0)
            return 1;
        if(j == 0)
            return 1;
        if(memo[i*cols+j] != 0)
            return memo[i*rows+j];
        return count(i-1, j) + count(i, j-1);
    }
}
