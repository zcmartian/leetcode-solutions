/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (33.06%)
 * Total Accepted:    273.3K
 * Total Submissions: 826.7K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0) return new int[]{-1,-1};
        return search(nums, target, 0, nums.length-1);
    }
    private int[] search(int[] nums, int target, int lo, int hi) {
        if(nums[lo]==target && nums[hi]==target)
            return new int[] {lo, hi};

        if(nums[lo]<=target && target<=nums[hi]) {
            int mid = lo + (hi - lo) / 2;
            int[] left = search(nums, target, lo, mid);
            int[] right = search(nums, target, mid+1, hi);
            if(left[0] >= 0 && right[0] >= 0) {
                return new int[]{left[0], right[1]};
            }
            return left[0] == -1 ? right : left;
        }
        return new int[] {-1,-1};
    }
}

