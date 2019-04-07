/*
 * @lc app=leetcode id=363 lang=java
 *
 * [363] Max Sum of Rectangle No Larger Than K
 *
 * https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/description/
 *
 * algorithms
 * Hard (34.89%)
 * Total Accepted:    26.2K
 * Total Submissions: 75K
 * Testcase Example:  '[[1,0,1],[0,-2,3]]\n2'
 *
 * Given a non-empty 2D matrix matrix and an integer k, find the max sum of a
 * rectangle in the matrix such that its sum is no larger than k.
 * 
 * Example:
 * 
 * 
 * Input: matrix = [[1,0,1],[0,-2,3]], k = 2
 * Output: 2 
 * Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is
 * 2,
 * and 2 is the max number no larger than k (k = 2).
 * 
 * Note:
 * 
 * 
 * The rectangle inside the matrix must have an area > 0.
 * What if the number of rows is much larger than the number of columns?
 * 
 */
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < row; i ++) {
            int[] colSum = new int[col];
            for (int j = i; j < row; j ++) {
                for (int c = 0; c < col; c ++) {
                    colSum[c] += matrix[j][c];
                }
                max = Math.max(max, findMax(colSum, k));
            }
        }
        return max;
    }

    private int findMax(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        TreeSet<Integer> s = new TreeSet();
        s.add(0);

        for(int i = 0;i < nums.length; i ++){
            int t = sum + nums[i];
            sum = t;
            Integer gap = s.ceiling(sum - k);
            if(gap != null) max = Math.max(max, sum - gap);
            s.add(t);
        }

        return max;
    }
}
