/*
 * @lc app=leetcode id=557 lang=java
 *
 * [557] Reverse Words in a String III
 *
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
 *
 * algorithms
 * Easy (62.72%)
 * Total Accepted:    107.6K
 * Total Submissions: 171.5K
 * Testcase Example:  '"Let\'s take LeetCode contest"'
 *
 * Given a string, you need to reverse the order of characters in each word
 * within a sentence while still preserving whitespace and initial word order.
 * 
 * Example 1:
 * 
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * 
 * 
 * 
 * Note:
 * In the string, each word is separated by single space and there will not be
 * any extra space in the string.
 * 
 */
class Solution {
    public String reverseWords(String s) {
        String ret = "";
        int left=0,right=s.length()-1;
        char[] srr = s.toCharArray();
        while(left < srr.length && srr[left] == ' '){  //pop out the space at the begining
            left++;
        }
        while(right >= 0 && srr[right] == ' '){  //pop out the space at the end
            right--;
        }
        int start=left;
        for(int i=left;i<=right;i++){
            if(srr[i]==' ') {
                ret += reverse(s.substring(start,i));
                start = i + 1;
                ret += ' ';
            }
        }
        ret += reverse(s.substring(start,right+1));
        return ret;
    }
    private String reverse(String word) {
        String ret = "";
        for(int i=word.length()-1;i>=0;i--){
            ret += word.charAt(i);
        }
        return ret;
    }
}
