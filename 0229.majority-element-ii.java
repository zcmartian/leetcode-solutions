/*
 * @lc app=leetcode id=229 lang=java
 *
 * [229] Majority Element II
 *
 * https://leetcode.com/problems/majority-element-ii/description/
 *
 * algorithms
 * Medium (31.27%)
 * Total Accepted:    92.7K
 * Total Submissions: 296.5K
 * Testcase Example:  '[3,2,3]'
 *
 * Given an integer array of size n, find all elements that appear more than ⌊
 * n/3 ⌋ times.
 * 
 * Note: The algorithm should run in linear time and in O(1) space.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3]
 * Output: [3]
 * 
 * Example 2:
 * 
 * 
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 * 
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if(nums==null||nums.length==0) return ret;

        int n1 = nums[0];
        int count1 = 0;
        int n2 = nums[0];
        int count2 = 0;
        int len = nums.length;
        for(int i=0;i<len;i++) {
            if(nums[i] == n1)
                count1++;
            else if(nums[i] == n2)
                count2++;
            else if(count1==0) {
                n1 = nums[i];
                count1 = 1;
            } else if(count2==0) {
                n2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i=0;i<len;i++) {
            if(n1==nums[i])
                count1++;
            else if(n2==nums[i])
                count2++;
        }
        if(count1 > len / 3)
            ret.add(n1);
        if(count2 > len / 3)
            ret.add(n2);
        return ret;
    }
}
