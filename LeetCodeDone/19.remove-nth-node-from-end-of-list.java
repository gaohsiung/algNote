/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        int tempN = n;
        while (tempN -- > 0) {
            if (fast == null) {
                return head.next;
            }
            fast = fast.next;
        }
        // preprocessing
        if (fast == null) {
            return head.next;
        }
        ListNode cur = head;
        ListNode prev = head;
        while (fast != null) {
            fast = fast.next;
            prev = cur;
            cur = cur.next;
        }
        prev.next = cur.next;
        cur.next = null;
        return head;
    }
    public static void main(String[] sss) {
        Solution sol = new Solution();
        ListNode l1 = new ListNode(1);
        System.out.println(sol.removeNthFromEnd(l1, 1));
    }

}
// @lc code=end

