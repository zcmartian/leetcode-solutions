/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (21.99%)
 * Total Accepted:    243.9K
 * Total Submissions: 1.1M
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * Example 1:
 * 
 * 
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 * 
 */
class Solution {
    public int numDecodings(String s) {
        return s.length() == 0 ? 0 : numDecodings(0, s);
    }

    private int numDecodings(int p, String s) {
        int n = s.length();
        if(p==n) return 1;

        if(s.charAt(p) == '0') return 0;
        int res = numDecodings(p+1, s);
        if(p < n-1 && (s.charAt(p)=='1' || (s.charAt(p)=='2' && s.charAt(p+1)<'7')))
            res += numDecodings(p+2, s);
        return res;
    }
}
