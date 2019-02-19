/*
 * @lc app=leetcode id=476 lang=java
 *
 * [476] Number Complement
 *
 * https://leetcode.com/problems/number-complement/description/
 *
 * algorithms
 * Easy (62.00%)
 * Total Accepted:    99.6K
 * Total Submissions: 160.6K
 * Testcase Example:  '5'
 *
 * Given a positive integer, output its complement number. The complement
 * strategy is to flip the bits of its binary representation.
 * 
 * Note:
 * 
 * The given integer is guaranteed to fit within the range of a 32-bit signed
 * integer.
 * You could assume no leading zero bit in the integer’s binary
 * representation.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits),
 * and its complement is 010. So you need to output 2.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and
 * its complement is 0. So you need to output 0.
 * 
 * 
 */
class Solution {
    public int findComplement(int num) {
        int bits = 0;
        int n = num;
        while(n!=0) {
            bits++;
            n /= 2;
        }
        int ceil = (1 << bits) - 1;
        return ceil - num;
    }
}
