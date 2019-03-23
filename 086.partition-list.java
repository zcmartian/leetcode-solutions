/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
 *
 * https://leetcode.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (36.54%)
 * Total Accepted:    155.7K
 * Total Submissions: 426K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example:
 * 
 * 
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
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
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        boolean inverse = false;
        ListNode insert = dummy;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null) {
            if(cur.val < x && !inverse) {
                insert = insert.next;
                pre = pre.next;
                cur = cur.next;
            } else if(cur.val < x && inverse) {
                ListNode p = insert.next;
                insert.next = cur;
                pre.next = cur.next;
                cur.next = p;
                insert = insert.next;
                cur = pre.next;
            } else if(cur.val >= x && !inverse) {
                pre = pre.next;
                cur = cur.next;
                inverse = true;
            } else if(cur.val >= x && inverse) {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}
