/*
 * @lc app=leetcode id=766 lang=java
 *
 * [766] Toeplitz Matrix
 *
 * https://leetcode.com/problems/toeplitz-matrix/description/
 *
 * algorithms
 * Easy (61.02%)
 * Total Accepted:    51.5K
 * Total Submissions: 84.4K
 * Testcase Example:  '[[1,2,3,4],[5,1,2,3],[9,5,1,2]]'
 *
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the
 * same element.
 * 
 * Now given an M x N matrix, return True if and only if the matrix is
 * Toeplitz.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * matrix = [
 * [1,2,3,4],
 * [5,1,2,3],
 * [9,5,1,2]
 * ]
 * Output: True
 * Explanation:
 * In the above grid, the diagonals are:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
 * In each diagonal all elements are the same, so the answer is True.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * matrix = [
 * [1,2],
 * [2,2]
 * ]
 * Output: False
 * Explanation:
 * The diagonal "[1, 2]" has different elements.
 * 
 * 
 * 
 * Note:
 * 
 * 
 * matrix will be a 2D array of integers.
 * matrix will have a number of rows and columns in range [1, 20].
 * matrix[i][j] will be integers in range [0, 99].
 * 
 * 
 * 
 * Follow up:
 * 
 * 
 * What if the matrix is stored on disk, and the memory is limited such that
 * you can only load at most one row of the matrix into the memory at once?
 * What if the matrix is so large that you can only load up a partial row into
 * the memory at once?
 * 
 * 
 */
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int j=n-2;j>=0;j--) {
            int k = 0;
            int value = matrix[k][j];
            for(int a=j+1;a<n&&k<m-1;a++)
                if(matrix[++k][a]!=value)
                    return false;
        }
        for(int i=1;i<m-1;i++) {
            int k = 0;
            int value = matrix[i][k];
            for(int a=i+1;a<m&&k<n-1;a++)
                if(matrix[a][++k]!=value)
                    return false;
        }
        return true;        
    }
}
