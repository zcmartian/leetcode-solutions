/*
 * @lc app=leetcode id=506 lang=java
 *
 * [506] Relative Ranks
 *
 * https://leetcode.com/problems/relative-ranks/description/
 *
 * algorithms
 * Easy (47.89%)
 * Total Accepted:    39.5K
 * Total Submissions: 82.5K
 * Testcase Example:  '[5,4,3,2,1]'
 *
 * 
 * Given scores of N athletes, find their relative ranks and the people with
 * the top three highest scores, who will be awarded medals: "Gold Medal",
 * "Silver Medal" and "Bronze Medal".
 * 
 * Example 1:
 * 
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so
 * they got "Gold Medal", "Silver Medal" and "Bronze Medal". For the left two
 * athletes, you just need to output their relative ranks according to their
 * scores.
 * 
 * 
 * 
 * Note:
 * 
 * N is a positive integer and won't exceed 10,000.
 * All the scores of athletes are guaranteed to be unique.
 * 
 * 
 * 
 */
class Solution {
    public String[] findRelativeRanks(int[] nums) {
        Map<Integer,Integer> hm = new HashMap<>();
        String[] arr = new String[nums.length];
        for(int i=0;i<nums.length;i++)
            hm.put(nums[i],i);
        Arrays.sort(nums);
        String[] medal= {"Gold Medal","Silver Medal","Bronze Medal"};
        for(int i=0;i<nums.length && i<3;i++) {
        arr[hm.get(nums[nums.length-1-i])]=medal[i];
        }
        int pos=4;
        for(int i=nums.length-4;i>=0;i--) {
            arr[hm.get(nums[i])]=String.valueOf(pos);
            pos++;
        }
        return arr;        
    }
}
