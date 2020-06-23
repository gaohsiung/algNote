/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null && fast.next.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow != fast) {
            return null;
        }
        slow = head;
        ListNode meetingPoint = fast;
        fast = fast.next;
        while (slow != fast) {
            if (fast == meetingPoint) {
                fast = head;
            } else {
                fast = fast.next;
            }
            slow = slow.next;
        }
        return slow;
    }
}
// @lc code=end

