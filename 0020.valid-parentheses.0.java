/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (35.64%)
 * Total Accepted:    493.2K
 * Total Submissions: 1.4M
 * Testcase Example:  '"()"'
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 
 * 
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * 
 * 
 * Input: "()"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "()[]{}"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "(]"
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "([)]"
 * Output: false
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "{[]}"
 * Output: true
 * 
 * 
 */
class Solution {
    public boolean isValid(String s) {
        char[] ca = s.toCharArray();
        int n = ca.length;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<n;i++){
            if(ca[i]=='('||ca[i]=='['||ca[i]=='{') {
                stack.push(ca[i]);
            } else if(ca[i]==')'||ca[i]==']'||ca[i]=='}') {
                if(stack.size()==0)
                    return false;
                char c = stack.pop();
                if(ca[i]==')' && c!='(')
                    return false;
                if(ca[i]==']' && c!='[')
                    return false;
                if(ca[i]=='}' && c!='{')
                    return false;
            }
        }
        return stack.size() == 0;
    }
}
