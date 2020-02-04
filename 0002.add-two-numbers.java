/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (30.68%)
 * Total Accepted:    785.4K
 * Total Submissions: 2.6M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while(l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            cur.next = new ListNode(val % 10);
            carry = val / 10;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        while(l1 != null) {
            int val = carry + l1.val;
            cur.next = new ListNode(val % 10);
            carry = val / 10;
            l1 = l1.next;
            cur = cur.next;
        }
        while(l2 != null) {
            int val = carry + l2.val;
            cur.next = new ListNode(val % 10);
            carry = val / 10;
            l2 = l2.next;
            cur = cur.next;
        }
        if(carry > 0 ) {
            cur.next = new ListNode(carry);
            cur = cur.next;
        }
        return dummy.next;
    }
}
