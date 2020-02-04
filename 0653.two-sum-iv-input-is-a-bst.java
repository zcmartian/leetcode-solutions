/*
 * @lc app=leetcode id=653 lang=java
 *
 * [653] Two Sum IV - Input is a BST
 *
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
 *
 * algorithms
 * Easy (51.67%)
 * Total Accepted:    73.8K
 * Total Submissions: 142.8K
 * Testcase Example:  '[5,3,6,2,4,null,7]\n9'
 *
 * Given a Binary Search Tree and a target number, return true if there exist
 * two elements in the BST such that their sum is equal to the given target.
 * 
 * Example 1:
 * 
 * 
 * Input: 
 * ⁠   5
 * ⁠  / \
 * ⁠ 3   6
 * ⁠/ \   \
 * 2   4   7
 * 
 * Target = 9
 * 
 * Output: True
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 
 * ⁠   5
 * ⁠  / \
 * ⁠ 3   6
 * ⁠/ \   \
 * 2   4   7
 * 
 * Target = 28
 * 
 * Output: False
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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> a = new ArrayList<>();
        traverse(a, root);
        return check(a, k);
    }
    private void traverse(List<Integer> a, TreeNode node) {
        if(node == null) {
            return;
        }
        traverse(a, node.left);
        a.add(node.val);
        traverse(a, node.right);
    }
    private boolean check(List<Integer> a, int k) {
        for(int i=0,j=a.size()-1;i<j;) {
            int sum = a.get(i) + a.get(j);
            if(sum==k)
                return true;
            else if(sum<k)
                i++;
            else
                j--;
        }
        return false;
    }
}
