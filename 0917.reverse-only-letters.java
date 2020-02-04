/*
 * @lc app=leetcode id=917 lang=java
 *
 * [917] Reverse Only Letters
 *
 * https://leetcode.com/problems/reverse-only-letters/description/
 *
 * algorithms
 * Easy (55.86%)
 * Total Accepted:    18.8K
 * Total Submissions: 33.7K
 * Testcase Example:  '"ab-cd"'
 *
 * Given a string S, return the "reversed" string where all characters that are
 * not a letter stay in the same place, and all letters reverse their
 * positions.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "ab-cd"
 * Output: "dc-ba"
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122 
 * S doesn't contain \ or "
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public String reverseOnlyLetters(String S) {
        char[] cs = S.toCharArray();
        for(int i=0,j=cs.length-1;i<j;) {
            if(Character.isLetter(cs[i]) && Character.isLetter(cs[j])) {
                char t = cs[i];
                cs[i] = cs[j];
                cs[j] = t;
                i++;
                j--;
            }
            if(!Character.isLetter(cs[i]))
                i++;
            if(!Character.isLetter(cs[j]))
                j--;
        }
        return new String(cs);
    }
}
