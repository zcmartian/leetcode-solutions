#
# @lc app=leetcode id=203 lang=python
#
# [203] Remove Linked List Elements
#
# https://leetcode.com/problems/remove-linked-list-elements/description/
#
# algorithms
# Easy (35.04%)
# Total Accepted:    199.7K
# Total Submissions: 570K
# Testcase Example:  '[1,2,6,3,4,5,6]\n6'
#
# Remove all elements from a linked list of integers that have value val.
# 
# Example:
# 
# 
# Input:  1->2->6->3->4->5->6, val = 6
# Output: 1->2->3->4->5
# 
# 
#
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        dummy = ListNode(-1)
        dummy.next = head
        current = head
        pre = dummy
        while current:
            if current.val == val:
                pre.next = current.next
            else:
                pre = pre.next
            current = current.next
        return dummy.next
