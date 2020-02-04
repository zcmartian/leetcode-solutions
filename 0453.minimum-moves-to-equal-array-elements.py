#
# @lc app=leetcode id=453 lang=python
#
# [453] Minimum Moves to Equal Array Elements
#
# https://leetcode.com/problems/minimum-moves-to-equal-array-elements/description/
#
# algorithms
# Easy (48.77%)
# Total Accepted:    52.1K
# Total Submissions: 106.9K
# Testcase Example:  '[1,2,3]'
#
# Given a non-empty integer array of size n, find the minimum number of moves
# required to make all array elements equal, where a move is incrementing n - 1
# elements by 1.
# 
# Example:
# 
# Input:
# [1,2,3]
# 
# Output:
# 3
# 
# Explanation:
# Only three moves are needed (remember each move increments two elements):
# 
# [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
# 
# 
#
# A move can be interpreted as: "Add 1 to every element and subtract one from any one element". sum(nums_new) = sum(nums) + (n-1): we increment only (n-1) elements by 1.
# Visualize the nums array as a bar graph where the value at each index is a bar of height nums[i]. We are looking for minimum moves such that all bars reach the final same height.
# Now adding 1 to all the bars in the initial state does not change the initial state - it simply shifts the initial state uniformly by 1.This gives us the insight that a single move is equivalent to subtracting 1 from any one element with respect to the goal of reaching a final state with equal heights.
# So our new problem is to find the minimum number of moves to reach a final state where all nums are equal and in each move we subtract 1 from any element.
# The final state must be a state where every element is equal to the minimum element. Say we make K moves to reach the final state. Then we have the equation, N * min(nums) = sum(nums) - K.

class Solution(object):
    def minMoves(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return sum(nums) - len(nums) * min(nums)        
