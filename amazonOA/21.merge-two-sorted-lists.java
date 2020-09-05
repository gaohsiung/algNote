/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2:l1;
        }
        
        ListNode returnHead;
        ListNode cur1;
        ListNode cur2;
        if (l1.val <= l2.val) {
            returnHead = l1;
            cur1 = l1.next;
            cur2 = l2;
        } else {
            returnHead = l2;
            cur1 = l1;
            cur2 = l2.next;
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
    public static void main(String[] sss) {
        Solution s = new Solution();
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        ListNode l15 = new ListNode(10, null);
        ListNode l14 = new ListNode(9, l15);
        ListNode l13 = new ListNode(8, l14);
        ListNode l12 = new ListNode(7, l13);
        ListNode l11 = new ListNode(6, l12);

        s.mergeTwoLists(l1, l11);

    }
}
// @lc code=end

