/*
 * @lc app=leetcode id=164 lang=java
 *
 * [164] Maximum Gap
 *
 * https://leetcode.com/problems/maximum-gap/description/
 *
 * algorithms
 * Hard (31.84%)
 * Total Accepted:    66.2K
 * Total Submissions: 208K
 * Testcase Example:  '[3,6,9,1]'
 *
 * Given an unsorted array, find the maximum difference between the successive
 * elements in its sorted form.
 * 
 * Return 0 if the array contains less than 2 elements.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,6,9,1]
 * Output: 3
 * Explanation: The sorted form of the array is [1,3,6,9], either
 * (3,6) or (6,9) has the maximum difference 3.
 * 
 * Example 2:
 * 
 * 
 * Input: [10]
 * Output: 0
 * Explanation: The array contains less than 2 elements, therefore return 0.
 * 
 * Note:
 * 
 * 
 * You may assume all elements in the array are non-negative integers and fit
 * in the 32-bit signed integer range.
 * Try to solve it in linear time/space.
 * 
 * 
 */
class Solution {
    public int maximumGap(int[] nums) {
        if(nums==null||nums.length<2)
            return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int gap = (int) Math.ceil((double)(max - min)/(nums.length - 1));
        int[] minBuckets = new int[nums.length - 1];
        int[] maxBuckets = new int[nums.length - 1];
        Arrays.fill(minBuckets, Integer.MAX_VALUE);
        Arrays.fill(maxBuckets, Integer.MIN_VALUE);
        for(int i : nums) {
            if(i == min || i == max)
                continue;
            int idx = (i - min) / gap;
            minBuckets[idx] = Math.min(i, minBuckets[idx]);
            maxBuckets[idx] = Math.max(i, maxBuckets[idx]);
        }
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for(int i=0;i<nums.length-1;i++) {
            if(minBuckets[i] == Integer.MAX_VALUE && maxBuckets[i] == Integer.MIN_VALUE)
                continue;
            maxGap = Math.max(maxGap, minBuckets[i] - previous);
            previous = maxBuckets[i];
        }
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
    }
}
