/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 *
 * https://leetcode.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (47.01%)
 * Total Accepted:    312K
 * Total Submissions: 663.7K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
 *
 * Note:
 *
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 *
 * Example 1:
 *
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 *
 *
 * Example 2:
 *
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 *
 *
 */
 class Solution {
   public List<List<Integer>> combinationSum(int[] candidates, int target) {
     List<List<Integer>> ret = new ArrayList<>();
     List<Integer> found = new ArrayList<>();
     Arrays.sort(candidates);
     search(candidates, 0, target, ret, found);
     return ret;
   }

   private void search(int[] candidates, int start, int target, List<List<Integer>> ret, List<Integer> cur) {
     if(target > 0){
       for(int i = start; i < candidates.length && target >= candidates[i]; i++){
         cur.add(candidates[i]);
         search(candidates, i, target - candidates[i], ret, cur);
         cur.remove(cur.size() - 1);
       }
     }
     else if(target == 0 ){
       ret.add(new ArrayList<Integer>(cur));
     }
   }
 }
