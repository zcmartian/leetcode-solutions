/*
 * @lc app=leetcode id=530 lang=java
 *
 * [530] Minimum Absolute Difference in BST
 *
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
 *
 * algorithms
 * Easy (49.44%)
 * Total Accepted:    51.5K
 * Total Submissions: 104.1K
 * Testcase Example:  '[1,null,3,2]'
 *
 * Given a binary search tree with non-negative values, find the minimum
 * absolute difference between values of any two nodes.
 * 
 * Example:
 * 
 * 
 * Input:
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    3
 * ⁠   /
 * ⁠  2
 * 
 * Output:
 * 1
 * 
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and
 * 1 (or between 2 and 3).
 * 
 * 
 * 
 * 
 * Note: There are at least two nodes in this BST.
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        dfs(root, null, null);
        return min;
    }
    private void dfs(TreeNode root, Integer pre, Integer next) {
        if(root==null)
            return;
        if(pre!=null)
            min = Math.min(min, root.val-pre);
        if(next!=null)
            min = Math.min(min, next-root.val);
        dfs(root.left, pre, root.val);
        dfs(root.right, root.val, next);
    }
}
