/*
 * @lc app=leetcode id=414 lang=java
 *
 * [414] Third Maximum Number
 *
 * https://leetcode.com/problems/third-maximum-number/description/
 *
 * algorithms
 * Easy (28.54%)
 * Total Accepted:    80.7K
 * Total Submissions: 282.9K
 * Testcase Example:  '[3,2,1]'
 *
 * Given a non-empty array of integers, return the third maximum number in this
 * array. If it does not exist, return the maximum number. The time complexity
 * must be in O(n).
 * 
 * Example 1:
 * 
 * Input: [3, 2, 1]
 * 
 * Output: 1
 * 
 * Explanation: The third maximum is 1.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [1, 2]
 * 
 * Output: 2
 * 
 * Explanation: The third maximum does not exist, so the maximum (2) is
 * returned instead.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: [2, 2, 3, 1]
 * 
 * Output: 1
 * 
 * Explanation: Note that the third maximum here means the third maximum
 * distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 * 
 * 
 */
class Solution {
    public int thirdMax(int[] nums) {
        Integer max1 = null, max2 = null, max3 = null;
        for(Integer value : nums) {
            if(value.equals(max1) || value.equals(max2) || value.equals(max3))
                continue;
            if(max1 == null || value>max1){
                max3 = max2;
                max2 = max1;
                max1 = value;
            } else if(max2 == null || value>max2) {
                max3 = max2;
                max2 = value;
            } else if(max3 == null || value>max3) {
                max3 = value;
            }
        }
        return max3 == null?max1 : max3;
    }
}
