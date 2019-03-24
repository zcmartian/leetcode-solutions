/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 *
 * https://leetcode.com/problems/maximal-rectangle/description/
 *
 * algorithms
 * Hard (32.61%)
 * Total Accepted:    114.1K
 * Total Submissions: 349.9K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing only 1's and return its area.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * ⁠ ["1","0","1","0","0"],
 * ⁠ ["1","0","1","1","1"],
 * ⁠ ["1","1","1","1","1"],
 * ⁠ ["1","0","0","1","0"]
 * ]
 * Output: 6
 * 
 * 
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int[] heights = new int[matrix[0].length];
        int ans = 0;
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j] == '0') heights[j] = 0;
                else heights[j]++;
            }  
            ans = Math.max(ans,calcArea(heights));
        }
        return ans;
    }
    private int calcArea(int[] heights){                        //method of problem 84
        if(heights == null || heights.length == 0) return 0;
        int ans = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for(int i = 0;i<= heights.length;i++){
            while(stack.peek()!=-1 && (i==heights.length || heights[i] <  heights[stack.peek()])){
                int index = stack.pop();
                int start = stack.peek() + 1;
                ans = Math.max(ans,heights[index]*(i-start));
            }
            stack.push(i);
        }
        return ans;        
    }
}
