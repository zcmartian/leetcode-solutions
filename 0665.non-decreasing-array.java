/*
 * @lc app=leetcode id=665 lang=java
 *
 * [665] Non-decreasing Array
 *
 * https://leetcode.com/problems/non-decreasing-array/description/
 *
 * algorithms
 * Easy (19.63%)
 * Total Accepted:    40.7K
 * Total Submissions: 207.3K
 * Testcase Example:  '[4,2,3]'
 *
 * 
 * Given an array with n integers, your task is to check if it could become
 * non-decreasing by modifying at most 1 element.
 * 
 * 
 * 
 * We define an array is non-decreasing if array[i]  holds for every i (1 
 * 
 * Example 1:
 * 
 * Input: [4,2,3]
 * Output: True
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing
 * array.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [4,2,1]
 * Output: False
 * Explanation: You can't get a non-decreasing array by modify at most one
 * element.
 * 
 * 
 * 
 * Note:
 * The n belongs to [1, 10,000].
 * 
 */
class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i=1;i<nums.length && count<=1;i++) {
            if(nums[i-1]>nums[i]) {
                count++;
                if(i<2 || nums[i-2]<=nums[i])
                    nums[i-1]=nums[i];
                else
                    nums[i]=nums[i-1];
            }
        }
        return count<=1;
    }
}