/*
 * @lc app=leetcode id=696 lang=java
 *
 * [696] Count Binary Substrings
 *
 * https://leetcode.com/problems/count-binary-substrings/description/
 *
 * algorithms
 * Easy (52.09%)
 * Total Accepted:    25.9K
 * Total Submissions: 49.6K
 * Testcase Example:  '"00110"'
 *
 * Give a string s, count the number of non-empty (contiguous) substrings that
 * have the same number of 0's and 1's, and all the 0's and all the 1's in
 * these substrings are grouped consecutively. 
 * 
 * Substrings that occur multiple times are counted the number of times they
 * occur.
 * 
 * Example 1:
 * 
 * Input: "00110011"
 * Output: 6
 * Explanation: There are 6 substrings that have equal number of consecutive
 * 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
 * Notice that some of these substrings repeat and are counted the number of
 * times they occur.
 * Also, "00110011" is not a valid substring because all the 0's (and 1's) are
 * not grouped together.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "10101"
 * Output: 4
 * Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal
 * number of consecutive 1's and 0's.
 * 
 * 
 * 
 * Note:
 * s.length will be between 1 and 50,000.
 * s will only consist of "0" or "1" characters.
 * 
 */
class Solution {
    public int countBinarySubstrings(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int ret = 0;
        int depth = 0;
        char[] ca = s.toCharArray();
        int len = s.length();
        char flag = ca[0];
        for(int i=0;i<len-1;i++){
            flag = ca[i];
            depth = 0;
            for(int j=i;j<len;j++){
                if(ca[j] == flag){
                    depth += 1;
                } else {
                    depth -= 1;
                    if(depth == 0) {
                        ret += 1;
                        break;
                    }
                    if(j==len-1 || ca[j+1]==flag)
                        break;
                }
            }
        }
        return ret;
    }
}
