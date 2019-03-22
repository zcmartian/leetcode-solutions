/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (46.37%)
 * Total Accepted:    189.5K
 * Total Submissions: 408.5K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: n = 4, k = 2
 * Output:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        search(ret, list, 1, n, k);
        return ret;
    }
    private void search(List<List<Integer>> ret, List<Integer> list, int index, int n, int k) {
        if(k==0) {
            ret.add(new ArrayList(list));
            return;
        }

        for(int i=index;i<=n;i++) {
            list.add(i);
            search(ret, list, i+1, n, k-1);
            list.remove(list.size()-1);
        }
    }
}
