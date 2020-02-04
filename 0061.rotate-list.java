/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
 *
 * https://leetcode.com/problems/rotate-list/description/
 *
 * algorithms
 * Medium (26.66%)
 * Total Accepted:    181.3K
 * Total Submissions: 679.9K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        int len = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = head;
        while(p != null) {
            len++;
            p = p.next;
        }
        p = dummy;
        k %= len;
        if(k == 0)
            return head;
        int count = len - k;
        while(count > 0 ) {
            p = p.next;
            count--;
        }
        ListNode q = dummy.next;
        dummy.next = p.next;
        ListNode m = p;
        while(k > 0) {
            m = m.next;
            k--;
        }
        m.next = q;
        p.next = null;
        return dummy.next;        
    }
}
