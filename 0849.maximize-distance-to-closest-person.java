/*
 * @lc app=leetcode id=849 lang=java
 *
 * [849] Maximize Distance to Closest Person
 *
 * https://leetcode.com/problems/maximize-distance-to-closest-person/description/
 *
 * algorithms
 * Easy (40.39%)
 * Total Accepted:    25.4K
 * Total Submissions: 62.9K
 * Testcase Example:  '[1,0,0,0,1,0,1]'
 *
 * In a row of seats, 1 represents a person sitting in that seat, and 0
 * represents that the seat is empty. 
 * 
 * There is at least one empty seat, and at least one person sitting.
 * 
 * Alex wants to sit in the seat such that the distance between him and the
 * closest person to him is maximized. 
 * 
 * Return that maximum distance to closest person.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [1,0,0,0,1,0,1]
 * Output: 2
 * Explanation: 
 * If Alex sits in the second open seat (seats[2]), then the closest person has
 * distance 2.
 * If Alex sits in any other open seat, the closest person has distance 1.
 * Thus, the maximum distance to the closest person is 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,0,0,0]
 * Output: 3
 * Explanation: 
 * If Alex sits in the last seat, the closest person is 3 seats away.
 * This is the maximum distance possible, so the answer is 3.
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= seats.length <= 20000
 * seats contains only 0s or 1s, at least one 0, and at least one 1.
 * 
 * 
 * 
 * 
 */
class Solution {
    public int maxDistToClosest(int[] seats) {
        int i, j, res = 0, n = seats.length;
        for (i = j = 0; j < n; ++j)
            if (seats[j] == 1) {
                if (i == 0) res = Math.max(res, j - i);
                else res = Math.max(res, (j - i + 1) / 2);
                i = j + 1;
            }
        res = Math.max(res, n - i);
        return res;
    }
}
