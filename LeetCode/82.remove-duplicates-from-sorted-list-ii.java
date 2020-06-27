/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while (fast != null) {
            while (fast.next != null && fast.next.val == fast.val) {
                fast = fast.next;
            }
            if (slow.next == fast) {
                slow = slow.next;
            } else {
                slow.next = fast.next;
            }
            fast = fast.next;
        } 
        return dummy.next;
    }
}
// @lc code=end

