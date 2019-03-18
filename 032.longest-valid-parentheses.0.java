/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 *
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (24.99%)
 * Total Accepted:    175.3K
 * Total Submissions: 701.4K
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
        int res = 0;
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(')
                left++;
            else
                right++;
            if (left == right)
                res = Math.max(res, 2 * left);
            else if (right > left){
                left = 0; right = 0;
            }
        }
        left = 0; right = 0;
        for (int i = s.length() - 1; i >= 0; i--){
            if (s.charAt(i) == '(')
                left++;
            else
                right++;
            if (left == right)
                res = Math.max(res, 2 * left);
            else if (right < left){
                left = 0; right = 0;
            }
        }
        return res;
    }
}
