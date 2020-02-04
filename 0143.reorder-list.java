/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
 *
 * https://leetcode.com/problems/reorder-list/description/
 *
 * algorithms
 * Medium (30.14%)
 * Total Accepted:    146.7K
 * Total Submissions: 486.8K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * Example 1:
 * 
 * 
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * 
 * Example 2:
 * 
 * 
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
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
    public void reorderList(ListNode head) {
        if(head==null) return;
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while(head != null) {
            stack.add(head);
            head = head.next;
        }
        if(stack.isEmpty()) return;
        ListNode tail = stack.pop();
        ListNode cur = dummy.next;
        while(cur != tail) {
            if(tail.next == cur) break;
            tail = stack.pop();
            ListNode next = cur.next;
            cur.next = tail.next;
            cur.next.next = next;
            cur = next;
            continue;
        }
        cur.next = null;
    }
}
