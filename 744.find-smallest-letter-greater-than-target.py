#
# @lc app=leetcode id=744 lang=python
#
# [744] Find Smallest Letter Greater Than Target
#
# https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
#
# algorithms
# Easy (43.49%)
# Total Accepted:    33.5K
# Total Submissions: 77.1K
# Testcase Example:  '["c","f","j"]\n"a"'
#
# 
# Given a list of sorted characters letters containing only lowercase letters,
# and given a target letter target, find the smallest element in the list that
# is larger than the given target.
# 
# Letters also wrap around.  For example, if the target is target = 'z' and
# letters = ['a', 'b'], the answer is 'a'.
# 
# 
# Examples:
# 
# Input:
# letters = ["c", "f", "j"]
# target = "a"
# Output: "c"
# 
# Input:
# letters = ["c", "f", "j"]
# target = "c"
# Output: "f"
# 
# Input:
# letters = ["c", "f", "j"]
# target = "d"
# Output: "f"
# 
# Input:
# letters = ["c", "f", "j"]
# target = "g"
# Output: "j"
# 
# Input:
# letters = ["c", "f", "j"]
# target = "j"
# Output: "c"
# 
# Input:
# letters = ["c", "f", "j"]
# target = "k"
# Output: "c"
# 
# 
# 
# Note:
# 
# letters has a length in range [2, 10000].
# letters consists of lowercase letters, and contains at least 2 unique
# letters.
# target is a lowercase letter.
# 
# 
#
class Solution(object):
    def nextGreatestLetter(self, letters, target):
        """
        :type letters: List[str]
        :type target: str
        :rtype: str
        """
        for c in letters:
            if c > target:
                return c
        return letters[0]
