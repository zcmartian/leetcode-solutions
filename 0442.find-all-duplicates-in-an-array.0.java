/*
 * @lc app=leetcode id=442 lang=java
 *
 * [442] Find All Duplicates in an Array
 *
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 *
 * algorithms
 * Medium (59.44%)
 * Total Accepted:    84.5K
 * Total Submissions: 142.2K
 * Testcase Example:  '[4,3,2,7,8,2,3,1]'
 *
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements
 * appear twice and others appear once.
 * 
 * Find all the elements that appear twice in this array.
 * 
 * Could you do it without extra space and in O(n) runtime?
 * 
 * Example:
 * 
 * Input:
 * [4,3,2,7,8,2,3,1]
 * 
 * Output:
 * [2,3]
 * 
 */
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        if (nums == null || nums.length == 1)
            return new ArrayList();

        List<Integer> ret = new ArrayList();
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            while (val>0 && val != nums[val-1]) {
                tmp = nums[val-1];
                nums[val-1] = val;
                val = tmp;
                if (val - 1 == i) {
                    break;
                }
            }
            if (val>0&&val - 1 != i) {
                ret.add(val);
            }
            if (i==0)
                nums[0] = 0;
        }
        return ret;
    }
}
