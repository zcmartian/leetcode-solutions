/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (53.25%)
 * Total Accepted:    400.5K
 * Total Submissions: 752.2K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Note:
 * 
 * 
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for(int i = 0;i < nums.length - count;) {
            if(nums[i]!=0) {
                i++;
                continue;
            }

            count++;
            for(int j = i;j < nums.length - count;j++) {
                nums[j] = nums[j+1];
            }
            nums[nums.length-count]=0;
        }
        
    }
}
