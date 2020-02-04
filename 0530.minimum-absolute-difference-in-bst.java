/*
 * @lc app=leetcode id=530 lang=java
 *
 * [530] Minimum Absolute Difference in BST
 *
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
 *
 * algorithms
 * Easy (49.38%)
 * Total Accepted:    51.2K
 * Total Submissions: 103.7K
 * Testcase Example:  '[1,null,3,2]'
 *
 * Given a binary search tree with non-negative values, find the minimum
 * absolute difference between values of any two nodes.
 * 
 * Example:
 * 
 * 
 * Input:
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    3
 * ⁠   /
 * ⁠  2
 * 
 * Output:
 * 1
 * 
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and
 * 1 (or between 2 and 3).
 * 
 * 
 * 
 * 
 * Note: There are at least two nodes in this BST.
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
import java.util.List;
class Solution {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        int ret = Integer.MAX_VALUE;
        for(int i=0;i<list.size()-1;i++){
            if(ret > list.get(i+1)-list.get(i)){
                ret = list.get(i+1) - list.get(i);
            }
        }
        return ret;
    }
    private void traverse(TreeNode root, List<Integer> list) {
        if(root == null){
            return; 
        }

        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }
}
