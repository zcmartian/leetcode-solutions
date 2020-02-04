/*
 * @lc app=leetcode id=784 lang=java
 *
 * [784] Letter Case Permutation
 *
 * https://leetcode.com/problems/letter-case-permutation/description/
 *
 * algorithms
 * Easy (55.15%)
 * Total Accepted:    37.3K
 * Total Submissions: 67.7K
 * Testcase Example:  '"a1b2"'
 *
 * Given a string S, we can transform every letter individually to be lowercase
 * or uppercase to create another string.  Return a list of all possible
 * strings we could create.
 * 
 * 
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * 
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 * 
 * Input: S = "12345"
 * Output: ["12345"]
 * 
 * 
 * Note:
 * 
 * 
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 * 
 * 
 */
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> ret = new ArrayList<>();
        if(S==null)
            return ret;
        helper(S.toCharArray(), ret, 0);
        return ret;
    }
    private void helper(char[] cs, List<String> ret, int pos) {
        if(pos == cs.length) {
            ret.add(new String(cs));
            return;
        }
        if(Character.isDigit(cs[pos])) {
            helper(cs, ret, pos + 1);
            return;
        }
        cs[pos] = Character.toLowerCase(cs[pos]);
        helper(cs, ret, pos + 1);
        cs[pos] = Character.toUpperCase(cs[pos]);
        helper(cs, ret, pos + 1);
    }
}
