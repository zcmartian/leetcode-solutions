/*
 * @lc app=leetcode id=1046 lang=java
 *
 * [1046] Last Stone Weight
 *
 * https://leetcode.com/problems/last-stone-weight/description/
 *
 * algorithms
 * Easy (64.12%)
 * Total Accepted:    3.9K
 * Total Submissions: 6.1K
 * Testcase Example:  '[2,7,4,1,8,1]'
 *
 * We have a collection of rocks, each rock has a positive integer weight.
 * 
 * Each turn, we choose the two heaviest rocks and smash them together.
 * Suppose the stones have weights x and y with x <= y.  The result of this
 * smash is:
 * 
 * 
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of
 * weight y has new weight y-x.
 * 
 * 
 * At the end, there is at most 1 stone left.  Return the weight of this stone
 * (or 0 if there are no stones left.)
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation: 
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the
 * value of last stone.
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 * 
 */
class Solution {
    int ret = 0;
    public int lastStoneWeight(int[] stones) {
        if(stones==null) return 0;
        if(stones.length==1) return stones[0];

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones) {
            q.offer(i);
        }
        while(q.size() > 1) {
            int max1 = q.poll();
            int max2 = q.poll();
            if(max1 > max2)
                q.offer(max1 - max2);
        }
        return q.size() > 0 ? q.poll() : 0;
    }
}
