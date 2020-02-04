#
# @lc app=leetcode id=463 lang=python
#
# [463] Island Perimeter
#
# https://leetcode.com/problems/island-perimeter/description/
#
# algorithms
# Easy (59.94%)
# Total Accepted:    117.8K
# Total Submissions: 196.6K
# Testcase Example:  '[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]'
#
# You are given a map in form of a two-dimensional integer grid where 1
# represents land and 0 represents water.
# 
# Grid cells are connected horizontally/vertically (not diagonally). The grid
# is completely surrounded by water, and there is exactly one island (i.e., one
# or more connected land cells).
# 
# The island doesn't have "lakes" (water inside that isn't connected to the
# water around the island). One cell is a square with side length 1. The grid
# is rectangular, width and height don't exceed 100. Determine the perimeter of
# the island.
# 
# 
# 
# Example:
# 
# 
# Input:
# [[0,1,0,0],
# ⁠[1,1,1,0],
# ⁠[0,1,0,0],
# ⁠[1,1,0,0]]
# 
# Output: 16
# 
# Explanation: The perimeter is the 16 yellow stripes in the image below:
# 
#>>> grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
#>>> zip(*grid)
#[(1, 5, 9), (2, 6, 10), (3, 7, 11), (4, 8, 12)]
#>>> grid + zip(*grid)
#[[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], (1, 5, 9), (2, 6, 10), (3, 7, 11), (4, 8, 12)]
#>>> grid + map(list, zip(*grid))
#[[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [1, 5, 9], [2, 6, 10], [3, 7, 11], [4, 8, 12]]
# 
#
class Solution(object):
    def islandPerimeter(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        return sum(sum(map(operator.ne, [0] + row, row + [0])) for row in grid + map(list, zip(*grid)))        
