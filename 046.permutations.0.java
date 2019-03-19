/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (53.71%)
 * Total Accepted:    347.1K
 * Total Submissions: 646.1K
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
    private boolean[] ocu;
    public List<List<Integer>> permute(int[] nums) {
        ocu = new boolean[nums.length];
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<Integer>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(!ocu[i]) {
                    ocu[i] = true;
                    tempList.add(nums[i]);
                    backtrack(list, tempList, nums);
                    tempList.remove(tempList.size() - 1);
                    ocu[i] = false;
                }
            }
        }
    }
}
