/*
 * @lc app=leetcode id=680 lang=java
 *
 * [680] Valid Palindrome II
 *
 * https://leetcode.com/problems/valid-palindrome-ii/description/
 *
 * algorithms
 * Easy (33.52%)
 * Total Accepted:    58.9K
 * Total Submissions: 175.6K
 * Testcase Example:  '"aba"'
 *
 * 
 * Given a non-empty string s, you may delete at most one character.  Judge
 * whether you can make it a palindrome.
 * 
 * 
 * Example 1:
 * 
 * Input: "aba"
 * Output: True
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * 
 * 
 * 
 * Note:
 * 
 * The string will only contain lowercase characters a-z.
 * The maximum length of the string is 50000.
 * 
 * 
 */
class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while (l<=r){
            if (s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }
            else{
                return isPalindrome(s,l,r-1) || isPalindrome(s,l+1,r);
            }
        }
        return true;
    }

    private boolean isPalindrome(String str, int s, int t){
        while (s <= t){
            if (str.charAt(s) == str.charAt(t)){
                s++;
                t--;
            }
            else
                return false;
        }

        return true;
    }
}
