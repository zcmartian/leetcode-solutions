/*
 * @lc app=leetcode id=832 lang=java
 *
 * [832] Flipping an Image
 *
 * https://leetcode.com/problems/flipping-an-image/description/
 *
 * algorithms
 * Easy (70.60%)
 * Total Accepted:    63.7K
 * Total Submissions: 90.2K
 * Testcase Example:  '[[1,1,0],[1,0,1],[0,0,0]]'
 *
 * Given a binary matrix A, we want to flip the image horizontally, then invert
 * it, and return the resulting image.
 * 
 * To flip an image horizontally means that each row of the image is reversed.
 * For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * 
 * To invert an image means that each 0 is replaced by 1, and each 1 is
 * replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row:
 * [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 
 * 
 * Notes:
 * 
 * 
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 * 
 * 
 */
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] ret = new int[A.length][];
        for (int i=0;i<A.length;i++) {
       	    doFlipAndInvert(A[i]);
        }
        return A;
    }
    
    void doFlipAndInvert(int[] row) {
        int i = 0;
        int j = row.length - 1;
        for (; i <= j; i++, j--) {
            if (i == j) {
                row[i] = invert(row[i]);
            } else {
                int tmp = row[i];
                row[i] = row[j];
                row[j] = tmp;
                row[i] = invert(row[i]);
                row[j] = invert(row[j]);
            }
        }
    }
    
    int invert(int value) {
        return value^1;
    }
}