/*
 * @lc app=leetcode id=174 lang=java
 *
 * [174] Dungeon Game
 *
 * https://leetcode.com/problems/dungeon-game/description/
 *
 * algorithms
 * Hard (26.68%)
 * Total Accepted:    63.3K
 * Total Submissions: 237.3K
 * Testcase Example:  '[[-2,-3,3],[-5,-10,1],[10,30,-5]]'
 *
 * table.dungeon, .dungeon th, .dungeon td {
 * ⁠ border:3px solid black;
 * }
 * 
 * ⁠.dungeon th, .dungeon td {
 * ⁠   text-align: center;
 * ⁠   height: 70px;
 * ⁠   width: 70px;
 * }
 * 
 * The demons had captured the princess (P) and imprisoned her in the
 * bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid
 * out in a 2D grid. Our valiant knight (K) was initially positioned in the
 * top-left room and must fight his way through the dungeon to rescue the
 * princess.
 * 
 * The knight has an initial health point represented by a positive integer. If
 * at any point his health point drops to 0 or below, he dies immediately.
 * 
 * Some of the rooms are guarded by demons, so the knight loses health
 * (negative integers) upon entering these rooms; other rooms are either empty
 * (0's) or contain magic orbs that increase the knight's health (positive
 * integers).
 * 
 * In order to reach the princess as quickly as possible, the knight decides to
 * move only rightward or downward in each step.
 * 
 * 
 * 
 * Write a function to determine the knight's minimum initial health so that he
 * is able to rescue the princess.
 * 
 * For example, given the dungeon below, the initial health of the knight must
 * be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN ->
 * DOWN.
 * 
 * 
 * 
 * 
 * -2 (K)
 * -3
 * 3
 * 
 * 
 * -5
 * -10
 * 1
 * 
 * 
 * 10
 * 30
 * -5 (P)
 * 
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups, even the first room the knight
 * enters and the bottom-right room where the princess is imprisoned.
 *
 * More concise with some explanation:
We cannot determines the health without knowing how much health loss is waiting for us in the future. Thus we need to consider from the opposite way. i.e. from destination to start position.

First we need to know what's the min health we need at the princess location?
The key is assuming we have M[m - 1][n - 1] health when we reach dungeon[m - 1][n - 1] before fighting, then
1.1 we must have at least 1 blood, i.e. M[m - 1][n - 1] >= 1
1.2 after we fight with demons, we need to have at least 1 blood to be alive, i.e. M[m - 1][n - 1] + dungeon[m - 1][n - 1] >= 1
With above, we have: M[m - 1][n - 1] >= 1 and M[m - 1][n - 1] >= 1 - dungeon[i][j], thus M[m - 1][n - 1] >= max(1, 1 - dungeon[m - 1][n - 1])
Then what about the previous min health we should have, let's denote cur min health as cur?
2.1 we must have at least 1 blood, i.e. prev >= 1
2.2 after we fight with demons, we have cur health, i.e. prev + dungeon[prev] = cur
From above, we have prev >= 1 and prev >= cur - dungeon[prev], thus prev = max(1, cur - dungeon[prev])
I will leave rest explanation to you :)
 * 
 */
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        // corner case
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0){
            return 0;
        }

        // M[i][j] represents the health when I reach dungeon[i][j]
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] M = new int[m][n];
        // initialization:
        // M[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        // or M[m - 1][n - 1] = dungeon[i][j] >= 0? 1 : -dungeon[i][j] + 1;
        // induction rule:
        // M[i][n - 1] = max(M[i + 1][n - 1] - dungeon[i][n - 1], 1)
        // M[m - 1][j] = max(M[m - 1][j + 1] - dungeon[m - 1][j], 1)
        // M[i][j] = min(max(M[i][j + 1] - dungeon[i][j], 1), max(M[i + 1][j] - dungeon[i][j], 1))
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(i == m - 1 && j == n - 1){
                    M[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
                }else if(i == m - 1){
                    M[m - 1][j] = Math.max(M[m - 1][j + 1] - dungeon[m - 1][j], 1);
                }else if(j == n - 1){
                    M[i][n - 1] = Math.max(M[i + 1][n - 1] - dungeon[i][n - 1], 1);
                }else{
                    M[i][j] = Math.min(Math.max(M[i + 1][j] - dungeon[i][j], 1), Math.max(M[i][j + 1] - dungeon[i][j], 1));
                }
            }
        }

        return M[0][0];
    }
}
