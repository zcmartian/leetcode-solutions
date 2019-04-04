/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 *
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (53.99%)
 * Total Accepted:    187.8K
 * Total Submissions: 347.8K
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * 
 * Note: 
 * 
 * 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is
 * the array's size.
 * 
 * 
 */
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length+1];
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int key : map.keySet()) {
            int frequent = map.get(key);
            if(bucket[frequent] == null) {
                bucket[frequent] = new ArrayList<>();
            }
            bucket[frequent].add(key);
        }
        List<Integer> ret = new ArrayList();
        for(int pos=bucket.length-1;pos>=0&&ret.size()<k;pos--) {
            if(bucket[pos]!=null) {
                ret.addAll(bucket[pos]);
            }
        }
        return ret;
    }
}
