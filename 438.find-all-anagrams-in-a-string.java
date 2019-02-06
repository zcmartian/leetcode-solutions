/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 *
 * algorithms
 * Easy (35.96%)
 * Total Accepted:    102.8K
 * Total Submissions: 285.9K
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * Given a string s and a non-empty string p, find all the start indices of p's
 * anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * 
 * Input:
 * s: "cbaebabacd" p: "abc"
 * 
 * Output:
 * [0, 6]
 * 
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of
 * "abc".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * s: "abab" p: "ab"
 * 
 * Output:
 * [0, 1, 2]
 * 
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 * 
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int left = 0;
        int right = 0;
        int sLen = s.length();
        int pLen = p.length();
        int[] hash = new int[256];
        List<Integer> pos = new ArrayList<Integer>();

        for (int i = 0; i<pLen; i++) {
            hash[(int)p.charAt(i)]++;
        }
        int count = 0;

        while (right < sLen) {
            if (hash[(int)s.charAt(right)] > 0) {
                hash[(int)s.charAt(right)]--;
                count++;
                right++;
            } else {
                hash[(int)s.charAt(left)]++;
                count--;
                left++;
            }

            if(count == pLen) {
                pos.add(left);
            }

        }
        return pos;
    }
}
