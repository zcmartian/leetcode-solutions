/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (41.39%)
 * Total Accepted:    294.7K
 * Total Submissions: 712.1K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ret = nums[0] + nums[1] + nums[nums.length-1];
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(sum > target) {
                    end--;
                } else {
                    start++;
                }
                if(Math.abs(sum - target) < Math.abs(ret - target))
                    ret = sum;
            }
        }
        return ret;
    }
}
