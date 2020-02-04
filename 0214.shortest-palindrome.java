/*
 * @lc app=leetcode id=214 lang=java
 *
 * [214] Shortest Palindrome
 *
 * https://leetcode.com/problems/shortest-palindrome/description/
 *
 * algorithms
 * Hard (27.15%)
 * Total Accepted:    70.6K
 * Total Submissions: 260K
 * Testcase Example:  '"aacecaaa"'
 *
 * Given a string s, you are allowed to convert it to a palindrome by adding
 * characters in front of it. Find and return the shortest palindrome you can
 * find by performing this transformation.
 * 
 * Example 1:
 * 
 * 
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "abcd"
 * Output: "dcbabcd"
 */
class Solution {
    public String shortestPalindrome(String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int l = 0;
        for(l = n;l>=0;l--) {
            if(s.substring(0, l).equals(s2.substring(n-l)))
                break;
        }
        return s2.substring(0, n-l) + s;
    }
}
