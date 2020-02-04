/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 *
 * https://leetcode.com/problems/sliding-window-maximum/description/
 *
 * algorithms
 * Hard (37.12%)
 * Total Accepted:    138.8K
 * Total Submissions: 373.8K
 * Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
 *
 * Given an array nums, there is a sliding window of size k which is moving
 * from the very left of the array to the very right. You can only see the k
 * numbers in the window. Each time the sliding window moves right by one
 * position. Return the max sliding window.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7] 
 * Explanation: 
 * 
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * ⁠1 [3  -1  -3] 5  3  6  7       3
 * ⁠1  3 [-1  -3  5] 3  6  7       5
 * ⁠1  3  -1 [-3  5  3] 6  7       5
 * ⁠1  3  -1  -3 [5  3  6] 7       6
 * ⁠1  3  -1  -3  5 [3  6  7]      7
 * 
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty
 * array.
 * 
 * Follow up:
 * Could you solve it in linear time?
 * 
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if(nums==null || len==0 || k < 1 || len < k)
            return new int[0];
        LinkedList<Integer> deq = new LinkedList<>();
        int[] ret = new int[len - k + 1];
        int index = 0;
        for(int i=0;i<len;i++) {
            while(!deq.isEmpty() && nums[deq.peekLast()] <= nums[i])
                deq.pollLast();
            deq.addLast(i);
            if(deq.peekFirst() == i - k)
                deq.pollFirst();
            if(i >= k - 1)
                ret[index++] = nums[deq.peekFirst()];
        }
        return ret;
    }
}
