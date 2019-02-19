/*
 * @lc app=leetcode id=342 lang=java
 *
 * [342] Power of Four
 *
 * https://leetcode.com/problems/power-of-four/description/
 *
 * algorithms
 * Easy (39.94%)
 * Total Accepted:    105.2K
 * Total Submissions: 263.3K
 * Testcase Example:  '16'
 *
 * Given an integer (signed 32 bits), write a function to check whether it is a
 * power of 4.
 * 
 * Example 1:
 * 
 * 
 * Input: 16
 * Output: true
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 5
 * Output: false
 * 
 * 
 * Follow up: Could you solve it without loops/recursion?
 */
class Solution {
    public boolean isPowerOfFour(int num) {
        if(num <= 0)
            return false;
        if(num == 1)
            return true;
        while(num != 1) {
            if(num % 4 != 0)
                return false;
            num = (num >> 2);
        }
        return true;
    }
}
