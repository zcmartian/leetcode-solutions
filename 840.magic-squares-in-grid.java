/*
 * @lc app=leetcode id=840 lang=java
 *
 * [840] Magic Squares In Grid
 *
 * https://leetcode.com/problems/magic-squares-in-grid/description/
 *
 * algorithms
 * Easy (35.18%)
 * Total Accepted:    10.5K
 * Total Submissions: 29.9K
 * Testcase Example:  '[[4,3,8,4],[9,5,1,9],[2,7,6,2]]'
 *
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to
 * 9 such that each row, column, and both diagonals all have the same sum.
 * 
 * Given an grid of integers, how many 3 x 3 "magic square" subgrids are
 * there?  (Each subgrid is contiguous).
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [[4,3,8,4],
 * ⁠       [9,5,1,9],
 * ⁠       [2,7,6,2]]
 * Output: 1
 * Explanation: 
 * The following subgrid is a 3 x 3 magic square:
 * 438
 * 951
 * 276
 * 
 * while this one is not:
 * 384
 * 519
 * 762
 * 
 * In total, there is only one magic square inside the given grid.
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * 0 <= grid[i][j] <= 15
 * 
 * 
 */
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if(rows<3 || cols<3) return 0;
        int ret = 0;
        for(int i=0;i<=rows-3;i++) {
            for(int j=0;j<=cols-3;j++) {
                if(isMagic(grid,i,j))
                    ret++;
            }
        }
        return ret;
    }
    private boolean isMagic(int[][] grid, int row, int col) {
        int[] record = new int[10];
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (grid[i][j] < 1 || grid[i][j] > 9 || record[grid[i][j]] > 0) {
                    return false;
                }
                record[grid[i][j]] = 1;
            }
        }
        int sum1 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int sum2 = grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col];
        if (sum1 != sum2) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (grid[row + i][col] + grid[row + i][col + 1] + grid[row + i][col + 2] != sum1) {
                return false;
            }
            if (grid[row][col + i] + grid[row + 1][col + i] + grid[row + 2][col + i] != sum1) {
                return false;
            }
        }
        return true;
    }
}
