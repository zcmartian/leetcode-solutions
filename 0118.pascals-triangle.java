/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 *
 * https://leetcode.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (43.79%)
 * Total Accepted:    217.4K
 * Total Submissions: 496.6K
 * Testcase Example:  '5'
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's
 * triangle.
 * 
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 * 
 * Example:
 * 
 * 
 * Input: 5
 * Output:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows==0)
            return new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();

        List<Integer> row1 = new ArrayList<>(1);
        row1.add(1);

        List<Integer> row2 = new ArrayList<>(2);
        row2.add(1);
        row2.add(1);

        if(numRows==1) {
            ret.add(row1);
            return ret;
        }
        if(numRows==2) {
            ret.add(row1);
            ret.add(row2);
            return ret;
        }
        
        ret.add(row1);
        ret.add(row2);
        for(int i=2;i<numRows;i++) {
            List<Integer> row = new ArrayList<>(i+1);
            row.add(1);
            for(int j=1;j<i;j++) {
                row.add(ret.get(i-1).get(j-1) + ret.get(i-1).get(j));
            }
            row.add(1);
            ret.add(row);
        }
        return ret;
    }
}
