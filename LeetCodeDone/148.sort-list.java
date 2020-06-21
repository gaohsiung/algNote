/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode secondHead = divide(head);
        ListNode subHead1 = sortList(head);
        ListNode subHead2 = sortList(secondHead);
        return merge(subHead1, subHead2);
    }

    private ListNode merge(ListNode subHead1, ListNode subHead2) {
        ListNode returnHead;
        ListNode cur1;
        ListNode cur2;
        if (subHead1.val <= subHead2.val) {
            returnHead = subHead1;
            cur1 = subHead1.next;
            cur2 = subHead2;
        } else {
            returnHead = subHead2;
            cur1 = subHead1;
            cur2 = subHead2.next; 
        }
        ListNode returnCur = returnHead;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                returnCur.next = cur1;
                cur1 = cur1.next;
            } else {
                returnCur.next = cur2;
                cur2 = cur2.next;
            }
            returnCur = returnCur.next;
        }
        if (cur1 == null) {
            returnCur.next = cur2;
        } else {
            returnCur.next = cur1;
        }
        return returnHead;
    }

    private ListNode divide(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null) {
            ListNode secondHead = slow.next;
            slow.next = null;
            return secondHead;
        } else {
            ListNode secondHead = slow.next.next;
            slow.next.next = null;
            return secondHead;
        }
    }


}
// @lc code=end

