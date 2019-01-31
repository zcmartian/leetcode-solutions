/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (32.81%)
 * Total Accepted:    392.8K
 * Total Submissions: 1.2M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * 
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * Note:
 * 
 * All given inputs are in lowercase letters a-z.
 * 
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0)
            return "";
        if(strs.length==1)
            return strs[0];
        int n = Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            n = Math.min(n, strs[i].length());
        }
        if(n==0)
            return "";
        int i = 0;
        while(i<n) {
            char c = strs[0].charAt(i);
            for(int j=0;j<strs.length;j++){
                if(i<n && strs[j].charAt(i)!=c)
                    return strs[j].substring(0,i);
            }
            i++;
        }
        return strs[0].substring(0,n);
    }
}
