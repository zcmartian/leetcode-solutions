/*
 * @lc app=leetcode id=999 lang=java
 *
 * [999] Available Captures for Rook
 *
 * https://leetcode.com/problems/available-captures-for-rook/description/
 *
 * algorithms
 * Easy (76.64%)
 * Total Accepted:    3.6K
 * Total Submissions: 4.6K
 * Testcase Example:  '[[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]'
 *
 * On an 8 x 8 chessboard, there is one white rook.  There also may be empty
 * squares, white bishops, and black pawns.  These are given as characters 'R',
 * '.', 'B', and 'p' respectively. Uppercase characters represent white pieces,
 * and lowercase characters represent black pieces.
 * 
 * The rook moves as in the rules of Chess: it chooses one of four cardinal
 * directions (north, east, west, and south), then moves in that direction
 * until it chooses to stop, reaches the edge of the board, or captures an
 * opposite colored pawn by moving to the same square it occupies.  Also, rooks
 * cannot move into the same square as other friendly bishops.
 * 
 * Return the number of pawns the rook can capture in one move.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input:
 * [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * Output: 3
 * Explanation: 
 * In this example the rook is able to capture all the pawns.
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input:
 * [[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * Output: 0
 * Explanation: 
 * Bishops are blocking the rook to capture any pawn.
 * 
 * 
 * Example 3:
 * 
 * 
 * 
 * 
 * Input:
 * [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","p",".",".",".","."],["p","p",".","R",".","p","B","."],[".",".",".",".",".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * Output: 3
 * Explanation: 
 * The rook can capture the pawns at positions b5, d6 and f5.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * board.length == board[i].length == 8
 * board[i][j] is either 'R', '.', 'B', or 'p'
 * There is exactly one cell with board[i][j] == 'R'
 * 
 * 
 */
class Solution {
    public int numRookCaptures(char[][] board) {
        int[] point = new int[2];
        for(int i = 0 ; i < 8 ; i++) {
            for(int j = 0 ; j < 8 ; j++) {
                if(board[i][j] == 'R') {
                    point[0] = i;
                    point[1] = j;
                    break;
                }
            }
        }
        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] dir : dirs) {
            int x = point[0] + dir[0];
            int y = point[1] + dir[1];
            while(x >= 0 && y >= 0 && x < 8 && y < 8 && board[x][y] == '.') {
                x += dir[0];
                y += dir[1];
            }
            if(x < 0 || y < 0 || x >= 8 || y >= 8) continue;
            if(board[x][y] == 'p') count++;
        }
        return count;        
    }
}
