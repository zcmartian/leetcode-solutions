#
# @lc app=leetcode id=268 lang=ruby
#
# [268] Missing Number
#
# https://leetcode.com/problems/missing-number/description/
#
# algorithms
# Easy (47.13%)
# Total Accepted:    235.8K
# Total Submissions: 500.2K
# Testcase Example:  '[3,0,1]'
#
# Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find
# the one that is missing from the array.
# 
# Example 1:
# 
# 
# Input: [3,0,1]
# Output: 2
# 
# 
# Example 2:
# 
# 
# Input: [9,6,4,2,3,5,7,0,1]
# Output: 8
# 
# 
# Note:
# Your algorithm should run in linear runtime complexity. Could you implement
# it using only constant extra space complexity?
#
# @param {Integer[]} nums
# @return {Integer}
def missing_number(nums)
    return (0..nums.size).sum - nums.sum    
end
