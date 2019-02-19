/*
 * @lc app=leetcode id=942 lang=java
 *
 * [942] DI String Match
 *
 * https://leetcode.com/problems/di-string-match/description/
 *
 * algorithms
 * Easy (70.10%)
 * Total Accepted:    18.2K
 * Total Submissions: 26K
 * Testcase Example:  '"IDID"'
 *
 * Given a string S that only contains "I" (increase) or "D" (decrease), let N
 * = S.length.
 * 
 * Return any permutation A of [0, 1, ..., N] such that for all i = 0, ...,
 * N-1:
 * 
 * 
 * If S[i] == "I", then A[i] < A[i+1]
 * If S[i] == "D", then A[i] > A[i+1]
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "IDID"
 * Output: [0,4,1,3,2]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "III"
 * Output: [0,1,2,3]
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "DDI"
 * Output: [3,2,0,1]
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= S.length <= 10000
 * S only contains characters "I" or "D".
 * 
 */
class Solution {
    public int[] diStringMatch(String S) {
        int n = S.length();
        int[] ret = new int[n+1];
        int l = 0, b = n;
        for(int i=0;i<n;i++) {
            if(S.charAt(i) == 'I')
                ret[i] = l++;
            else
                ret[i] = b--;
        }
        if(S.charAt(n-1) == 'I')
            ret[n] = l++;
        else
            ret[n] = b--;
        return ret;
    }
}
