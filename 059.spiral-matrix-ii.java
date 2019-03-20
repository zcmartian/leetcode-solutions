/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 *
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (45.58%)
 * Total Accepted:    129.4K
 * Total Submissions: 283.9K
 * Testcase Example:  '3'
 *
 * Given a positive integer n, generate a square matrix filled with elements
 * from 1 to n^2 in spiral order.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 8, 9, 4 ],
 * ⁠[ 7, 6, 5 ]
 * ]
 * 
 * 
 */
class Solution {
    private int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    private int[] ends;

    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int count = n * n;    
        int direction = 0;
        int i = 0;
        int j = 0;
        ends = new int[] {n-1, n-1, 0, 1};
        int cur = 1;
        while(cur <= count) {
            ret[i][j] = cur;
            if(atEdge(i, j, direction)) {
                direction = (direction + 1) % 4;
                if(direction==0) {
                    ends[0]--;
                    ends[1]--;
                    ends[2]++;
                    ends[3]++;
                }
            }
            int di = directions[direction][0];
            int dj = directions[direction][1];
            i += di;
            j += dj;
            
            cur++;
        }
        return ret;
    }

    private boolean atEdge(int i, int j, int direction) {
        switch(direction) {
            case 0:
                return j==ends[0];
            case 1:
                return i==ends[1];
            case 2:
                return j==ends[2];
            case 3:
                return i==ends[3];
        }
        return false;
    }
}
