#
# @lc app=leetcode id=686 lang=python
#
# [686] Repeated String Match
#
# https://leetcode.com/problems/repeated-string-match/description/
#
# algorithms
# Easy (31.29%)
# Total Accepted:    57.3K
# Total Submissions: 183K
# Testcase Example:  '"abcd"\n"cdabcdab"'
#
# Given two strings A and B, find the minimum number of times A has to be
# repeated such that B is a substring of it. If no such solution, return -1.
# 
# For example, with A = "abcd" and B = "cdabcdab".
# 
# Return 3, because by repeating A three times (“abcdabcdabcd”), B is a
# substring of it; and B is not a substring of A repeated two times
# ("abcdabcd").
# 
# Note:
# The length of A and B will be between 1 and 10000.
# 
#
class Solution(object):
    def repeatedStringMatch(self, A, B):
        """
        :type A: str
        :type B: str
        :rtype: int
        """
        times = -(-len(B) / len(A))        
        for i in range(2):
            if B in (A*(times+i)):
                return times+i
        return -1
