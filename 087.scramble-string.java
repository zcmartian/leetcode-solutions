/*
 * @lc app=leetcode id=87 lang=java
 *
 * [87] Scramble String
 *
 * https://leetcode.com/problems/scramble-string/description/
 *
 * algorithms
 * Hard (31.12%)
 * Total Accepted:    86.6K
 * Total Submissions: 278.2K
 * Testcase Example:  '"great"\n"rgeat"'
 *
 * Given a string s1, we may represent it as a binary tree by partitioning it
 * to two non-empty substrings recursively.
 * 
 * Below is one possible representation of s1 = "great":
 * 
 * 
 * ⁠   great
 * ⁠  /    \
 * ⁠ gr    eat
 * ⁠/ \    /  \
 * g   r  e   at
 * ⁠          / \
 * ⁠         a   t
 * 
 * 
 * To scramble the string, we may choose any non-leaf node and swap its two
 * children.
 * 
 * For example, if we choose the node "gr" and swap its two children, it
 * produces a scrambled string "rgeat".
 * 
 * 
 * ⁠   rgeat
 * ⁠  /    \
 * ⁠ rg    eat
 * ⁠/ \    /  \
 * r   g  e   at
 * ⁠          / \
 * ⁠         a   t
 * 
 * 
 * We say that "rgeat" is a scrambled string of "great".
 * 
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it
 * produces a scrambled string "rgtae".
 * 
 * 
 * ⁠   rgtae
 * ⁠  /    \
 * ⁠ rg    tae
 * ⁠/ \    /  \
 * r   g  ta  e
 * ⁠      / \
 * ⁠     t   a
 * 
 * 
 * We say that "rgtae" is a scrambled string of "great".
 * 
 * Given two strings s1 and s2 of the same length, determine if s2 is a
 * scrambled string of s1.
 * 
 * Example 1:
 * 
 * 
 * Input: s1 = "great", s2 = "rgeat"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s1 = "abcde", s2 = "caebd"
 * Output: false
 * 
 */
class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.isEmpty()) return true;
        if (s1.equals(s2)) return true;
        return isScramble(s1, s2, 0, 0, s1.length());
    }

    public boolean permutation(String s1, String s2, int i1, int i2, int n) {
        int[] cs = new int[26];
        for (int i = 0; i < n; i++) {
            cs[s1.charAt(i1+i)-'a']++;
            cs[s2.charAt(i2+i)-'a']--;
        }
        for (int m : cs) if (m != 0) return false;
        return true;
    }

    public boolean equal(String s1, String s2, int i1, int i2, int n) {
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i1+i) != s2.charAt(i2+i)) return false;
        }
        return true;
    }

    public boolean isScramble(String s1, String s2, int i1, int i2, int n) {
        if (equal(s1,s2,i1,i2,n)) return true;
        if (!permutation(s1,s2,i1,i2,n)) return false;
        for (int len=1; len<n; len++) {
            if (isScramble(s1, s2, i1, i2, len) && isScramble(s1, s2, i1+len, i2+len, n-len)) return true;
            if (isScramble(s1, s2, i1, i2+n-len, len) && isScramble(s1, s2, i1+len, i2, n-len)) return true;
        }
        return false;
    }
}
