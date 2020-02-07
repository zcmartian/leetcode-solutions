/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (26.70%)
 * Total Accepted:    490.9K
 * Total Submissions: 1.8M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */
class Solution {
    public String longestPalindrome(String s) {
        if(s==null||s.length()<=1)
            return s;
        int curLen = 0;
        int start = -1;
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++) {
            if(isPalindrome(arr, i-curLen-1, i)) {
                start = i - curLen - 1;
                curLen += 2;
            } else if(isPalindrome(arr, i-curLen, i)) {
                start = i - curLen;
                curLen += 1;
            }
        }
        return new String(arr, start, curLen);
    }
    private boolean isPalindrome(char[] arr, int start, int end) {
        if(start<0) return false;
        while(start<end) {
            if(arr[start++] != arr[end--])
                return false;
        }
        return true;
    }
}
