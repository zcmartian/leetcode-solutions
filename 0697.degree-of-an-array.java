/*
 * [697] Degree of an Array
 *
 * https://leetcode.com/problems/degree-of-an-array/description/
 *
 * algorithms
 * Easy (47.13%)
 * Total Accepted:    27.1K
 * Total Submissions: 57.5K
 * Testcase Example:  '[1,2,2,3,1]'
 *
 * Given a non-empty array of non-negative integers nums, the degree of this
 * array is defined as the maximum frequency of any one of its elements.
 * Your task is to find the smallest possible length of a (contiguous) subarray
 * of nums, that has the same degree as nums.
 * 
 * Example 1:
 * 
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation: 
 * The input array has a degree of 2 because both elements 1 and 2 appear
 * twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * 
 * 
 * 
 * Note:
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 * 
 */
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int findShortestSubArray(int[] nums) {
        if(nums == null || nums.length==0)
            return 0;

        Map<Integer, int[]> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[]{1, i, i});
            } else {
                int[] current = map.get(nums[i]);
                current[0]++;
                current[2]=i;
            }
        }
        int degree = Integer.MIN_VALUE;
        int result = Integer.MAX_VALUE;
        for(int[] value : map.values()) {
            if(value[0] > degree) {
                degree=value[0];
                result = value[2]-value[1]+1;
            } else if (degree == value[0]) {
                result = Math.min(value[2]-value[1]+1, result);
            }
        }
        return result;
    }
}
