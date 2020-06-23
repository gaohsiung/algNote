/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2:l1;
        }
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        boolean isCarry = false;
        ListNode dummy = new ListNode(0, null);
        ListNode cur = dummy;
        while (cur1 != null || cur2 != null) {
            ListNode newNode;
            if (cur1 == null) {
                if (isCarry) {
                    newNode = new ListNode((cur2.val + 1) % 10);
                    cur.next = newNode;
                    isCarry = (cur2.val+1)/10 == 1? true:false;
                } else {
                    cur.next = cur2;
                }
                cur2 = cur2.next;
                cur = cur.next;
                continue;
            }
            if (cur2 == null) {
                if (isCarry) {
                    newNode = new ListNode((cur1.val + 1) % 10);
                    cur.next = newNode;
                    isCarry = (cur1.val+1)/10 == 1? true:false;
                } else {
                    cur.next = cur1;
                }
                cur1 = cur1.next;
                cur = cur.next;
                continue;
            }

            int oldVal = cur1.val + cur2.val;
            if (isCarry) {
                newNode = new ListNode((oldVal+1)%10);
                cur.next = newNode;
                isCarry = (oldVal+1)/10 == 1?true:false;
            } else {
                newNode = new ListNode((oldVal)%10);
                cur.next = newNode;
                isCarry = (oldVal)/10 == 1?true:false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
            cur = cur.next;
        }
        if (isCarry) {
            cur.next = new ListNode(1, null);
        }
        return dummy.next;
    }
    public static void main(String[] ss) {
        Solution s = new Solution();
        ListNode l6 = new ListNode(6, null);
        ListNode l5 = new ListNode(5, l6);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, null);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        s.addTwoNumbers(l1, l4);
    }
}
// @lc code=end

