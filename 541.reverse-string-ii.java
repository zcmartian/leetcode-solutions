/*
 * @lc app=leetcode id=541 lang=java
 *
 * [541] Reverse String II
 *
 * https://leetcode.com/problems/reverse-string-ii/description/
 *
 * algorithms
 * Easy (44.87%)
 * Total Accepted:    53K
 * Total Submissions: 118.1K
 * Testcase Example:  '"abcdefg"\n2'
 *
 * 
 * Given a string and an integer k, you need to reverse the first k characters
 * for every 2k characters counting from the start of the string. If there are
 * less than k characters left, reverse all of them. If there are less than 2k
 * but greater than or equal to k characters, then reverse the first k
 * characters and left the other as original.
 * 
 * 
 * Example:
 * 
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * 
 * 
 * 
 * Restrictions: 
 * 
 * ⁠The string consists of lower English letters only.
 * ⁠Length of the given string and k will in the range [1, 10000]
 * 
 */
class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        if(n==1)
            return s;

        char[] ca = s.toCharArray();
        int i = 0;
        for(;i<n-2*k;i+=2*k) {
            reverse(ca, i, i + k);
        }
        reverse(ca, i, Math.min(i+k, n));
        return new String(ca);
    }
    private void reverse(char[] s, int left, int right){
        right -= 1;
        while(left<right){
            char c = s[left];
            s[left] = s[right];
            s[right] = c;
            left++;
            right--;
        }
    }
}
