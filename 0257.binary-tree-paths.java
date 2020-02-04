/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
 *
 * https://leetcode.com/problems/binary-tree-paths/description/
 *
 * algorithms
 * Easy (44.80%)
 * Total Accepted:    207.6K
 * Total Submissions: 463.4K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * 
 * Input:
 * 
 * ⁠  1
 * ⁠/   \
 * 2     3
 * ⁠\
 * ⁠ 5
 * 
 * Output: ["1->2->5", "1->3"]
 * 
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if(root!=null)
            searchBT(root, "", ret);
        return ret;
    }
    private void searchBT(TreeNode node, String path, List<String> ret) {
        if(node.left==null&&node.right==null)
            ret.add(path + node.val);
        if(node.left!=null)
            searchBT(node.left, path + node.val + "->", ret);
        if(node.right!=null)
            searchBT(node.right, path + node.val + "->", ret);
    }
}
