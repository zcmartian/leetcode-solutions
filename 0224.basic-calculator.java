/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 *
 * https://leetcode.com/problems/basic-calculator/description/
 *
 * algorithms
 * Hard (32.08%)
 * Total Accepted:    99.9K
 * Total Submissions: 311.1K
 * Testcase Example:  '"1 + 1"'
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string may contain open ( and closing parentheses ), the plus
 * + or minus sign -, non-negative integers and empty spaces  .
 * 
 * Example 1:
 * 
 * 
 * Input: "1 + 1"
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: " 2-1 + 2 "
 * Output: 3
 * 
 * Example 3:
 * 
 * 
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * Note:
 * 
 * 
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 * 
 * 
 */
class Solution {
    public int calculate(String s) {
        int len = s.length(), sign = 1, result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                result += sum * sign;
            } else if (s.charAt(i) == '+')
                sign = 1;
            else if (s.charAt(i) == '-')
                sign = -1;
            else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result = result * stack.pop() + stack.pop();
            }

        }
        return result;
    }
}
