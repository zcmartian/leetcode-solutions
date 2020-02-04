/*
 * @lc app=leetcode id=463 lang=java
 *
 * [463] Island Perimeter
 *
 * https://leetcode.com/problems/island-perimeter/description/
 *
 * algorithms
 * Easy (59.94%)
 * Total Accepted:    117.8K
 * Total Submissions: 196.6K
 * Testcase Example:  '[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]'
 *
 * You are given a map in form of a two-dimensional integer grid where 1
 * represents land and 0 represents water.
 * 
 * Grid cells are connected horizontally/vertically (not diagonally). The grid
 * is completely surrounded by water, and there is exactly one island (i.e.,
 * one or more connected land cells).
 * 
 * The island doesn't have "lakes" (water inside that isn't connected to the
 * water around the island). One cell is a square with side length 1. The grid
 * is rectangular, width and height don't exceed 100. Determine the perimeter
 * of the island.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input:
 * [[0,1,0,0],
 * ⁠[1,1,1,0],
 * ⁠[0,1,0,0],
 * ⁠[1,1,0,0]]
 * 
 * Output: 16
 * 
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 * 
 * 
 * 
 * 
 */
class Solution {
    public int islandPerimeter(int[][] grid) {
        int ones = 0;
        int ret = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    ones += 1;
                    ret += sides(grid,i,j);
                }
            }
        }
        return 4*ones - ret;
    }
    private int sides(int[][] grid, int i, int j) {
        int ret = 0;
        if(j-1>=0&&grid[i][j-1]==1)
            ret += 1;
        if(j+1<=grid[i].length-1&&grid[i][j+1]==1)
            ret += 1;
        if(i-1>=0&&grid[i-1][j]==1)
            ret += 1;
        if(i+1<=grid.length-1&&grid[i+1][j]==1)
            ret +=1;
        return ret;
    }
}
