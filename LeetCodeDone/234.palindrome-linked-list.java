/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode leftTail = findLeftTail(head);
        ListNode rightReversedHead = reverse(leftTail.next);
        ListNode leftP = head;
        ListNode rightP = rightReversedHead;
        while (rightP != null) {
            if (leftP.val != rightP.val) {
                return false;
            }
            leftP = leftP.next;
            rightP = rightP.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private ListNode findLeftTail(ListNode head) {
        int size = 0;
        ListNode cur = head;
        while(cur != null) {
            size++;
            cur = cur.next;
        }
        int leftTailIndex;
        if (size % 2 == 0) {
            leftTailIndex = size / 2 - 1;
        } else {
            leftTailIndex = size / 2;
        }
        cur = head;
        while (leftTailIndex-- > 0) {
            cur = cur.next;
        }
        return cur;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, null);
        ListNode l1 = new ListNode(1, l2);
        System.out.println(sol.isPalindrome(l1));
    }
}
// @lc code=end

