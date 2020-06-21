/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHeadLess = new ListNode(0, null);
        ListNode dummyHeadGreater = new ListNode(0, null);
        ListNode lessCur = dummyHeadLess;
        ListNode greaterCur = dummyHeadGreater;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                lessCur.next = cur;
                lessCur = lessCur.next;
            } else {
                greaterCur.next = cur;
                greaterCur = greaterCur.next;
            }
            cur = cur.next;
        }
        lessCur.next = dummyHeadGreater.next;
        greaterCur.next = null;
        return dummyHeadLess.next;
    }
}
// @lc code=end

