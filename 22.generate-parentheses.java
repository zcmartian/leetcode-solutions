/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (53.35%)
 * Total Accepted:    306K
 * Total Submissions: 573.4K
 * Testcase Example:  '3'
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * For example, given n = 3, a solution set is:
 * 
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        recursion(ret, "", 0, 0, n);
        return ret;
    }
    private void recursion(List<String> ret, String cur, int open, int close, int n) {
        if(cur.length() == n * 2) {
            ret.add(cur);
            return;
        }

        if(open < n) {
            recursion(ret, cur + "(", open + 1, close, n);
        }
        if(close < open) {
            recursion(ret, cur + ")", open, close + 1, n);
        }
    }
}
