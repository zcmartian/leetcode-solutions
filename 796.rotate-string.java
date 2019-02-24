/*
 * @lc app=leetcode id=796 lang=java
 *
 * [796] Rotate String
 *
 * https://leetcode.com/problems/rotate-string/description/
 *
 * algorithms
 * Easy (48.77%)
 * Total Accepted:    33.2K
 * Total Submissions: 68.1K
 * Testcase Example:  '"abcde"\n"cdeab"'
 *
 * We are given two strings, A and B.
 * 
 * A shift on A consists of taking string A and moving the leftmost character
 * to the rightmost position. For example, if A = 'abcde', then it will be
 * 'bcdea' after one shift on A. Return True if and only if A can become B
 * after some number of shifts on A.
 * 
 * 
 * Example 1:
 * Input: A = 'abcde', B = 'cdeab'
 * Output: true
 * 
 * Example 2:
 * Input: A = 'abcde', B = 'abced'
 * Output: false
 * 
 * 
 * Note:
 * 
 * 
 * A and B will have length at most 100.
 * 
 * 
 */
class Solution {
    public boolean rotateString(String A, String B) {
        int len = A.length();
        if(len==0&&B.length()==0) return true;
        String a = A;
        for(int i=0;i<len;i++) {
            a = rotate(a);
            if(B.equals(a))
                return true;
        }
        return false;
    }
    private String rotate(String origin) {
        char[] cs = origin.toCharArray();
        char a = cs[0];
        for(int i=0;i<origin.length()-1;i++) {
            cs[i] = cs[i+1];
        }
        cs[origin.length()-1] = a;
        return new String(cs);
    }
}
