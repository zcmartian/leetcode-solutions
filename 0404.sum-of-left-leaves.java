/*
 * @lc app=leetcode id=404 lang=java
 *
 * [404] Sum of Left Leaves
 *
 * https://leetcode.com/problems/sum-of-left-leaves/description/
 *
 * algorithms
 * Easy (48.65%)
 * Total Accepted:    114.9K
 * Total Submissions: 236.3K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Find the sum of all left leaves in a given binary tree.
 * 
 * Example:
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * There are two left leaves in the binary tree, with values 9 and 15
 * respectively. Return 24.
 * 
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
    int ret = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
            return 0;
        helper(root, false);
        return ret;
    }
    private void helper(TreeNode node, boolean isLeft) {
        if(node==null)
            return;
        if(node.left==null&&node.right==null&&isLeft) {
            ret += node.val;
        }
        if(node.left!=null)
            helper(node.left, true);
        if(node.right!=null)
            helper(node.right, false);
    }
}
