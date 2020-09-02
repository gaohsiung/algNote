/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) {
            return head;
        }
        ListNode tail = head;
        int size = 0;
        while(tail.next != null) {
            size++;
            tail = tail.next;
        }
        int rotateNum = (size+1) - k % (size+1);
        if (rotateNum == size+1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while(rotateNum > 0) {
            cur = cur.next;
            rotateNum -- ;
        }
        ListNode newHead = cur.next;
        dummy.next = cur.next;
        cur.next = null;
        tail.next = head;
        return newHead;
        
    }
}
// @lc code=end

