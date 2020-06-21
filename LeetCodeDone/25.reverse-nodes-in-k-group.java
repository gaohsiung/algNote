/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
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
// class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

class Solution {


    public ListNode reverseKGroup(ListNode head, int k) {
        int tempK = k;
        ListNode prev = head;
        ListNode cur = head;
        while (tempK-- > 0) {
            if (cur == null) {
                return head;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        prev.next = null;
        ListNode subHead = reverseKGroup(cur, k);
        ListNode newHead = reverse(head);
        head.next = subHead;
        return newHead;
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
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        s.reverseKGroup(l1, 2);
    }
}
// @lc code=end

