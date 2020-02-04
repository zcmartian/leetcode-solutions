/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (53.76%)
 * Total Accepted:    348K
 * Total Submissions: 647.2K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3]
 * Output:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 * 
 */
class Solution {
    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums==null || nums.length==0) return ret;

        search(nums, 0);
        return ret;
    }
    private void search(int[] nums, int index) {
        if(index == nums.length) {
            List<Integer> list = new ArrayList<Integer>();
            for(int i : nums){
                list.add(i);
            }
            ret.add(list);
        }
        for(int i=index;i<nums.length;i++) {
            swap(nums, i, index);
            search(nums, index+1);
            swap(nums, i, index);
        }
    }
    private void swap(int[] nums, int i, int j) {
        if(i == j) return;

        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
