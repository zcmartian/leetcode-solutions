/*
 * @lc app=leetcode id=434 lang=java
 *
 * [434] Number of Segments in a String
 *
 * https://leetcode.com/problems/number-of-segments-in-a-string/description/
 *
 * algorithms
 * Easy (36.54%)
 * Total Accepted:    50K
 * Total Submissions: 136.8K
 * Testcase Example:  '"Hello, my name is John"'
 *
 * Count the number of segments in a string, where a segment is defined to be a
 * contiguous sequence of non-space characters.
 * 
 * Please note that the string does not contain any non-printable characters.
 * 
 * Example:
 * 
 * Input: "Hello, my name is John"
 * Output: 5
 * 
 * 
 */
class Solution {
    public int countSegments(String s) {
        int ret = 0;
        boolean start = false;
        int n = s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)!=' ' && s.charAt(i)!='\t') {
                if(!start)
                    start = true;
            } else {
                if(start) {
                    ret += 1;
                    start = false;
                }
            }
        }
        if(start)
            ret += 1;
        return ret;
    }
}
