/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input array is sorted
 *
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * algorithms
 * Easy (48.54%)
 * Total Accepted:    196.5K
 * Total Submissions: 404.9K
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2.
 * 
 * Note:
 * 
 * 
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may
 * not use the same element twice.
 * 
 * 
 * Example:
 * 
 * 
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * 
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        int len = numbers.length;
        int front = 0;
        int end = len - 1;
        for (;front < end;) {
            int sum = numbers[front] + numbers[end];
            if (sum == target) {
                ret[0] = front + 1;
                ret[1] = end + 1;
                return ret;
            } else {
                if (sum < target) {
                    front++;
                } else {
                    end--;
                }
            }
        }
        return ret;
    }
}
