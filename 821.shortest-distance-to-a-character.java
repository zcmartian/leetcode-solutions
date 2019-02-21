/*
 * @lc app=leetcode id=821 lang=java
 *
 * [821] Shortest Distance to a Character
 *
 * https://leetcode.com/problems/shortest-distance-to-a-character/description/
 *
 * algorithms
 * Easy (62.66%)
 * Total Accepted:    30K
 * Total Submissions: 47.9K
 * Testcase Example:  '"loveleetcode"\n"e"'
 *
 * Given a string S and a character C, return an array of integers representing
 * the shortest distance from the character C in the string.
 * 
 * Example 1:
 * 
 * 
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * S string length is in [1, 10000].
 * C is a single character, and guaranteed to be in string S.
 * All letters in S and C are lowercase.
 * 
 * 
 */
class Solution {
    public int[] shortestToChar(String S, char C) {
        List<Integer> index = new ArrayList<>();
        index.add(Integer.MAX_VALUE);
        for(int i=0;i<S.length();i++) {
            if(S.charAt(i) == C)
                index.add(i);
        }
        index.add(Integer.MAX_VALUE);

        int[] ret = new int[S.length()];
        int a = 0;
        int b = 1;
        for(int i=0;i<S.length();i++) {
            if(S.charAt(i) != C) {
                ret[i] = Math.min(Math.abs(index.get(a)-i), Math.abs(index.get(b)-i));
            } else {
                ret[i] = 0;
                a++;
                b++;
            }
        }
        return ret;
    }
}
