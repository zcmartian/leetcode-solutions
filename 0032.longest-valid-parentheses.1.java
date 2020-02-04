/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 *
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (25.46%)
 * Total Accepted:    189.3K
 * Total Submissions: 743.6K
 * Testcase Example:  '"(()"'
 *
 * Given a string containing just the characters '(' and ')', find the length
 * of the longest valid (well-formed) parentheses substring.
 * 
 * Example 1:
 * 
 * 
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 * 
 * 
 */
class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int count = 0;
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                count++;
            } else if(count > 0) {
                dp[i] = dp[i -1] + 2;
                dp[i] += (i - dp[i] >= 0) ? dp[i - dp[i]] : 0;
                result = Math.max(result, dp[i]);
                count--;
            }
        }
        return result;
    }
}
