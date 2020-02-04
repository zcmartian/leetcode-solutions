/*
 * @lc app=leetcode id=693 lang=java
 *
 * [693] Binary Number with Alternating Bits
 *
 * https://leetcode.com/problems/binary-number-with-alternating-bits/description/
 *
 * algorithms
 * Easy (57.45%)
 * Total Accepted:    36.8K
 * Total Submissions: 64.1K
 * Testcase Example:  '5'
 *
 * Given a positive integer, check whether it has alternating bits: namely, if
 * two adjacent bits will always have different values.
 * 
 * Example 1:
 * 
 * Input: 5
 * Output: True
 * Explanation:
 * The binary representation of 5 is: 101
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 7
 * Output: False
 * Explanation:
 * The binary representation of 7 is: 111.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: 11
 * Output: False
 * Explanation:
 * The binary representation of 11 is: 1011.
 * 
 * 
 * 
 * Example 4:
 * 
 * Input: 10
 * Output: True
 * Explanation:
 * The binary representation of 10 is: 1010.
 * 
 * 
 */
class Solution {
    public boolean hasAlternatingBits(int n) {
        int pre = -1;
        while(n!=0) {
            int re = n % 2;
            if(pre<0) {
                pre = re;
                n /= 2;
                continue;
            }
            if(pre==re)
                return false;
            pre = re;
            n /= 2;
        }
        return true;
    }
}
