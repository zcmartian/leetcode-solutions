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
        int ret = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '(')
                stack.push(i);
            else {
                if(!stack.isEmpty()) {
                    if(s.charAt(stack.peek()) == '(')
                        stack.pop();
                    else
                        stack.push(i);
                } else
                    stack.push(i);
            }
        }
        if(stack.isEmpty()) 
            ret = s.length();
        else {
            int a = s.length();
            int b = 0;
            while(!stack.isEmpty()) {
                b = stack.peek();
                stack.pop();
                ret = Math.max(ret, a - b - 1);
                a = b;
            }
            ret = Math.max(ret, a);
        }
        return ret;
    }
}
