/*
 * @lc app=leetcode id=201 lang=java
 *
 * [201] Bitwise AND of Numbers Range
 *
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/description/
 *
 * algorithms
 * Medium (35.65%)
 * Total Accepted:    78.9K
 * Total Submissions: 221.3K
 * Testcase Example:  '5\n7'
 *
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
 * of all numbers in this range, inclusive.
 * 
 * Example 1:
 * 
 * 
 * Input: [5,7]
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [0,1]
 * Output: 0
 */
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int i = 1 << 31;
        int result = 0;
        while(i != 0 && (i & m) == (i & n)) {
            result |= (i & m);
            i >>>= 1;
        }
        return result;
    }
}
