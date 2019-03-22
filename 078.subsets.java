/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (51.44%)
 * Total Accepted:    339.4K
 * Total Submissions: 659.7K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        int len = nums.length;
        for(int i=0;i<=len;i++) {
            search(ret, new ArrayList(), nums, 0, i);
        }
        return ret;
    }
    private void search(List<List<Integer>> ret, List<Integer> list, int[] nums, int start, int k) {
        if(k==0) {
            ret.add(new ArrayList(list));
            return;
        }
            
        for(int i=start;i<nums.length;i++) {
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            search(ret, list, nums, i+1, k-1);
            list.remove(list.size()-1);
        }
    }
}
