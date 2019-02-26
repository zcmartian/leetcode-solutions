/*
 * @lc app=leetcode id=754 lang=java
 *
 * [754] Reach a Number
 *
 * https://leetcode.com/problems/reach-a-number/description/
 *
 * algorithms
 * Easy (31.46%)
 * Total Accepted:    8.4K
 * Total Submissions: 26.6K
 * Testcase Example:  '1'
 *
 * 
 * You are standing at position 0 on an infinite number line.  There is a goal
 * at position target.
 * 
 * On each move, you can either go left or right.  During the n-th move
 * (starting from 1), you take n steps.
 * 
 * Return the minimum number of steps required to reach the destination.
 * 
 * 
 * Example 1:
 * 
 * Input: target = 3
 * Output: 2
 * Explanation:
 * On the first move we step from 0 to 1.
 * On the second step we step from 1 to 3.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: target = 2
 * Output: 3
 * Explanation:
 * On the first move we step from 0 to 1.
 * On the second move we step  from 1 to -1.
 * On the third move we step from -1 to 2.
 * 
 * 
 * 
 * Note:
 * target will be a non-zero integer in the range [-10^9, 10^9].
 *
 * Let's look at some small n and the positions we can reach:
 * n = 1, pos = [-1, 1]
 * n = 2, pos = [-3, -1, 1, 3]
 * n = 3, pos = [-6, -4, -2, 0, 2, 4, 6]
 * n = 4, pos = [-10, -8, -6, -4, -2, 0, 2, 4, 6, 8, 10]
 * ....

 * Basically we can observe that after n step and the farthest position is m = n*(n+1)/2,
 * then the positionss we can reach are [-m, -m+2, -m+4, ......, m-4, m-2, m].
 * It can be proved by Mathematical Induction.
 * 
 */
class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int n = 0;
        int m = 0;
        while(m < target) {
            n ++;
            m = n * (n+1) / 2;
        }

        while(m % 2 != target % 2) {
            n ++;
            m = n * (n+1) / 2;
        }
        return n;
    }
}
