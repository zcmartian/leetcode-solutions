/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 *
 * https://leetcode.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (50.91%)
 * Total Accepted:    333.6K
 * Total Submissions: 655.3K
 * Testcase Example:  '[3,2,3]'
 *
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * 
 */
class Solution {
    public int majorityElement(int[] nums) {
        int ret = 0;
        int[] bits = new int[32];
        for(int num : nums) {
            for(int i=0;i<32;i++) {
                if((num>>(31-i) & 1) ==1) {
                    bits[i]++;
                }
            }
        }

        for(int i=0;i<32;i++) {
            bits[i] = bits[i] > nums.length / 2 ? 1 : 0;
            ret += bits[i]*(1<<(31-i));
        }
        return ret;
    }
}
