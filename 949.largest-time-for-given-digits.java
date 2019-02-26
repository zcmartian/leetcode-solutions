/*
 * @lc app=leetcode id=949 lang=java
 *
 * [949] Largest Time for Given Digits
 *
 * https://leetcode.com/problems/largest-time-for-given-digits/description/
 *
 * algorithms
 * Easy (33.22%)
 * Total Accepted:    6.5K
 * Total Submissions: 19.7K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given an array of 4 digits, return the largest 24 hour time that can be
 * made.
 * 
 * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from
 * 00:00, a time is larger if more time has elapsed since midnight.
 * 
 * Return the answer as a string of length 5.  If no valid time can be made,
 * return an empty string.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,4]
 * Output: "23:41"
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [5,5,5,5]
 * Output: ""
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * A.length == 4
 * 0 <= A[i] <= 9
 * 
 * 
 * 
 */
class Solution {
    public String largestTimeFromDigits(int[] A) {
        String ans = "";
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                for (int k = 0; k < 4; ++k) {
                    if (i == j || i == k || j == k) continue; // avoid duplicate among i, j & k.
                    String h = "" + A[i] + A[j], m = "" + A[k] + A[6 - i - j - k], t = h + ":" + m; // hour, minutes, & time.
                    if (h.compareTo("24") < 0 && m.compareTo("60") < 0 && ans.compareTo(t) < 0) ans = t; // hour < 24; minute < 60; update result.
                }
            }
        }
        return ans;
    }
}
