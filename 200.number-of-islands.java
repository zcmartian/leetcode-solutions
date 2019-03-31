/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 *
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (40.75%)
 * Total Accepted:    322K
 * Total Submissions: 790.2K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * Output: 3
 * 
 */
class Solution {
    private int m = 0, n = 0;
    public int numIslands(char[][] grid) {
        int count = 0;
        m = grid.length;
        if(m == 0) return 0;
        n = grid[0].length;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]=='1') {
                    search(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void search(char[][] grid, int i, int j) {
        if(i<0||j<0||i>=m||j>=n||grid[i][j]!='1')
            return;

        grid[i][j]='0';
        search(grid, i+1, j);
        search(grid, i-1, j);
        search(grid, i, j+1);
        search(grid, i, j-1);
    }
}
