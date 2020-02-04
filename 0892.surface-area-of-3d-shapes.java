/*
 * @lc app=leetcode id=892 lang=java
 *
 * [892] Surface Area of 3D Shapes
 *
 * https://leetcode.com/problems/surface-area-of-3d-shapes/description/
 *
 * algorithms
 * Easy (55.41%)
 * Total Accepted:    8.7K
 * Total Submissions: 15.8K
 * Testcase Example:  '[[2]]'
 *
 * On a N * N grid, we place some 1 * 1 * 1 cubes.
 * 
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of
 * grid cell (i, j).
 * 
 * Return the total surface area of the resulting shapes.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [[2]]
 * Output: 10
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,2],[3,4]]
 * Output: 34
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [[1,0],[0,2]]
 * Output: 16
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 32
 * 
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: [[2,2,2],[2,1,2],[2,2,2]]
 * Output: 46
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int surfaceArea(int[][] grid) {
        int ret = 0;
        int x = grid.length;
        int y = grid[0].length;
        for(int i=0;i<y;i++) {
            ret += grid[0][i] + grid[x-1][i];
        }
        for(int i=0;i<x;i++) {
            ret += grid[i][0] + grid[i][y-1];
        }
        for(int i=0;i<x;i++) {
            for(int j=0;j<y-1;j++) {
                ret += Math.abs(grid[i][j]-grid[i][j+1]);
            }
        }
        for(int j=0;j<y;j++) {
            for(int i=0;i<x-1;i++) {
                ret += Math.abs(grid[i][j]-grid[i+1][j]);
            }
        }
        for(int i=0;i<x;i++) {
            for(int j=0;j<y;j++) {
                if(grid[i][j]>0) {
                    ret++;ret++;
                }
            }
        }
        return ret;
    }

}
