/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (40.82%)
 * Total Accepted:    202.4K
 * Total Submissions: 495.6K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its zigzag level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
 * ⁠ [15,7]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return ret;

        queue.offer(root);
        boolean left2right = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if(left2right) {
                    if (node.left != null)
                        stack.push(node.left);
                    if (node.right != null)
                        stack.push(node.right);
                } else {
                    if (node.right != null)
                        stack.push(node.right);
                    if (node.left != null)
                        stack.push(node.left);
                }
            }
            while(!stack.isEmpty()) {
                queue.offer(stack.pop());
            }
            left2right = !left2right;
            ret.add(level);
        }
        return ret;
    }
}

