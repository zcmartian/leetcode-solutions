/*
 * @lc app=leetcode id=520 lang=java
 *
 * [520] Detect Capital
 *
 * https://leetcode.com/problems/detect-capital/description/
 *
 * algorithms
 * Easy (52.15%)
 * Total Accepted:    76.3K
 * Total Submissions: 146.3K
 * Testcase Example:  '"USA"'
 *
 * 
 * Given a word, you need to judge whether the usage of capitals in it is right
 * or not.
 * 
 * 
 * 
 * We define the usage of capitals in a word to be right when one of the
 * following cases holds:
 * 
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one
 * letter, like "Google".
 * 
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "USA"
 * Output: True
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "FlaG"
 * Output: False
 * 
 * 
 * 
 * Note:
 * The input will be a non-empty word consisting of uppercase and lowercase
 * latin letters.
 * 
 */
class Solution {
    public boolean detectCapitalUse(String word) {
        char[] s = word.toCharArray();
        int len = word.length();
        int count = 0;
        for(int i=0;i<len;i++){
            if(s[i] >= 'A' && s[i]<='Z'){
                count += 1;
            }
        }
        return count == len ? true : count == 0 ? true : (count == 1 && (s[0]>='A'&&s[0]<='Z')) ? true : false;
    }
}
