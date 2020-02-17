/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 *
 * https://leetcode.com/problems/count-and-say/description/
 *
 * algorithms
 * Easy (39.12%)
 * Total Accepted:    250.5K
 * Total Submissions: 640.3K
 * Testcase Example:  '1'
 *
 * The count-and-say sequence is the sequence of integers with the first five
 * terms as following:
 * 
 * 
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the
 * count-and-say sequence.
 * 
 * Note: Each term of the sequence of integers will be represented as a
 * string.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 1
 * Output: "1"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 4
 * Output: "1211"
 * 
 */
class Solution {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";

        String last = countAndSay(n - 1);
        return getNextString(last);
    }

    private String getNextString(String str) {
        if(str.length()==0)
            return "";

        int num = getRepeatNum(str);
        return num + "" + str.charAt(0) + getNextString(str.substring(num));
    }

    private int getRepeatNum(String str) {
        int count = 1;
        char c = str.charAt(0);
        for(int i=1;i<str.length();i++){
            if(c == str.charAt(i)){
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
