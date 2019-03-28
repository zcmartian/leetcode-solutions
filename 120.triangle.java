/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 *
 * https://leetcode.com/problems/triangle/description/
 *
 * algorithms
 * Medium (38.64%)
 * Total Accepted:    173.1K
 * Total Submissions: 448.1K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step
 * you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * 
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 * 
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n
 * is the total number of rows in the triangle.
 * 
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // corner case
        if(triangle == null || triangle.size() == 0) return 0;

        // M[i] represents the min total from bottom to current position
        // copy the last row in triangle to M
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[] M = new int[n];
        for(int i = 0; i < n; i++){
            M[i] = triangle.get(m - 1).get(i);
        }

        // induction rule
        // M[i] = min(M[i], M[i + 1]) + curVal
        for(int i = n - 2; i >= 0; i--){
            List<Integer> cur = triangle.get(i);
            for(int j = 0; j < cur.size(); j++){
                M[j] = Math.min(M[j], M[j + 1]) + cur.get(j);
            }
        }

        return M[0];
    }
}
