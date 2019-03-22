/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (29.93%)
 * Total Accepted:    214.4K
 * Total Submissions: 716.4K
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * Example:
 * 
 * 
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * 
 * 
 * Note:
 * 
 * 
 * If there is no such window in S that covers all characters in T, return the
 * empty string "".
 * If there is such window, you are guaranteed that there will always be only
 * one unique minimum window in S.
 * 
 */
class Solution {
    public String minWindow(String s, String t) {
        int[] arr = new int[128];
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i)]++;
        }

        int counter = t.length(), left = 0, right = 0, window = Integer.MAX_VALUE, head = -1;
        while (right < s.length()) {
            char rc = s.charAt(right++);
            if (arr[rc] > 0) {
                counter--;
            }
            arr[rc]--;

            while (counter == 0) {
                if (right - left < window) {
                    window = right - (head = left);
                }

                char lc = s.charAt(left++);
                if (arr[lc] == 0) {
                    counter++;
                }
                arr[lc]++;
            }
        }
        return head == -1 ? "" : s.substring(head, head + window);
    }
}
