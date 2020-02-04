/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (32.37%)
 * Total Accepted:    171.8K
 * Total Submissions: 530.7K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 1->1->1->2->3
 * Output: 2->3
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = pre.next;
        ListNode nxt = cur.next;
        boolean found = false;

        while(cur != null && nxt != null) {
            if(cur.val == nxt.val) {
                found = true;
                cur.next = nxt.next;
                nxt = nxt.next;
            } else {
                if(found) {
                    pre.next = nxt;
                    cur = nxt;
                    nxt = nxt.next;
                    found = false;
                } else {
                    pre = pre.next;
                    cur = cur.next;
                    nxt = nxt.next;
                }
            }
        }
        if(found) {
            pre.next = null;
        }
        return dummy.next;
    }
}
