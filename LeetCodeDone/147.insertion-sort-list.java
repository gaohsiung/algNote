/*
 * @lc app=leetcode id=147 lang=java
 *
 * [147] Insertion Sort List
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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode returnHead = head;
        ListNode cur = head.next;
        ListNode tempNode;
        returnHead.next = null;
        while (cur != null) {
            tempNode = cur.next;
            returnHead = insert(returnHead, cur);
            cur = tempNode;
        }
        return returnHead;
    }

    private ListNode insert(ListNode head, ListNode node) {
        if (head.val > node.val) {
            node.next = head;
            return node;
        }
        ListNode cur = head;
        while (cur.next != null && cur.next.val <= node.val) {
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
        return head;
    }
    public static void main(String[] arguments) {
        ListNode l5 = new ListNode(1, null);
        ListNode l4 = new ListNode(2, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(4, l3);
        ListNode l1 = new ListNode(5, l2);

        Solution s = new Solution();
        s.insertionSortList(l1);
    }
}
// @lc code=end

