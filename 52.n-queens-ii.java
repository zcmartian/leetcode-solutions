/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 *
 * https://leetcode.com/problems/n-queens-ii/description/
 *
 * algorithms
 * Hard (50.92%)
 * Total Accepted:    94K
 * Total Submissions: 184.6K
 * Testcase Example:  '4'
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * 
 * 
 * Given an integer n, return the number of distinct solutions to the n-queens
 * puzzle.
 * 
 * Example:
 * 
 * 
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as
 * shown below.
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * 
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 
 * 
 */
class Solution {
    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;
    private LinkedList<Integer> row = new LinkedList<>();
    public int totalNQueens(int n) {
        col = new boolean[n];
        dia1 = new boolean[2*n-1];
        dia2 = new boolean[2*n-1];
        return dfs(n, 0, row);
    }
    private int dfs(int n, int index, LinkedList<Integer> row) {
        if(index == n)
            return 1;
        int res = 0;
        for(int i=0;i<n;i++) {
            if(!col[i] && !dia1[index+i] && !dia2[index-i+n-1]) {
                row.addLast(i);
                col[i] = true;
                dia1[index+i] = true;
                dia2[index-i+n-1] = true;

                res += dfs(n, index+1, row);
                col[i] = false;
                dia1[index+i] = false;
                dia2[index-i+n-1] = false;
                row.removeLast();
            }
        }
        return res;
    }
}
