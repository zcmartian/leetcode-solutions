/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 *
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 *
 * algorithms
 * Medium (15.96%)
 * Total Accepted:    260.5K
 * Total Submissions: 1.6M
 * Testcase Example:  '"the sky is blue"'
 *
 * Given an input string, reverse the string word by word.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing
 * spaces.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a
 * single space in the reversed string.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed
 * string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in
 * the reversed string.
 * 
 * 
 * 
 * 
 * Follow up:
 * 
 * For C programmers, try to solve it in-place in O(1) extra space.
 */
class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        for (int start = s.length() - 1; start >= 0; start--) {
            if (s.charAt(start) == ' ') continue;
            int end = start;
            while (start >= 0 && s.charAt(start) != ' ') start--;
            res.append(s.substring(start + 1, end + 1)).append(" ");
        }
        return res.toString().trim();
    }
}
