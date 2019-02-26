/*
 * @lc app=leetcode id=984 lang=java
 *
 * [984] String Without AAA or BBB
 *
 * https://leetcode.com/problems/string-without-aaa-or-bbb/description/
 *
 * algorithms
 * Easy (32.15%)
 * Total Accepted:    7K
 * Total Submissions: 21.8K
 * Testcase Example:  '1\n2'
 *
 * Given two integers A and B, return any string S such that:
 * 
 * 
 * S has length A + B and contains exactly A 'a' letters, and exactly B 'b'
 * letters;
 * The substring 'aaa' does not occur in S;
 * The substring 'bbb' does not occur in S.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = 1, B = 2
 * Output: "abb"
 * Explanation: "abb", "bab" and "bba" are all correct answers.
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = 4, B = 1
 * Output: "aabaa"
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 0 <= A <= 100
 * 0 <= B <= 100
 * It is guaranteed such an S exists for the given A and B.
 * 
 */
class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder res = new StringBuilder(A + B);
        char a = 'a', b = 'b';
        int i = A, j = B;
        if (B > A) { a = 'b'; b = 'a'; i = B; j = A; }
        while (i-- > 0) {
            res.append(a);
            if (i > j) { res.append(a); --i; }
            if (j-- > 0) res.append(b);
        }
        return res.toString();
    }
}
