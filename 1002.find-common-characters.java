/*
 * @lc app=leetcode id=1002 lang=java
 *
 * [1002] Find Common Characters
 *
 * https://leetcode.com/problems/find-common-characters/description/
 *
 * algorithms
 * Easy (70.34%)
 * Total Accepted:    5.2K
 * Total Submissions: 7.4K
 * Testcase Example:  '["bella","label","roller"]'
 *
 * Given an array A of strings made only from lowercase letters, return a list
 * of all characters that show up in all strings within the list (including
 * duplicates).  For example, if a character occurs 3 times in all strings but
 * not 4 times, you need to include that character three times in the final
 * answer.
 * 
 * You may return the answer in any order.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["cool","lock","cook"]
 * Output: ["c","o"]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] is a lowercase letter
 * 
 * 
 * 
 * 
 */
class Solution {
    public List<String> commonChars(String[] A) {
        List<String> ret = new ArrayList<>();
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for(String s : A) {
            int[] cnt = new int[26];
            for(char c : s.toCharArray()) {
                cnt[c - 'a']++;
            }
            for(int i=0;i<26;i++) {
                count[i] = Math.min(cnt[i], count[i]);
            }
        }
        for(int i=0;i<26;i++) {
            while(count[i]-- > 0) {
                ret.add("" + (char)(i + 'a'));
            }
        }
        return ret;
    }
}
