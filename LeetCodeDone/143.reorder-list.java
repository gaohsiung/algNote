/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode endOfFirstHalf = findEndOfFirstHalf(head);
        ListNode secondHalfHead = reverse(endOfFirstHalf.next);
        endOfFirstHalf.next = null;
        mergeTwoLinkedList(head, secondHalfHead);

    }

	private void mergeTwoLinkedList(ListNode l1, ListNode l2) {
        ListNode p1 = l1.next;
        ListNode p2 = l2;
        ListNode connectHead = l1;

        while (p2 != null) {
            connectHead.next = p2;
            p2 = p2.next;
            connectHead = connectHead.next;
            if (p1 == null) {
                break;
            }
            connectHead.next = p1;
            p1 = p1.next;
            connectHead = connectHead.next;
        }

    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private ListNode findEndOfFirstHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next == null) {
            return slow;
        } else {
            return slow.next;
        }
    }
    public static void main(String[] sss) {
        Solution s = new Solution();
        ListNode l3 = new ListNode(3, null);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        s.reorderList(l1);
    }

}
// @lc code=end

