/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 *
 * https://leetcode.com/problems/rotting-oranges/description/
 *
 * algorithms
 * Easy (46.69%)
 * Total Accepted:    5.2K
 * Total Submissions: 11.1K
 * Testcase Example:  '[[2,1,1],[1,1,0],[0,1,1]]'
 *
 * In a given grid, each cell can have one of three values:
 * 
 * 
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * 
 * 
 * Every minute, any fresh orange that is adjacent (4-directionally) to a
 * rotten orange becomes rotten.
 * 
 * Return the minimum number of minutes that must elapse until no cell has a
 * fresh orange.  If this is impossible, return -1 instead.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is
 * never rotten, because rotting only happens 4-directionally.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the
 * answer is just 0.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] is only 0, 1, or 2.
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null||grid.length==0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int count_fresh = 0;
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(grid[i][j]==2)
                    q.offer(new int[]{i, j});
                else if(grid[i][j]==1)
                    count_fresh++;
            }
        }
        if(count_fresh==0) return 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int count = 0;
        while(!q.isEmpty()) {
            ++count;
            int size = q.size();
            for(int i=0;i<size;i++) {
                int[] point = q.poll();
                for(int[] dir : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    if(x<0||y<0||x>=row||y>=col||grid[x][y]==0||grid[x][y]==2)
                        continue;
                    grid[x][y] = 2;
                    q.offer(new int[]{x,y});
                    count_fresh--;
                }
            }
        }
        return count_fresh==0?count-1:-1;
    }
}
