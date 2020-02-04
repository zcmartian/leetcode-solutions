/*
 * @lc app=leetcode id=993 lang=java
 *
 * [993] Cousins in Binary Tree
 *
 * https://leetcode.com/problems/cousins-in-binary-tree/description/
 *
 * algorithms
 * Easy (53.98%)
 * Total Accepted:    5.9K
 * Total Submissions: 10.9K
 * Testcase Example:  '[1,2,3,4]\n4\n3'
 *
 * In a binary tree, the root node is at depth 0, and children of each depth k
 * node are at depth k+1.
 * 
 * Two nodes of a binary tree are cousins if they have the same depth, but have
 * different parents.
 * 
 * We are given the root of a binary tree with unique values, and the values x
 * and y of two different nodes in the tree.
 * 
 * Return true if and only if the nodes corresponding to the values x and y are
 * cousins.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * 
 * 
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The number of nodes in the tree will be between 2 and 100.
 * Each node has a unique integer value from 1 to 100.
 * 
 * 
 * 
 * 
 * 
 * 
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
    public boolean isCousins(TreeNode root, int A, int B) {

        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isAexist = false;
            boolean isBexist = false;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.val == A) isAexist = true;
                if (cur.val == B) isBexist = true;
                if (cur.left != null && cur.right != null) {
                    if (cur.left.val == A && cur.right.val == B) {
                        return false;
                    }
                    if (cur.left.val == B && cur.right.val == A) {
                        return false;
                    }
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            if (isAexist && isBexist)  return true;
        }
        return false;
    }
}
