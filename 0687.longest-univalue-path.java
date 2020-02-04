/*
 * @lc app=leetcode id=687 lang=java
 *
 * [687] Longest Univalue Path
 *
 * https://leetcode.com/problems/longest-univalue-path/description/
 *
 * algorithms
 * Easy (33.27%)
 * Total Accepted:    50.4K
 * Total Submissions: 151.5K
 * Testcase Example:  '[5,4,5,1,1,5]'
 *
 * Given a binary tree, find the length of the longest path where each node in
 * the path has the same value. This path may or may not pass through the
 * root.
 * 
 * Note: The length of path between two nodes is represented by the number of
 * edges between them.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input:
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   5
 * ⁠          / \   \
 * ⁠         1   1   5
 * 
 * 
 * 
 * 
 * Output:
 * 
 * 2
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input:
 * 
 * ⁠             1
 * ⁠            / \
 * ⁠           4   5
 * ⁠          / \   \
 * ⁠         4   4   5
 * 
 * 
 * 
 * 
 * Output:
 * 
 * 2
 * 
 * 
 * 
 * Note:
 * The given binary tree has not more than 10000 nodes.  The height of the tree
 * is not more than 1000.
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
    private int count = 0;
    public int longestUnivaluePath(TreeNode root) {
        getCount(root);
        return count;
    }
    private int getCount(TreeNode node) {
        if(node==null)
            return 0;
        int left = getCount(node.left);
        int right = getCount(node.right);

        int leftCur = 0;
        int rightCur = 0;

        if(node.left!=null&&node.left.val==node.val)
            leftCur += 1 + left;
        if(node.right!=null&&node.right.val==node.val)
            rightCur += 1 + right;

        count = Math.max(count, leftCur + rightCur);
        return Math.max(leftCur, rightCur);
    }
}
