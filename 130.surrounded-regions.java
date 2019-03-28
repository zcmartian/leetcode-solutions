/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 *
 * https://leetcode.com/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (22.32%)
 * Total Accepted:    137.2K
 * Total Submissions: 614.7K
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * Example:
 * 
 * 
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * 
 * After running your function, the board should be:
 * 
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * 
 * Explanation:
 * 
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on
 * the border of the board are not flipped to 'X'. Any 'O' that is not on the
 * border and it is not connected to an 'O' on the border will be flipped to
 * 'X'. Two cells are connected if they are adjacent cells connected
 * horizontally or vertically.
 * 
 */
class Solution {
    int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        if(board==null||board.length==0) return;
        int row = board.length;
        int col = board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if((i==0||i==row-1||j==0||j==col-1)&&board[i][j]=='O'){
                    helper(board,i,j);
                }
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='$') board[i][j] = 'O';
                else if(board[i][j]=='O') board[i][j] = 'X';
            }
        }
    }

    public void helper(char[][] board, int i, int j){
        if(board[i][j]!='O') return;
        board[i][j] = '$';
        for(int[] dir : dirs){
            int newX = dir[0]+i;
            int newY = dir[1]+j;
            if(newX<0||newX>=board.length||newY<0||newY>=board[0].length||board[newX][newY]!='O') continue;
            helper(board,newX,newY);
        }
    }
}

