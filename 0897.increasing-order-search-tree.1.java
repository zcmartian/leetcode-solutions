/*
 * @lc app=leetcode id=897 lang=java
 *
 * [897] Increasing Order Search Tree
 *
 * https://leetcode.com/problems/increasing-order-search-tree/description/
 *
 * algorithms
 * Easy (62.61%)
 * Total Accepted:    21.1K
 * Total Submissions: 33.7K
 * Testcase Example:  '[5,3,6,2,4,null,8,1,null,null,null,7,9]'
 *
 * Given a tree, rearrange the tree in in-order so that the leftmost node in
 * the tree is now the root of the tree, and every node has no left child and
 * only 1 right child.
 * 
 * 
 * Example 1:
 * Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 
 * ⁠      5
 * ⁠     / \
 * ⁠   3    6
 * ⁠  / \    \
 * ⁠ 2   4    8
 * /        / \ 
 * 1        7   9
 * 
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * 
 * ⁠1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * \
 * 7
 * \
 * 8
 * \
 * ⁠                9  
 * 
 * Note:
 * 
 * 
 * The number of nodes in the given tree will be between 1 and 100.
 * Each node will have a unique integer value from 0 to 1000.
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
    public TreeNode increasingBST(TreeNode root) {
        TreeNode curr  = root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev =new TreeNode(-1);
        TreeNode dummy = prev;
        dummy.right = prev;
        while(!stack.empty() || curr != null) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr.left = null;
            if( prev == null) {
                prev.right = curr; // This left most node will be the root of the skewed tree.
            } else {
                prev.right = curr;
                prev.left = null;
                prev = prev.right;
            }
            curr = curr.right;
        }
        return dummy.right;
    }
}
