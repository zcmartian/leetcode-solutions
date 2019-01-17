/*
 * @lc app=leetcode id=581 lang=java
 *
 * [581] Shortest Unsorted Continuous Subarray
 *
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 *
 * algorithms
 * Easy (29.52%)
 * Total Accepted:    54.3K
 * Total Submissions: 183.8K
 * Testcase Example:  '[2,6,4,8,10,9,15]'
 *
 * Given an integer array, you need to find one continuous subarray that if you
 * only sort this subarray in ascending order, then the whole array will be
 * sorted in ascending order, too.  
 * 
 * You need to find the shortest such subarray and output its length.
 * 
 * Example 1:
 * 
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make
 * the whole array sorted in ascending order.
 * 
 * 
 * 
 * Note:
 * 
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means . 
 * 
 * 
 */
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length<2) 
            return 0;

        int[] index = new int[nums.length-1];
        for (int i=0;i<nums.length-1;i++) {
            index[i] = -1;
        }
        int k = 0;
        boolean firstBlood = false;
        for( int i = 0;i < nums.length - 1;i++) {
            if (nums[i] > nums[i+1]) {
                index[k++] = i;
                firstBlood = true;
            } else if (firstBlood && nums[i] == nums[i+1]) {
                index[k++] = i;
            }
        }
        int count = 0;
        for(int i=0;i<nums.length-1;i++) {
            if(index[i]!=-1) {
                count++;
            } else {
                break;
            }
        }
        return count == 0 ? 0 : index[count-1] - index[0] + 2;
    }
}
