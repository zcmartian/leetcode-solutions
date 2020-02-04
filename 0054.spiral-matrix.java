/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (29.79%)
 * Total Accepted:    215K
 * Total Submissions: 721.6K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * Example 2:
 * 
 * Input:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 */
class Solution {
    private int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    private int[] ends;
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        int m = matrix.length;
        if(matrix==null || m==0)
            return ret;
        int n = matrix[0].length;
        ends = new int[] {n-1, m-1, 0, 1};
        int count = m * n;
        int direction = 0;
        int i = 0;
        int j = 0;
        while(count > 0) {
            ret.add(matrix[i][j]);
            count--;

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
