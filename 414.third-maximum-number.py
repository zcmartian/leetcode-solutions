#
# @lc app=leetcode id=414 lang=python
#
# [414] Third Maximum Number
#
# https://leetcode.com/problems/third-maximum-number/description/
#
# algorithms
# Easy (28.54%)
# Total Accepted:    80.7K
# Total Submissions: 282.9K
# Testcase Example:  '[3,2,1]'
#
# Given a non-empty array of integers, return the third maximum number in this
# array. If it does not exist, return the maximum number. The time complexity
# must be in O(n).
# 
# Example 1:
# 
# Input: [3, 2, 1]
# 
# Output: 1
# 
# Explanation: The third maximum is 1.
# 
# 
# 
# Example 2:
# 
# Input: [1, 2]
# 
# Output: 2
# 
# Explanation: The third maximum does not exist, so the maximum (2) is returned
# instead.
# 
# 
# 
# Example 3:
# 
# Input: [2, 2, 3, 1]
# 
# Output: 1
# 
# Explanation: Note that the third maximum here means the third maximum
# distinct number.
# Both numbers with value 2 are both considered as second maximum.
# 
# 
#
class Solution(object):
    def thirdMax(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        v = [float('-inf'), float('-inf'), float('-inf')]
        for i in nums:
            if i not in v:
                if i > v[0]:
                    v= [i, v[0], v[1]]
                elif i > v[1]:
                    v= [v[0], i, v[1]]
                elif i > v[2]:
                    v= [v[0], v[1], i]
        return max(nums) if float('-inf') in v else v[2]
