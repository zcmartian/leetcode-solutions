/*
 * @lc app=leetcode id=389 lang=java
 *
 * [389] Find the Difference
 *
 * https://leetcode.com/problems/find-the-difference/description/
 *
 * algorithms
 * Easy (52.55%)
 * Total Accepted:    132K
 * Total Submissions: 251.3K
 * Testcase Example:  '"abcd"\n"abcde"'
 *
 * 
 * Given two strings s and t which consist of only lowercase letters.
 * 
 * String t is generated by random shuffling string s and then add one more
 * letter at a random position.
 * 
 * Find the letter that was added in t.
 * 
 * Example:
 * 
 * Input:
 * s = "abcd"
 * t = "abcde"
 * 
 * Output:
 * e
 * 
 * Explanation:
 * 'e' is the letter that was added.
 * 
 */
class Solution {
    public char findTheDifference(String s, String t) {
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();

        int asciis = 0;
        int asciit = 0;

        for(int i = 0; i < array1.length; i++){
            asciis += (int)array1[i];
        }

        for(int i = 0; i < array2.length; i++){
            asciit += (int)array2[i];
        }

        return (char)(asciit-asciis);
    }
}