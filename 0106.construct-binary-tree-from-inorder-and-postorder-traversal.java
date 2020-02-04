/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (38.35%)
 * Total Accepted:    144.5K
 * Total Submissions: 376.8K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,inorder.length-1,0,postorder,postorder.length-1);
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart){
        if(inEnd > inStart){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postStart]);
        if(inEnd == inStart){
            return root;
        }
        int index = 0;
        // find the index in inorder:
        for(int i = inStart; i >= inEnd; i--){
            if(inorder[i] == root.val){
                index = i;
                break;
            }
        }

        root.right = build(inorder,inStart,index+1,postorder,postStart-1);
        root.left = build(inorder,index-1,inEnd,postorder,postStart-(inStart-index)-1);

        return root;
    }
}
