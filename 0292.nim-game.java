/*
 * @lc app=leetcode id=292 lang=java
 *
 * [292] Nim Game
 *
 * https://leetcode.com/problems/nim-game/description/
 *
 * algorithms
 * Easy (55.46%)
 * Total Accepted:    178.2K
 * Total Submissions: 321.3K
 * Testcase Example:  '4'
 *
 * You are playing the following Nim Game with your friend: There is a heap of
 * stones on the table, each time one of you take turns to remove 1 to 3
 * stones. The one who removes the last stone will be the winner. You will take
 * the first turn to remove the stones.
 * 
 * Both of you are very clever and have optimal strategies for the game. Write
 * a function to determine whether you can win the game given the number of
 * stones in the heap.
 * 
 * Example:
 * 
 * 
 * Input: 4
 * Output: false 
 * Explanation: If there are 4 stones in the heap, then you will never win the
 * game;
 * No matter 1, 2, or 3 stones you remove, the last stone will always
 * be 
 * removed by your friend.
 */
class Solution {
    /* 
    private boolean myTurn = true;
    private Map<Integer, Boolean> map = new HashMap<>();
    public boolean canWinNim(int n) {
        return canWinNim(n, myTurn);
    }
    private boolean canWinNim(int n, boolean my) {
        if(map.containsKey(n))
            return map.get(n);
        if(n<=3) {
            map.put(n, my);
            return my;
        }
        myTurn = !my;
        boolean ret = canWinNim(n-3, myTurn) || canWinNim(n-2, myTurn) || canWinNim(n-1, myTurn);
        map.put(n, ret);
        return ret;
    }
    */
    public boolean canWinNim(int n) {
        return (n & 0b11) != 0;
    }
}
