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
        int[] arr = new int[128];// 用一个map存储匹配字符串中字符的个数
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i)]++;
        }

        int counter = t.length(), left = 0, right = 0, window = Integer.MAX_VALUE, head = -1;
        while (right < s.length()) { //将有指针往后扫
            char rc = s.charAt(right++);
            if (arr[rc] > 0) {//遇到map有的相应的字符计数减一
                counter--;
            }
            arr[rc]--;//同时,待匹配字符串每个字符位个数减一,这样没有在匹配串中的个数为负数,匹配的为0

            while (counter == 0) {//扫描完了匹配串
                if (right - left < window) {//找一个更短的待匹配串
                    window = right - (head = left);
                }

                char lc = s.charAt(left++);//左指针往右扫,试图降低窗口大小
                if (arr[lc] == 0) {//如果移除窗口的字符是匹配字符,则当前窗口已经不满足条件
                    //则counter++意为跳出while循环重新在外层循环中右指针继续扫
                    counter++;
                }
                arr[lc]++;//每个移出窗口的字符个数加一,此处对应46行的减一操作
                //当初外层while循环曾将这个字符个数减一,现在加回去表示我已经考察过字符了,还原现场
            }
        }
        return head == -1 ? "" : s.substring(head, head + window);
    }
}
