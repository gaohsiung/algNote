/*
 * @lc app=leetcode id=328 lang=java
 *
 * [328] Odd Even Linked List
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode oddCur = oddHead;
        ListNode evenCur = evenHead;
        ListNode cur = head.next.next;
        while (cur != null) {
            oddCur.next = cur;
            oddCur = oddCur.next;
            cur = cur.next; 
            if (cur == null) {
                break;
            }
            evenCur.next = cur;
            evenCur = evenCur.next;
            cur = cur.next;
        }
        oddCur.next = evenHead;
        evenCur.next = null;
        return head;
    }
}
// @lc code=end

