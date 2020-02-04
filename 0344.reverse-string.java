/*
 * @lc app=leetcode id=344 lang=java
 *
 * [344] Reverse String
 *
 * https://leetcode.com/problems/reverse-string/description/
 *
 * algorithms
 * Easy (62.54%)
 * Total Accepted:    352.6K
 * Total Submissions: 563.9K
 * Testcase Example:  '["h","e","l","l","o"]'
 *
 * Write a function that reverses a string. The input string is given as an
 * array of characters char[].
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * You may assume all the characters consist of printable ascii
 * characters.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * 
 * 
 * 
 * 
 */
class Solution {
    public void reverseString(char[] s) {
        int left=0,right=s.length-1;
        while(left<right){
            char c = s[left];
            s[left] = s[right];
            s[right] = c;
            left++;
            right--;
        }
    }
}
