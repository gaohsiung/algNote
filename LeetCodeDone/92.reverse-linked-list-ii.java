/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode firstEndNode = dummy;
        int temp = m;
        while (temp-- > 1) {
            firstEndNode = firstEndNode.next;
        }
        ListNode reverseEndNode = firstEndNode;
        int diff = n - m + 1;
        while (diff-- > 0) {
            reverseEndNode = reverseEndNode.next;
        }
        ListNode remainHead = reverseEndNode.next;
        reverseEndNode.next = null;
        ListNode reversedHead = reverse(firstEndNode.next);
        firstEndNode.next.next = remainHead;
        firstEndNode.next = reversedHead;

        return dummy.next;

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

    public static void main(String[] sss) {
        Solution s = new Solution();
        ListNode l5 = new ListNode(9, null);
        ListNode l4 = new ListNode(8, l5);
        ListNode l3 = new ListNode(7, l4);
        ListNode l2 = new ListNode(6, l3);
        ListNode l1 = new ListNode(5, l2);
        s.reverseBetween(l1, 2, 4);
    }
}
// @lc code=end

