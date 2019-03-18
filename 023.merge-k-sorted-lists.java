/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (33.21%)
 * Total Accepted:    349.5K
 * Total Submissions: 1.1M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        ListNode ret = new ListNode(Integer.MIN_VALUE);
        ListNode tail = ret;

        PriorityQueue<ListNode> queue = new PriorityQueue<>((l, r) -> l.val - r.val);
        for(ListNode node : lists)
            if(node != null)
                queue.offer(node);
        while(!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if(tail.next != null)
                queue.offer(tail.next);
        }
        return ret.next;
    }
}
