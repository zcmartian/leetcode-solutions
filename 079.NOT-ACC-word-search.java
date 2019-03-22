/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (30.59%)
 * Total Accepted:    259K
 * Total Submissions: 846.5K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 * 
 * Example:
 * 
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * 
 * 
 */
class Solution {
    private boolean start = false;
    private int[][] directions = {{0,-1}, {1,0}, {0, 1}, {-1, 0}};//前进方向: 上,右,下,左
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||word==null||word.length()==0) return false;
        int rows = board.length;
        int cols = board[0].length;
        if(rows*cols<word.length()) return false;
        return search(board, 0, 0, word, 0) || search(board, 0, cols-1, word, 0) || search(board, rows-1, 0, word, 0)
            || search(board, rows-1, cols-1, word, 0);
    }
    private boolean search(char[][] board, int i, int j, String word, int index) {
        if(i<0||i>=board.length||j<0||j>=board[0].length) return false;
        if(board[i][j]==word.charAt(index)) {
            if(index==word.length()-1) return true;
            boolean ret = false;
            for(int k=0;k<4;k++) {
                int newI = directions[k][0] + i;
                int newJ = directions[k][1] + j;
                ret |= search(board, newI, newJ, word, index+1);
            }
            return ret;
        } else {
            return false;
        }
    }
}
