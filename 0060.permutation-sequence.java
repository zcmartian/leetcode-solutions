/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 *
 * https://leetcode.com/problems/permutation-sequence/description/
 *
 * algorithms
 * Medium (32.48%)
 * Total Accepted:    131.2K
 * Total Submissions: 403.8K
 * Testcase Example:  '3\n3'
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, we get the
 * following sequence for n = 3:
 * 
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * 
 * Given n and k, return the k^th permutation sequence.
 * 
 * Note:
 * 
 * 
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3, k = 3
 * Output: "213"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 4, k = 9
 * Output: "2314"
 * 
 * 
 */
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new LinkedList();
        StringBuilder res = new StringBuilder();

        int[] f = new int[n];
        f[0] = 1;              // 0's factorial is 1

        for(int i = 1; i < n; i++){
            nums.add(i);
            f[i] = f[i - 1] * i;
        }
        nums.add(n);

        k--;   // 14th count from 1, turn to be 13th count from 0.


        for(int i = n; i > 0; i--){
            int idx = k / f[i - 1];
            k = k % f[i - 1];

            res.append(nums.get(idx));
            nums.remove(idx);
        }
        return res.toString();
    }
}
