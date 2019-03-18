/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 *
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (35.49%)
 * Total Accepted:    170.6K
 * Total Submissions: 480.7K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the
 * linked list. If the number of nodes is not a multiple of k then left-out
 * nodes in the end should remain as it is.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * Note:
 * 
 * 
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be
 * changed.
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
 *
 *----------------------------
 *prev
 *tail   head
 *dummy   1    2    3   4    5
 *----------------------------
 *prev   head      tail
 *dummy   1    2    3   4    5
 *       cur
 *----------------------------
 * 每次让prev.next的元素插入到当前tail之后,这样tail不断前移,被挪动的元素头插入tail之后的链表
 *prev        tail head
 *dummy   2    3    1   4    5
 *       cur
 *----------------------------
 *prev   tail      head
 *dummy   3    2    1   4    5
 *       cur
 *----------------------------
 *                 prev
 *                 tail
 *                 head
 *dummy   3    2    1   4    5
 *----------------------------
 *                 prev  head     tail
 *dummy   3    2    1     4    5  null
 *----------------------------
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null||k<2) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode tail = dummy;
        ListNode cur;
        int n;
        while(true) {
            n = k;
            while(n>0 && tail != null) {
                n--;
                tail = tail.next;
            }
            if(tail == null)
                break;
            head = prev.next;
            while(prev.next != tail) {
                cur = prev.next;// 保存待处理的节点
                prev.next = cur.next;// 断开prev与待处理节点的连接
                cur.next = tail.next;//2步完成头插法 a. 将待处理节点尾部接上tail之后的节点
                tail.next = cur;//b.tail接上待处理的节点
            }
            tail = head;
            prev = head;
        }
        return dummy.next;
    }
}
