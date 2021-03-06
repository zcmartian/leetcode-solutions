/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 *
 * https://leetcode.com/problems/contains-duplicate/description/
 *
 * algorithms
 * Easy (50.17%)
 * Total Accepted:    287.6K
 * Total Submissions: 573.3K
 * Testcase Example:  '[1,2,3,1]'
 *
 * Given an array of integers, find if the array contains any duplicates.
 * 
 * Your function should return true if any value appears at least twice in the
 * array, and it should return false if every element is distinct.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,1]
 * Output: true
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,3,4]
 * Output: false
 * 
 * Example 3:
 * 
 * 
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * 
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums==null||nums.length<2) return false;
        byte[] mark = new byte[150000000];
        for(int i: nums) {
            int j = i / 8;
            int k = i % 8;
            int check = 1 << k;
            if((mark[j] & check) != 0) {
                return true;
            }
            mark[j] |= check;
        }
        return false;
    }
}
