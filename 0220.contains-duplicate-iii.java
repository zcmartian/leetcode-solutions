/*
 * @lc app=leetcode id=220 lang=java
 *
 * [220] Contains Duplicate III
 *
 * https://leetcode.com/problems/contains-duplicate-iii/description/
 *
 * algorithms
 * Medium (19.42%)
 * Total Accepted:    85.9K
 * Total Submissions: 442.4K
 * Testcase Example:  '[1,2,3,1]\n3\n0'
 *
 * Given an array of integers, find out whether there are two distinct indices
 * i and j in the array such that the absolute difference between nums[i] and
 * nums[j] is at most t and the absolute difference between i and j is at most
 * k.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k < 1 || t < 0)
			return false;

		TreeSet<Long> values = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			long num = nums[i];	// 转为 Long 型，避免了整形溢出情况。
			Long floor = values.floor(num + t); // 小于等于
			Long ceil = values.ceiling(num - t); // 大于等于
			if((floor != null && floor >= num)
					|| (ceil != null && ceil <= num))
				return true;

			values.add(num);
			if(i >= k)
				values.remove((long)(nums[i - k]));
		}
		return false;
    }
}
