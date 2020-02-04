/*
 * @lc app=leetcode id=747 lang=java
 *
 * [747] Largest Number At Least Twice of Others
 *
 * https://leetcode.com/problems/largest-number-at-least-twice-of-others/description/
 *
 * algorithms
 * Easy (40.20%)
 * Total Accepted:    41.3K
 * Total Submissions: 102.8K
 * Testcase Example:  '[0,0,0,1]'
 *
 * In a given integer array nums, there is always exactly one largest element.
 * 
 * Find whether the largest element in the array is at least twice as much as
 * every other number in the array.
 * 
 * If it is, return the index of the largest element, otherwise return -1.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [3, 6, 1, 0]
 * Output: 1
 * Explanation: 6 is the largest integer, and for every other number in the
 * array x,
 * 6 is more than twice as big as x.  The index of value 6 is 1, so we return
 * 1.
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1, 2, 3, 4]
 * Output: -1
 * Explanation: 4 isn't at least as big as twice the value of 3, so we return
 * -1.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * nums will have a length in the range [1, 50].
 * Every nums[i] will be an integer in the range [0, 99].
 * 
 * 
 * 
 * 
 */
class Solution {
    public int dominantIndex(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        if(nums.length == 1){
            return 0;
        }
        int max = Integer.MIN_VALUE + 1;
        int secondMax = Integer.MIN_VALUE;
        int index = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                secondMax = max;
                max = nums[i];
                index = i;
            } else if(nums[i] != max && nums[i] > secondMax){
                secondMax = nums[i];
            }
        }
        if(secondMax * 2 <= max){
            return index;
        }
        return -1;        
    }
}
