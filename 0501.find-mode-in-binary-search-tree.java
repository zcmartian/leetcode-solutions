/*
 * @lc app=leetcode id=501 lang=java
 *
 * [501] Find Mode in Binary Search Tree
 *
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
 *
 * algorithms
 * Easy (38.72%)
 * Total Accepted:    49.2K
 * Total Submissions: 126.9K
 * Testcase Example:  '[1,null,2,2]'
 *
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the
 * most frequently occurred element) in the given BST.
 * 
 * Assume a BST is defined as follows:
 * 
 * 
 * The left subtree of a node contains only nodes with keys less than or equal
 * to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or
 * equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * 
 * 
 * For example:
 * Given BST [1,null,2,2],
 * 
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  2
 * 
 * 
 * 
 * 
 * return [2].
 * 
 * Note: If a tree has more than one mode, you can return them in any order.
 * 
 * Follow up: Could you do that without using any extra space? (Assume that the
 * implicit stack space incurred due to recursion does not count).
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
    Integer prev = null;
    int count = 1;
    int max = 0;
    public int[] findMode(TreeNode root) {
        if(root==null)
            return new int[0];
        List<Integer> list = new ArrayList<>();
        traverse(list, root);
        int[] ret = new int[list.size()];
        int i=0;
        for(int v : list)
            ret[i++] = v;
        return ret;
    }
    private void traverse(List<Integer> list, TreeNode node) {
        if(node==null)
            return;
        traverse(list, node.left);
        if(prev!=null)
            if(prev == node.val)
                count++;
            else
                count = 1;
        if(count > max) {
            max = count;
            list.clear();
            list.add(node.val);
        } else if(count == max) {
            list.add(node.val);
        }
        prev = node.val;
        traverse(list, node.right);
    }
}
