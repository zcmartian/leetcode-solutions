/*
 * @lc app=leetcode id=1022 lang=java
 *
 * [1022] Sum of Root To Leaf Binary Numbers
 *
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/description/
 *
 * algorithms
 * Easy (41.14%)
 * Total Accepted:    6K
 * Total Submissions: 13.4K
 * Testcase Example:  '[1,0,1,0,1,0,1]'
 *
 * Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path
 * represents a binary number starting with the most significant bit.  For
 * example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent
 * 01101 in binary, which is 13.
 * 
 * For all leaves in the tree, consider the numbers represented by the path
 * from the root to that leaf.
 * 
 * Return the sum of these numbers.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: [1,0,1,0,1,0,1]
 * Output: 22
 * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The number of nodes in the tree is between 1 and 1000.
 * node.val is 0 or 1.
 * The answer will not exceed 2^31 - 1.
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
    public int sumRootToLeaf(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int sum) {
        sum = sum * 2 + root.val;
        if(root.left == null && root.right == null) {
            return sum;
        }
        int leftSum = root.left != null ? dfs(root.left, sum) : 0;
        int rightSum = root.right != null ? dfs(root.right, sum) : 0;
        return leftSum + rightSum;
    }
}
