/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 *
 * https://leetcode.com/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (39.72%)
 * Total Accepted:    153.4K
 * Total Submissions: 386.2K
 * Testcase Example:  '"aab"'
 *
 * Given a string s, partition s such that every substring of the partition is
 * a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * Example:
 * 
 * 
 * Input: "aab"
 * Output:
 * [
 * ⁠ ["aa","b"],
 * ⁠ ["a","a","b"]
 * ]
 * 
 * 
 */
class Solution {
    List<List<String>> resultLst;
    ArrayList<String> currLst;
    public List<List<String>> partition(String s) {
        resultLst = new ArrayList<List<String>>();
        currLst = new ArrayList<String>();
        backTrack(s,0);
        return resultLst;
    }
    public void backTrack(String s, int l){
        if(currLst.size()>0 //the initial str could be palindrome
                && l>=s.length()){
            List<String> r = (ArrayList<String>) currLst.clone();
            resultLst.add(r);
                }
        for(int i=l;i<s.length();i++){
            if(isPalindrome(s,l,i)){
                if(l==i)
                    currLst.add(Character.toString(s.charAt(i)));
                else
                    currLst.add(s.substring(l,i+1));
                backTrack(s,i+1);
                currLst.remove(currLst.size()-1);
            }
        }
    }
    public boolean isPalindrome(String str, int l, int r){
        if(l==r) return true;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }
}
