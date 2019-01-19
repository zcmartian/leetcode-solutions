/*
 * @lc app=leetcode id=219 lang=java
 *
 * [219] Contains Duplicate II
 *
 * https://leetcode.com/problems/contains-duplicate-ii/description/
 *
 * algorithms
 * Easy (34.38%)
 * Total Accepted:    177.3K
 * Total Submissions: 515.8K
 * Testcase Example:  '[1,2,3,1]\n3'
 *
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * absolute difference between i and j is at most k.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k==0)
            return false;
        
        if(k>=nums.length) {
            Arrays.sort(nums);
            for(int i=0;i<nums.length-1;i++) {
                if(nums[i]==nums[i+1])
                    return true;
            }
            return false;
        }
        for(int i = 0;i < nums.length - k;i++) {
            if(nums[i] == nums[i+k]) 
                return true;
            int j = i+k-1;
            while(i<j) {
                if(nums[i]==nums[j])
                    return true;
                j--;
            }
        }
        int[] ks = new int[k];
        for(int i =0;i<k;i++) {
            ks[i]=nums[nums.length-k+i];
        }
        Arrays.sort(nums);
        for(int i=0;i<ks.length-1;i++) {
            if(ks[i]==ks[i+1])
                return true;
            }
        return false;
    }
}
