/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 *
 * https://leetcode.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (39.78%)
 * Total Accepted:    218.6K
 * Total Submissions: 549.5K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 
 * ⁠     5
 * ⁠    / \
 * ⁠   4   8
 * ⁠  /   / \
 * ⁠ 11  13  4
 * ⁠/  \    / \
 * 7    2  5   1
 * 
 * 
 * Return:
 * 
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
 * ]
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
    private List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null)
            return ret;
        search(root, new ArrayList(), sum);
        return ret;
    }
    private void search(TreeNode node, List<Integer> list, int sum) {
        if(node==null) return;
        list.add(node.val);
        if(node.left==null && node.right==null && sum==node.val) {
            ret.add(new ArrayList(list));
            list.remove(list.size()-1);
            return;
        } else {
            search(node.left, list, sum-node.val);
            search(node.right, list, sum-node.val);
        }
        list.remove(list.size()-1);
    }
}
